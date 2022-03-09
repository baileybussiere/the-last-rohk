package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import levels.Level;
import levels.LevelList;
import data.LibLibrary;
import data.Tile;
import data.TileSign;
import entities.Entity;
import entities.EntityBolt;
import entities.EntityEnemy;

@SuppressWarnings("serial")
public class Screen extends JPanel implements Runnable
{
	int currentLvl = 0;
	int maxLvl = 10;
	LibLibrary libLibrary;
	Thread gameT;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenWidth = (int) screenSize.getWidth();
	int screenHeight = (int) screenSize.getHeight();
	int gameWidth = 1216;
	int gameHeight = 800;
	boolean gameOver = false;
	long lastTime;
	long currentTime;
	boolean hasBegun = false;
	Level level;
	int lives = 5;
	ArrayList<Animation> animations = new ArrayList<Animation>(0);
	ArrayList<Message> messages = new ArrayList<Message>(0);
	ArrayList<Particle> particles = new ArrayList<Particle>(0);
	int skipTicks = 0;
	int skipTickAmt = 180;
	boolean changingLvls = false;
	long[] lastProcessed = {0, 0, 0, 0};
	boolean[] keysDown = {false, false, false, false, false};
	
	public Screen(JFrame frame, LibLibrary lib)
	{
		this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), "up_pressed");
		this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, true), "up_released");
		this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false), "down_pressed");
		this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, true), "down_released");
		this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "left_pressed");
		this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, true), "left_released");
		this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "right_pressed");
		this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true), "right_released");
		this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false), "escape_pressed");
		this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, true), "escape_released");
		this.getActionMap().put("up_pressed", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				Screen.this.keysDown[1] = true;
			}
		});
		this.getActionMap().put("up_released", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				Screen.this.keysDown[1] = false;
			}
		});
		this.getActionMap().put("down_pressed", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				Screen.this.keysDown[3] = true;
			}
		});
		this.getActionMap().put("down_released", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				Screen.this.keysDown[3] = false;
			}
		});
		this.getActionMap().put("left_pressed", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				Screen.this.keysDown[0] = true;
			}
		});
		this.getActionMap().put("left_released", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				Screen.this.keysDown[0] = false;
			}
		});
		this.getActionMap().put("right_pressed", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				Screen.this.keysDown[2] = true;
			}
		});
		this.getActionMap().put("right_released", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				Screen.this.keysDown[2] = false;
			}
		});
		this.getActionMap().put("escape_pressed", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				Screen.this.keysDown[4] = true;
			}
		});
		this.getActionMap().put("escape_released", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				Screen.this.keysDown[4] = false;
			}
		});
		frame.addMouseListener(new MouseListener()
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				
			}
			@Override
			public void mouseEntered(MouseEvent arg0)
			{
				
			}
			@Override
			public void mouseExited(MouseEvent arg0)
			{
				
			}
			@Override
			public void mousePressed(MouseEvent arg0)
			{
				
			}
			@Override
			public void mouseReleased(MouseEvent arg0)
			{
				
			}
		});
		this.libLibrary = lib;
		this.level = this.copyLvl(LevelList.getLevel(lib, this.currentLvl));
		//this.levels[0].spawn(new EntityBolt(6D, 6D, -1, 0, 2, lib));
		this.gameT = new Thread(this);
		this.gameT.start();
	}

	private Level copyLvl(Level l)
	{
		Tile[][] a1 = new Tile[38][25];
		Tile[][] a2 = new Tile[38][25];
		Entity[] e = new Entity[l.entities.length];
		for (int i = 0; i < l.entities.length; i++)
			if (l.entities[i] != null)
				e[i] = l.entities[i].dupl();
		Entity[] e2 = new Entity[l.ents2.length];
		for (int i = 0; i < l.ents2.length; i++)
			if (l.ents2[i] != null)
				e2[i] = l.ents2[i].dupl();
		for (int x = 0; x < l.tiles.length; x++)
			for (int y = 0; y < l.tiles[0].length; y++)
			{
				a1[x][y] = l.tiles[x][y];
				if (l.tiles2[x][y] != null)
				{
					Tile sfk = l.tiles2[x][y].dupl();
					if (l.tiles2[x][y].id >= 8 && l.tiles2[x][y].id <= 11 && l.tiles2[x-1][y-1] == l.tiles2[x][y] && l.tiles[x-1][y]== l.tiles[x][y-1] && l.tiles[x][y-1] == l.tiles[x-1][y-1])
					{
						a2[x][y] = sfk;
						a2[x-1][y] = sfk;
						a2[x][y-1] = sfk;
						a2[x-1][y-1] = sfk;
					}
					else
						a2[x][y] = sfk;
				}
			}
		Level cl = new Level(null, null, e, this.libLibrary);
		cl.tiles = a1;
		cl.tiles2 = a2;
		cl.spawn(e2);
		return cl;
	}

	private void update()
	{
		if (this.keysDown[0])
		{
			if (System.currentTimeMillis() - lastProcessed[0] > 36)
			{
				if(!Screen.this.hasBegun && Screen.this.skipTicks <= 0)
				{
					Screen.this.lastTime = System.currentTimeMillis();
					Screen.this.hasBegun = true;
				}
				Screen.this.level.entities[0].vX = -Screen.this.level.entities[0].maxSpeed;
				Screen.this.level.entities[0].vY = 0;
				lastProcessed[0] = System.currentTimeMillis();
			}
		}
		if (this.keysDown[1])
		{
			if (System.currentTimeMillis() - lastProcessed[1] > 36)
			{
				if(!Screen.this.hasBegun && Screen.this.skipTicks <= 0)
				{
					Screen.this.lastTime = System.currentTimeMillis();
					Screen.this.hasBegun = true;
				}
				Screen.this.level.entities[0].vY = -Screen.this.level.entities[0].maxSpeed;
				Screen.this.level.entities[0].vX = 0;
				lastProcessed[1] = System.currentTimeMillis();
			}
		}
		if (this.keysDown[2])
		{
			if (System.currentTimeMillis() - lastProcessed[2] > 36)
			{
				if(!Screen.this.hasBegun && Screen.this.skipTicks <= 0)
				{
					Screen.this.lastTime = System.currentTimeMillis();
					Screen.this.hasBegun = true;
				}
				Screen.this.level.entities[0].vX = Screen.this.level.entities[0].maxSpeed;
				Screen.this.level.entities[0].vY = 0;
				lastProcessed[2] = System.currentTimeMillis();
			}
		}
		if (this.keysDown[3])
		{
			if (System.currentTimeMillis() - lastProcessed[3] > 36)
			{
				if(!Screen.this.hasBegun && Screen.this.skipTicks <= 0)
				{
					Screen.this.lastTime = System.currentTimeMillis();
					Screen.this.hasBegun = true;
				}
				Screen.this.level.entities[0].vY = Screen.this.level.entities[0].maxSpeed;
				Screen.this.level.entities[0].vX = 0;
				lastProcessed[3] = System.currentTimeMillis();
			}
		}
		if (this.keysDown[4])
		{
			if (Screen.this.gameOver)
			{
				System.exit(0);
			}
			else
			{
				Screen.this.currentTime = -1000000000;
				Screen.this.gameOver = true;
			}
		}
		if (!this.libLibrary.audio.songList.get(0).isActive() && this.currentLvl < 8)
		{
			this.libLibrary.audio.songList.get(0).stop();
			this.libLibrary.audio.songList.get(0).setFramePosition(0);
			this.libLibrary.audio.songList.get(0).start();
		}
		else if (!this.libLibrary.audio.songList.get(1).isActive() && this.currentLvl < 16 && this.currentLvl > 7)
		{
			this.libLibrary.audio.songList.get(0).stop();
			this.libLibrary.audio.songList.get(1).stop();
			this.libLibrary.audio.songList.get(1).setFramePosition(0);
			this.libLibrary.audio.songList.get(1).start();
		}
		if (this.skipTicks <= 0)
		{
			this.changingLvls = false;
		if(this.hasBegun && !this.gameOver)
		{
			for (int i = 0; i < this.level.entities.length; i++)
			{
				if (this.level.entities[i] != null)
					this.level.entities[i] = this.level.entities[i].update(.006, this.level);
			}
			for (int i = 0; i < this.level.ents2.length; i++)
			{
				if (this.level.ents2[i] != null)
					this.level.ents2[i] = this.level.ents2[i].update(.006, this.level);
			}
			for (int y = 0; y < 25; y++)
			{
				for (int x = 0; x < 38; x++)
				{
					if (this.level.tiles2[x][y] != null && this.level.tiles2[x][y].needsTick)
					{
						this.level.tiles2[x][y] = this.level.tiles2[x][y].tick(this.level, x, y, this.libLibrary);
					}
				}
			}
		}
		if (this.level.entities[0].dead && !this.gameOver)
		{
			Entity e;
			if (this.level.entities[0].killer != null)
				e = this.level.entities[0].killer;
			else
				e = this.level.entities[0];
			animations.add(new Animation(libLibrary.tex.animationList.get(0), gX(e.x*32) - 16, gY(e.y*32) - 16, 64, 64));
			Random r = new Random(System.currentTimeMillis());
			for (int i = 0; i < (40 + r.nextInt(4)); i++)
			{
				particles.add(new Particle(libLibrary.tex.imageListParticles.get(0), gX(e.x*32) + 16, gY(e.y*32) + 16, 4 + (r.nextDouble()*1), r.nextDouble()*2*Math.PI, 0.25, 12 + r.nextInt(12)));
			}
			this.lives--;
			this.skipTicks = this.skipTickAmt;
			if (this.lives > 0)
			{
				this.hasBegun = false;
				this.gameOver = false;
			}
			else
			{
				this.gameOver = true;
			}
		}
		if (!this.gameOver)
		{
			int j = this.level.entities[0].events.size();
			if (this.level.entities[0].events != null)
			{
			for (int i = 0; i < j; i++)
			{
				if (this.level.entities[0].events.get(i) == null)
				{
					
				}
				else if (this.level.entities[0].events.get(i).name.equals("nextLvl"))
				{
					this.level.entities[0].events.set(i, null);
					if (this.currentLvl + 1 >= this.maxLvl)
						this.gameOver = true;
					else
					{
						this.currentLvl++;
						this.changingLvls = true;
						this.skipTicks = this.skipTickAmt;
						this.hasBegun = false;
					}
					this.currentTime += System.currentTimeMillis() - this.lastTime;
					this.lastTime = 0;
				}
				else if (this.level.entities[0].events.get(i).name.equals("break"))
				{
					int x = this.level.entities[0].events.get(i).x;
					int y = this.level.entities[0].events.get(i).y;
					Tile t = this.level.tiles2[x][y];
					if (t != null)
					{
						if (t.id >= 8 && t.id <= 11)
						{
							if (this.level.tiles2[x-1][y-1] != null && this.level.tiles2[x-1][y-1].id == t.id)
							{
								this.level.tiles2[x-1][y-1] = null;
								this.level.tiles2[x][y-1] = null;
								this.level.tiles2[x-1][y] = null;
								this.level.tiles2[x][y] = null;
							}
							else if (this.level.tiles2[x+1][y+1] != null && this.level.tiles2[x+1][y+1].id == t.id)
							{
								this.level.tiles2[x+1][y+1] = null;
								this.level.tiles2[x][y+1] = null;
								this.level.tiles2[x+1][y] = null;
								this.level.tiles2[x][y] = null;
							}
							else if (this.level.tiles2[x-1][y+1] != null && this.level.tiles2[x-1][y+1].id == t.id)
							{
								this.level.tiles2[x-1][y+1] = null;
								this.level.tiles2[x][y+1] = null;
								this.level.tiles2[x-1][y] = null;
								this.level.tiles2[x][y] = null;
							}
							else if (this.level.tiles2[x+1][y-1] != null && this.level.tiles2[x+1][y-1].id == t.id)
							{
								this.level.tiles2[x+1][y-1] = null;
								this.level.tiles2[x][y-1] = null;
								this.level.tiles2[x+1][y] = null;
								this.level.tiles2[x][y] = null;
							}
						}
						int a = t.damage();
						if (a == -1)
							this.level.tiles2[x][y] = null;
						else if(a == 1)
						{
							Random r = new Random(System.currentTimeMillis());
							for (int pc = 0; pc < (20 + r.nextInt(4)); pc++)
							{
								particles.add(new Particle(libLibrary.tex.imageListParticles.get(0), gX(x*32) + 16, gY(y*32) + 16, 4 + (r.nextDouble()*1), r.nextDouble()*2*Math.PI, 0.25, 12 + r.nextInt(12)));
							}
						}
					}
					this.level.entities[0].events.set(i, null);
				}
				else if (this.level.entities[0].events.get(i).name.equals("displTxt"))
				{
					for (int a = 0; a < this.messages.size(); a++)
					{
						if (this.messages.get(a).type.equals("sign"))
							this.messages.remove(a);
					}
					this.messages.add(new Message(gX(60), gY(0)-10, this.level.tiles2[this.level.entities[0].events.get(i).x][this.level.entities[0].events.get(i).y].getText(), 300).type("sign"));
				}
			}
			}
		}
		}
		else
		{
			this.skipTicks--;
			if (this.skipTicks >= this.skipTickAmt / 2)
				if((this.hasBegun || this.skipTicks > this.skipTickAmt / 2) && !this.gameOver && !this.changingLvls)
				{
					for (int i = 0; i < this.level.entities.length; i++)
					{
						if (this.level.entities[i] != null)
							this.level.entities[i] = this.level.entities[i].update(.006, this.level);
					}
					for (int i = 0; i < this.level.ents2.length; i++)
					{
						if (this.level.ents2[i] != null)
							this.level.ents2[i] = this.level.ents2[i].update(.006, this.level);
					}
				}
			else
				this.level = copyLvl(LevelList.getLevel(this.libLibrary, this.currentLvl));
		}
		for (int i = 0; i < this.messages.size(); i++)
		{
			if (this.messages.get(i).tick() == null)
				this.messages.remove(i);
		}
		for (int i = 0; i < this.animations.size(); i++)
		{
			if (this.animations.get(i).tick() == null)
				this.animations.remove(i);
		}
		for (int i = 0; i < this.particles.size(); i++)
		{
			if (this.particles.get(i).tick() == null)
				this.particles.remove(i);
		}
	}
	
	public int gX(double x)
	{
		if (x < 0)
			return -1;
		else if (x > this.gameWidth)
			return -1;
		else
			return (int) (x + ((this.screenWidth/2) - (this.gameWidth/2)));
	}
	
	public int gY(double y)
	{
		if (y < 0)
			return -1;
		else if (y > this.gameHeight)
			return -1;
		else
			return (int) (y + ((this.screenHeight/2) - (this.gameHeight/2)));
	}
	
	public int Xg(double x)
	{
		if (x < 0)
			return -1;
		else if (x > this.screenWidth)
			return -1;
		else
			return (int) (x - ((this.screenWidth/2) - (this.gameWidth/2)));
		
	}
	
	public int Yg(double y)
	{
		if (y < 0)
			return -1;
		else if (y > this.screenHeight)
			return -1;
		else
			return (int) (y - ((this.screenHeight/2) - (this.gameHeight/2)));
	}
	
	public void paintComponent(Graphics g)
	{
		
		g.setColor(Color.black);
		g.fillRect(0, 0, this.screenWidth, this.screenHeight);
		g.setColor(Color.white);
		String elapsedTime;
		if (this.hasBegun && !this.gameOver)
		{
			elapsedTime = format(this.currentTime + System.currentTimeMillis() - this.lastTime);
			g.drawString(elapsedTime, gX(0) - 10, gY(0) - 10);
			g.fillRect(gX(0), gY(0), 1200, 800);
		}
		else if (this.gameOver)
		{
			g.setFont(new Font("Serif", Font.PLAIN, 60));
			g.setColor(Color.white);
			int a = g.getFontMetrics().stringWidth("Game Over")/2;
			g.drawString("Game Over", gX(608 - a), gY(370));
			int i = g.getFontMetrics().stringWidth("PERFORMANCE UNSATISFACTORY")/2;
			int j;
			if (this.currentTime > 0)
				j = g.getFontMetrics().stringWidth("Time: " + format(this.currentTime))/2;
			else
				j = g.getFontMetrics().stringWidth("Did not finish")/2;
			if (this.lives <= 0)
				g.drawString("PERFORMANCE UNSATISFACTORY", gX(608 - i), gY(430));
			else if (this.currentTime > 0)
				g.drawString("Time: " + format(this.currentTime), gX(608 - j), gY(430));
			else
				g.drawString("Did not finish", gX(608 - j), gY(430));
		}
		else
		{
			elapsedTime = format(this.currentTime);
			g.drawString(elapsedTime, gX(0) - 10, gY(0) - 10);
			g.fillRect(gX(0), gY(0), 1200, 800);
		}
		if (!this.gameOver)
		{
			for (int y = 0; y < 25; y++)
			{
				for (int x = 0; x < 38; x++)
				{
					if (this.level != null)
					{
						g.drawImage(this.level.tiles[x][y].texture, gX(32*x), gY(y*32), 32, 32, null);
						for (int i = 0; i < 4; i++)
						{
							if (this.level.tiles[x][y].borders[i] != null)
							{
								if (this.level.tiles[x][y].borders[i])
								{
									g.drawImage(this.libLibrary.tex.imageListTile.get(i), gX(32*x), gY(32*y), 32, 32, null);
								}
							}
							if (this.level.tiles[x][y].corners[i] != null)
							{
								if (this.level.tiles[x][y].corners[i])
								{
									g.drawImage(this.libLibrary.tex.imageListTile.get(i + 4), gX(32*x), gY(32*y), 32, 32, null);
								}
							}
						}
					}
				}
			}
			if (this.level != null)
			{
				for (int i = 0; i < this.level.entities.length; i++)
					if (this.level.entities[i] != null && this.level.entities[i].visible)
						g.drawImage(this.level.entities[i].texture, gX(this.level.entities[i].x*32), gY(this.level.entities[i].y*32), null);
				for (int i = 0; i < this.level.ents2.length; i++)
					if (this.level.ents2[i] != null && this.level.ents2[i].visible)
						g.drawImage(this.level.ents2[i].texture, gX(this.level.ents2[i].x*32), gY(this.level.ents2[i].y*32), null);
			}
			for (int y = 0; y < 25; y++)
			{
				for (int x = 0; x < 38; x++)
				{
					if (this.level != null)
					{
						if (this.level.tiles2[x][y] != null)
						{
							if (this.level.tiles2[x][y].id >= 8 && this.level.tiles2[x][y].id <= 11 && this.level.tiles2[x-1][y-1] != null)
							{
								if (this.level.tiles2[x][y].id == this.level.tiles2[x-1][y-1].id && this.level.tiles2[x][y].id >= 8 && this.level.tiles2[x][y].id <= 11)
									g.drawImage(this.level.tiles2[x][y].texture, gX(32*(x-1)), gY((y-1)*32), 64, 64, null);
								else
									g.drawImage(this.level.tiles2[x][y].texture, gX(32*x), gY(y*32), 32, 32, null);
							}
							else
								g.drawImage(this.level.tiles2[x][y].texture, gX(32*x), gY(y*32), 32, 32, null);
						}
					}
				}
			}
			displMessages(g);
			
			if (this.level.entities[0].key.equals("copper"))
			{
				g.drawImage(this.libLibrary.tex.imageListTile.get(15), gX(1056 - 64), gY(0) -34, 32, 32, null);
			}
			else if (this.level.entities[0].key.equals("silver"))
			{
				g.drawImage(this.libLibrary.tex.imageListTile.get(16), gX(1056 - 64), gY(0) - 34, 32, 32, null);
			}
			else if (this.level.entities[0].key.equals("gold"))
			{
				g.drawImage(this.libLibrary.tex.imageListTile.get(17), gX(1056 - 64), gY(0) - 34, 32, 32, null);
			}
			else if (this.level.entities[0].key.equals("rusted"))
			{
				g.drawImage(this.libLibrary.tex.imageListTile.get(18), gX(1056 - 64), gY(0) - 34, 32, 32, null);
			}
			if (this.skipTicks > 0 && this.skipTicks < this.skipTickAmt / 2)
			{
				g.setColor(new Color(0.0f, 0.0f, 0.0f, (float) this.skipTicks / (float) this.skipTickAmt));
				g.fillRect(gX(0), gY(0), this.gameWidth, this.gameHeight);
			}
			else if (this.skipTicks >= this.skipTickAmt / 2)
			{
				g.setColor(new Color(0.0f, 0.0f, 0.0f, 1 - (float) this.skipTicks / (float) this.skipTickAmt));
				g.fillRect(gX(0), gY(0), this.gameWidth, this.gameHeight);
			}
		}
		for (int i = 0; i < this.lives; i++)
		{
			if (this.gameOver)
				g.drawImage(this.libLibrary.tex.imageListGUI.get(0), gX(608 - (this.lives * 16) + (i * 32)), gY(250), 32, 32, null);
			else
				g.drawImage(this.libLibrary.tex.imageListGUI.get(0), gX(1056 + (i * 32)), gY(0) - 34, 32, 32, null);
		}
		displParticles(g);
		displAnim(g);
	}
	
	private void displAnim(Graphics g)
	{
		for (int i = 0; i < this.animations.size(); i++)
		{
			if (this.animations.get(i) != null)
			{
				g.drawImage(this.animations.get(i).frames[this.animations.get(i).tick], (int) this.animations.get(i).x, (int) this.animations.get(i).y, this.animations.get(i).width, this.animations.get(i).height, null);
			}
		}
	}
	
	private void displParticles(Graphics g)
	{
		for (int i = 0; i < this.particles.size(); i++)
		{
			if (this.particles.get(i) != null)
			{
				g.drawImage(this.particles.get(i).frames[0], (int) this.particles.get(i).x, (int) this.particles.get(i).y, this.particles.get(i).width, this.particles.get(i).height, null);
			}
		}
	}

	private void displMessages(Graphics g)
	{
		for (int i = 0; i < this.messages.size(); i++)
		{
			if (this.messages.get(i) != null)
			{
				g.drawString(this.messages.get(i).name, this.messages.get(i).x, this.messages.get(i).y);
			}
		}
	}
	
	private String format(long l)
	{
		int minutes = (int) (l / 60000);
		int seconds = (int) (l % 60000) / 1000;
		int millis = (int) (l % 1000);
		String minutesS = Integer.toString(minutes);
		String secondsS = Integer.toString(seconds / 10) + Integer.toString(seconds % 10);
		String millisS = Integer.toString(millis / 100) + Integer.toString(millis % 100 / 10) + Integer.toString(millis % 10);
		return minutesS + ":" + secondsS + "." + millisS;
	}

	@Override
	public void run()
	{
		int tixPerSc = 180;
		int fraimPerSc = 60;
		long gaimSkipTix = 1000 / tixPerSc;
		long fraimSkipTix = 1000 / fraimPerSc;
		int gaimSkipMax = 8;
		long nextGaimTik = System.currentTimeMillis();
		long nextFraimTik = System.currentTimeMillis();
		long time = System.currentTimeMillis();
		int loops;
		
		while(true)
		{
			loops = 0;
			while(System.currentTimeMillis() > nextGaimTik && loops < gaimSkipMax)
			{
				update();
				nextGaimTik += gaimSkipTix;
				loops++;
			}
			
			if(System.currentTimeMillis() > nextFraimTik)
			{
				nextFraimTik += fraimSkipTix;
				repaint();
			}
			
			if(time + 1000 <= System.currentTimeMillis())
			{
				time += 1000;
			}
		}
	}
}
