package entities;

import java.awt.Image;
import java.util.ArrayList;

import levels.Level;
import data.Event;
import data.LibLibrary;

public class Entity
{
	public double x = -1;
	public ArrayList<Event> events = new ArrayList<>();
	public double y = -1;
	public LibLibrary lib;
	public int texInd;
	public Image texture;
	public int vX = 0;
	public int vY = 0;
	public int maxSpeed;
	public boolean dead = false;
	public String key = "";
	public int ticksTillKey = 0;
	public Entity killer = null;
	public boolean visible = true;
	
	public Entity(double x, double y, int i, LibLibrary lib)
	{
		this.maxSpeed = 10;
		this.x = x;
		this.y = y;
		this.lib = lib;
		this.texInd = i;
		this.texture = this.lib.tex.imageListEnt.get(this.texInd);
	}
	
	public Entity dupl()
	{
		return new Entity(this.x, this.y, this.texInd, this.lib);
	}
	
	public Entity update(double t, Level l)
	{
		if (!this.dead)
		{
		this.ticksTillKey--;
		this.x += this.vX*t;
		this.y += this.vY*t;
		if (l.tiles2[roundUp(this.x)][roundUp(this.y)] != null)
		{
			if (l.tiles2[roundUp(this.x)][roundUp(this.y)].id == 2)
			{
				this.lib.audio.clipList.get(4).stop();
				this.lib.audio.clipList.get(4).setFramePosition(0);
				this.lib.audio.clipList.get(4).start();
				this.events.add(new Event("nextLvl", roundUp(this.x), roundUp(this.y)));
			}
			else if (l.tiles2[roundUp(this.x)][roundUp(this.y)].id == -1)
			{
				this.lib.audio.clipList.get(5).stop();
				this.lib.audio.clipList.get(5).setFramePosition(0);
				this.lib.audio.clipList.get(5).start();
				this.events.add(new Event("displTxt", roundUp(this.x), roundUp(this.y)));
			}
			else if (l.tiles2[roundUp(this.x)][roundUp(this.y)].id == 12)
			{
				this.lib.audio.clipList.get(0).stop();
				this.lib.audio.clipList.get(0).setFramePosition(0);
				this.lib.audio.clipList.get(0).start();
				this.dead = true;
			}
			else if (l.tiles2[roundUp(this.x)][roundUp(this.y)].isKey && this.ticksTillKey <= 0)
			{
				this.lib.audio.clipList.get(2).stop();
				this.lib.audio.clipList.get(2).setFramePosition(0);
				this.lib.audio.clipList.get(2).start();
				String k = l.tiles2[roundUp(this.x)][roundUp(this.y)].color();
				if (this.key.equals(""))
					l.tiles2[roundUp(this.x)][roundUp(this.y)] = null;
				else if (this.key.equals("copper"))
					l.tiles2[roundUp(this.x)][roundUp(this.y)] = lib.tile.tileList.get(4);
				else if (this.key.equals("silver"))
					l.tiles2[roundUp(this.x)][roundUp(this.y)] = lib.tile.tileList.get(5);
				else if (this.key.equals("gold"))
					l.tiles2[roundUp(this.x)][roundUp(this.y)] = lib.tile.tileList.get(6);
				else if (this.key.equals("rusted"))
					l.tiles2[roundUp(this.x)][roundUp(this.y)] = lib.tile.tileList.get(7);
				this.key = k;
				this.ticksTillKey = 40;
			}
			else if (l.tiles2[roundUp(this.x)][roundUp(this.y)].id == 17 && l.tiles2[roundUp(this.x)][roundUp(this.y)].tick > 240)
			{
				this.lib.audio.clipList.get(0).stop();
				this.lib.audio.clipList.get(0).setFramePosition(0);
				this.lib.audio.clipList.get(0).start();
				this.dead = true;
			}
		}
		if (l.tiles2[roundUp(this.x)][roundDown(this.y)] != null)
		{
			if (l.tiles2[roundUp(this.x)][roundDown(this.y)].id == 2)
			{
				this.lib.audio.clipList.get(4).stop();
				this.lib.audio.clipList.get(4).setFramePosition(0);
				this.lib.audio.clipList.get(4).start();
				this.events.add(new Event("nextLvl", roundUp(this.x), roundDown(this.y)));
			}
			else if (l.tiles2[roundUp(this.x)][roundDown(this.y)].id == -1)
			{
				this.lib.audio.clipList.get(5).stop();
				this.lib.audio.clipList.get(5).setFramePosition(0);
				this.lib.audio.clipList.get(5).start();
				this.events.add(new Event("displTxt", roundUp(this.x), roundDown(this.y)));
			}
			else if (l.tiles2[roundUp(this.x)][roundDown(this.y)].id == 12)
			{
				this.lib.audio.clipList.get(0).stop();
				this.lib.audio.clipList.get(0).setFramePosition(0);
				this.lib.audio.clipList.get(0).start();
				this.dead = true;
			}
			else if (l.tiles2[roundUp(this.x)][roundDown(this.y)].isKey && this.ticksTillKey <= 0)
			{
				this.lib.audio.clipList.get(2).stop();
				this.lib.audio.clipList.get(2).setFramePosition(0);
				this.lib.audio.clipList.get(2).start();
				String k = l.tiles2[roundUp(this.x)][roundDown(this.y)].color();
				if (this.key.equals(""))
					l.tiles2[roundUp(this.x)][roundDown(this.y)] = null;
				else if (this.key.equals("copper"))
					l.tiles2[roundUp(this.x)][roundDown(this.y)] = lib.tile.tileList.get(4);
				else if (this.key.equals("silver"))
					l.tiles2[roundUp(this.x)][roundDown(this.y)] = lib.tile.tileList.get(5);
				else if (this.key.equals("gold"))
					l.tiles2[roundUp(this.x)][roundDown(this.y)] = lib.tile.tileList.get(6);
				else if (this.key.equals("rusted"))
					l.tiles2[roundUp(this.x)][roundDown(this.y)] = lib.tile.tileList.get(7);
				this.key = k;
				this.ticksTillKey = 40;
			}
			else if (l.tiles2[roundUp(this.x)][roundDown(this.y)].id == 17 && l.tiles2[roundUp(this.x)][roundDown(this.y)].tick > 240)
			{
				this.lib.audio.clipList.get(0).stop();
				this.lib.audio.clipList.get(0).setFramePosition(0);
				this.lib.audio.clipList.get(0).start();
				this.dead = true;
			}
		}
		if (l.tiles2[roundDown(this.x)][roundUp(this.y)] != null)
		{
			if (l.tiles2[roundDown(this.x)][roundUp(this.y)].id == 2)
			{
				this.lib.audio.clipList.get(4).stop();
				this.lib.audio.clipList.get(4).setFramePosition(0);
				this.lib.audio.clipList.get(4).start();
				this.events.add(new Event("nextLvl", roundDown(this.x), roundUp(this.y)));
			}
			else if (l.tiles2[roundDown(this.x)][roundUp(this.y)].id == -1)
			{
				this.lib.audio.clipList.get(5).stop();
				this.lib.audio.clipList.get(5).setFramePosition(0);
				this.lib.audio.clipList.get(5).start();
				this.events.add(new Event("displTxt", roundDown(this.x), roundUp(this.y)));
			}
			else if (l.tiles2[roundDown(this.x)][roundUp(this.y)].id == 12)
			{
				this.lib.audio.clipList.get(0).stop();
				this.lib.audio.clipList.get(0).setFramePosition(0);
				this.lib.audio.clipList.get(0).start();
				this.dead = true;
			}
			else if (l.tiles2[roundDown(this.x)][roundUp(this.y)].isKey && this.ticksTillKey <= 0)
			{
				this.lib.audio.clipList.get(2).stop();
				this.lib.audio.clipList.get(2).setFramePosition(0);
				this.lib.audio.clipList.get(2).start();
				String k = l.tiles2[roundDown(this.x)][roundUp(this.y)].color();
				if (this.key.equals(""))
					l.tiles2[roundDown(this.x)][roundUp(this.y)] = null;
				else if (this.key.equals("copper"))
					l.tiles2[roundDown(this.x)][roundUp(this.y)] = lib.tile.tileList.get(4);
				else if (this.key.equals("silver"))
					l.tiles2[roundDown(this.x)][roundUp(this.y)] = lib.tile.tileList.get(5);
				else if (this.key.equals("gold"))
					l.tiles2[roundDown(this.x)][roundUp(this.y)] = lib.tile.tileList.get(6);
				else if (this.key.equals("rusted"))
					l.tiles2[roundDown(this.x)][roundUp(this.y)] = lib.tile.tileList.get(7);
				this.key = k;
				this.ticksTillKey = 40;
			}
			else if (l.tiles2[roundDown(this.x)][roundUp(this.y)].id == 17 && l.tiles2[roundDown(this.x)][roundUp(this.y)].tick > 240)
			{
				this.lib.audio.clipList.get(0).stop();
				this.lib.audio.clipList.get(0).setFramePosition(0);
				this.lib.audio.clipList.get(0).start();
				this.dead = true;
			}
		}
		if (l.tiles2[roundDown(this.x)][roundDown(this.y)] != null)
		{
			if (l.tiles2[roundDown(this.x)][roundDown(this.y)].id == 2)
			{
				this.lib.audio.clipList.get(4).stop();
				this.lib.audio.clipList.get(4).setFramePosition(0);
				this.lib.audio.clipList.get(4).start();
				this.events.add(new Event("nextLvl", roundDown(this.x), roundDown(this.y)));
			}
			else if (l.tiles2[roundDown(this.x)][roundDown(this.y)].id == -1)
			{
				this.lib.audio.clipList.get(5).stop();
				this.lib.audio.clipList.get(5).setFramePosition(0);
				this.lib.audio.clipList.get(5).start();
				this.events.add(new Event("displTxt", roundDown(this.x), roundDown(this.y)));
			}
			else if (l.tiles2[roundDown(this.x)][roundDown(this.y)].id == 12)
			{
				this.lib.audio.clipList.get(0).stop();
				this.lib.audio.clipList.get(0).setFramePosition(0);
				this.lib.audio.clipList.get(0).start();
				this.dead = true;
			}
			else if (l.tiles2[roundDown(this.x)][roundDown(this.y)].isKey && this.ticksTillKey <= 0)
			{
				this.lib.audio.clipList.get(2).stop();
				this.lib.audio.clipList.get(2).setFramePosition(0);
				this.lib.audio.clipList.get(2).start();
				String k = l.tiles2[roundDown(this.x)][roundDown(this.y)].color();
				if (this.key.equals(""))
					l.tiles2[roundDown(this.x)][roundDown(this.y)] = null;
				else if (this.key.equals("copper"))
					l.tiles2[roundDown(this.x)][roundDown(this.y)] = lib.tile.tileList.get(4);
				else if (this.key.equals("silver"))
					l.tiles2[roundDown(this.x)][roundDown(this.y)] = lib.tile.tileList.get(5);
				else if (this.key.equals("gold"))
					l.tiles2[roundDown(this.x)][roundDown(this.y)] = lib.tile.tileList.get(6);
				else if (this.key.equals("rusted"))
					l.tiles2[roundDown(this.x)][roundDown(this.y)] = lib.tile.tileList.get(7);
				this.key = k;
				this.ticksTillKey = 40;
			}
			else if (l.tiles2[roundDown(this.x)][roundDown(this.y)].id == 17 && l.tiles2[roundDown(this.x)][roundDown(this.y)].tick > 240)
			{
				this.lib.audio.clipList.get(0).stop();
				this.lib.audio.clipList.get(0).setFramePosition(0);
				this.lib.audio.clipList.get(0).start();
				this.dead = true;
			}
		}
		for (int i = 1; i < l.entities.length; i++)
		{
			if (l.entities[i] != null)
			{
				if (Math.sqrt(Math.pow(this.x - l.entities[i].x, 2) + Math.pow(this.y - l.entities[i].y, 2)) < 0.95)
				{
					this.lib.audio.clipList.get(0).stop();
					this.lib.audio.clipList.get(0).setFramePosition(0);
					this.lib.audio.clipList.get(0).start();
					this.dead = true;
					this.killer = l.entities[i];
					this.killer.visible = false;
					this.visible = false;
				}
			}
		}
		for (int i = 0; i < l.ents2.length; i++)
		{
			if (l.ents2[i] != null)
			{
				if (Math.sqrt(Math.pow(this.x - l.ents2[i].x, 2) + Math.pow(this.y - l.ents2[i].y, 2)) < 0.75)
				{
					this.lib.audio.clipList.get(0).stop();
					this.lib.audio.clipList.get(0).setFramePosition(0);
					this.lib.audio.clipList.get(0).start();
					this.dead = true;
					this.killer = l.ents2[i];
					this.killer.visible = false;
					this.visible = false;
				}
			}
		}
		if (this.vX > 0)
		{
			if(l.tiles[roundUp(this.x)][roundUp(this.y)].isSolid && l.tiles[roundUp(this.x)][roundDown(this.y)].isSolid)
			{
				this.lib.audio.clipList.get(1).stop();
				this.lib.audio.clipList.get(1).setFramePosition(0);
				this.lib.audio.clipList.get(1).start();
				this.vX *= -1;
				this.x -= this.x + 1 - roundUp(this.x);
			}
			else if (l.tiles[roundUp(this.x)][roundUp(this.y)].isSolid)
			{
				this.lib.audio.clipList.get(1).stop();
				this.lib.audio.clipList.get(1).setFramePosition(0);
				this.lib.audio.clipList.get(1).start();
				if (roundUp(this.y) - this.y > this.y - roundDown(this.y))
				{
					this.vX = 0;
					this.vY = -this.maxSpeed;
				}
				else
				{
					this.vX *= -1;
				}
			}
			else if (l.tiles[roundUp(this.x)][roundDown(this.y)].isSolid)
			{
				this.lib.audio.clipList.get(1).stop();
				this.lib.audio.clipList.get(1).setFramePosition(0);
				this.lib.audio.clipList.get(1).start();
				if (roundUp(this.y) - this.y < this.y - roundDown(this.y))
				{
					this.vX = 0;
					this.vY = this.maxSpeed;
				}
				else
				{
					this.vX *= -1;
				}
			}
			
		}
		else if (this.vX < 0)
		{
			if(l.tiles[roundDown(this.x)][roundUp(this.y)].isSolid && l.tiles[roundDown(this.x)][roundDown(this.y)].isSolid)
			{
				this.lib.audio.clipList.get(1).stop();
				this.lib.audio.clipList.get(1).setFramePosition(0);
				this.lib.audio.clipList.get(1).start();
				this.vX *= -1;
				this.x += roundDown(this.x) + 1 - x;
			}
			else if (l.tiles[roundDown(this.x)][roundUp(this.y)].isSolid)
			{
				this.lib.audio.clipList.get(1).stop();
				this.lib.audio.clipList.get(1).setFramePosition(0);
				this.lib.audio.clipList.get(1).start();
				if (roundUp(this.y) - this.y > this.y - roundDown(this.y))
				{
					this.vX = 0;
					this.vY = -this.maxSpeed;
				}
				else
				{
					this.vX *= -1;
				}
			}
			else if (l.tiles[roundDown(this.x)][roundDown(this.y)].isSolid)
			{
				this.lib.audio.clipList.get(1).stop();
				this.lib.audio.clipList.get(1).setFramePosition(0);
				this.lib.audio.clipList.get(1).start();
				if (roundUp(this.y) - this.y < this.y - roundDown(this.y))
				{
					this.vX = 0;
					this.vY = this.maxSpeed;
				}
				else
				{
					this.vX *= -1;
				}
			}
		}
		else if (this.vY > 0)
		{
			if(l.tiles[roundUp(this.x)][roundUp(this.y)].isSolid && l.tiles[roundDown(this.x)][roundUp(this.y)].isSolid)
			{
				this.lib.audio.clipList.get(1).stop();
				this.lib.audio.clipList.get(1).setFramePosition(0);
				this.lib.audio.clipList.get(1).start();
				this.vY *= -1;
				this.y -= this.y + 1 - roundUp(this.y);
			}
			else if (l.tiles[roundUp(this.x)][roundUp(this.y)].isSolid)
			{
				this.lib.audio.clipList.get(1).stop();
				this.lib.audio.clipList.get(1).setFramePosition(0);
				this.lib.audio.clipList.get(1).start();
				if (roundUp(this.x) - this.x > this.x - roundDown(this.x))
				{
					this.vX = -this.maxSpeed;
					this.vY = 0;
				}
				else
				{
					this.vY *= -1;
				}
			}
			else if (l.tiles[roundDown(this.x)][roundUp(this.y)].isSolid)
			{
				this.lib.audio.clipList.get(1).stop();
				this.lib.audio.clipList.get(1).setFramePosition(0);
				this.lib.audio.clipList.get(1).start();
				if (roundUp(this.x) - this.x < this.x - roundDown(this.x))
				{
					this.vX = this.maxSpeed;
					this.vY = 0;
				}
				else
				{
					this.vY *= -1;
				}
			}
		}
		else if (this.vY < 0)
		{
			if(l.tiles[roundUp(this.x)][roundDown(this.y)].isSolid && l.tiles[roundDown(this.x)][roundDown(this.y)].isSolid)
			{
				this.lib.audio.clipList.get(1).stop();
				this.lib.audio.clipList.get(1).setFramePosition(0);
				this.lib.audio.clipList.get(1).start();
				this.vY *= -1;
				this.y += roundDown(this.y) + 1 - y;
			}
			else if (l.tiles[roundUp(this.x)][roundDown(this.y)].isSolid)
			{
				this.lib.audio.clipList.get(1).stop();
				this.lib.audio.clipList.get(1).setFramePosition(0);
				this.lib.audio.clipList.get(1).start();
				if (roundUp(this.x) - this.x > this.x - roundDown(this.x))
				{
					this.vX = -this.maxSpeed;
					this.vY = 0;
				}
				else
				{
					this.vY *= -1;
				}
			}
			else if (l.tiles[roundDown(this.x)][roundDown(this.y)].isSolid)
			{
				this.lib.audio.clipList.get(1).stop();
				this.lib.audio.clipList.get(1).setFramePosition(0);
				this.lib.audio.clipList.get(1).start();
				if (roundUp(this.x) - this.x < this.x - roundDown(this.x))
				{
					this.vX = this.maxSpeed;
					this.vY = 0;
				}
				else
				{
					this.vY *= -1;
				}
			}
		}
		if (this.vX > 0)
		{
			if (l.tiles2[roundUp(this.x)][roundUp(this.y)] != null && l.tiles2[roundUp(this.x)][roundDown(this.y)] != null)
			{
				if (l.tiles2[roundUp(this.x)][roundUp(this.y)].isSolid && l.tiles2[roundUp(this.x)][roundDown(this.y)].isSolid)
				{
					this.vX *= -1;
					if (l.tiles2[roundUp(this.x)][roundUp(this.y)].breakable)
					{
						this.lib.audio.clipList.get(1).stop();
						this.lib.audio.clipList.get(1).setFramePosition(0);
						this.lib.audio.clipList.get(1).start();
						this.events.add(new Event("break", roundUp(this.x), roundUp(this.y)));
					}
					else if (l.tiles2[roundUp(this.x)][roundUp(this.y)].id >= 8 && l.tiles2[roundUp(this.x)][roundUp(this.y)].id <= 11 && l.tiles2[roundUp(this.x)][roundUp(this.y)].color() == this.key)
					{
						if (l.tiles2[roundUp(this.x)][roundUp(this.y)].color() == this.key)
						{
							this.lib.audio.clipList.get(3).stop();
							this.lib.audio.clipList.get(3).setFramePosition(0);
							this.lib.audio.clipList.get(3).start();
							this.events.add(new Event("break", roundUp(this.x), roundUp(this.y)));
							this.key = "";
						}
					}
					if (l.tiles2[roundUp(this.x)][roundDown(this.y)].breakable)
					{
						this.lib.audio.clipList.get(1).stop();
						this.lib.audio.clipList.get(1).setFramePosition(0);
						this.lib.audio.clipList.get(1).start();
						this.events.add(new Event("break", roundUp(this.x), roundDown(this.y)));
					}
					else if (l.tiles2[roundUp(this.x)][roundDown(this.y)].id >= 8 && l.tiles2[roundUp(this.x)][roundDown(this.y)].id <= 11 && l.tiles2[roundUp(this.x)][roundDown(this.y)].color() == this.key)
					{
						if (l.tiles2[roundUp(this.x)][roundDown(this.y)].color() == this.key)
						{
							this.lib.audio.clipList.get(3).stop();
							this.lib.audio.clipList.get(3).setFramePosition(0);
							this.lib.audio.clipList.get(3).start();
							this.events.add(new Event("break", roundUp(this.x), roundDown(this.y)));
							this.key = "";
						}
					}
					this.x -= this.x + 1 - roundUp(this.x);
				}
			}
			else if (l.tiles2[roundUp(this.x)][roundUp(this.y)] != null)
			{
				if (l.tiles2[roundUp(this.x)][roundUp(this.y)].isSolid)
				{
					if (roundUp(this.y) - this.y > this.y - roundDown(this.y))
					{
						this.vX = 0;
						this.vY = -this.maxSpeed;
					}
					else
					{
						this.vX *= -1;
					}
					if (l.tiles2[roundUp(this.x)][roundUp(this.y)].breakable)
					{
						this.lib.audio.clipList.get(1).stop();
						this.lib.audio.clipList.get(1).setFramePosition(0);
						this.lib.audio.clipList.get(1).start();
						this.events.add(new Event("break", roundUp(this.x), roundUp(this.y)));
					}
					else if (l.tiles2[roundUp(this.x)][roundUp(this.y)].id >= 8 && l.tiles2[roundUp(this.x)][roundUp(this.y)].id <= 11 && l.tiles2[roundUp(this.x)][roundUp(this.y)].color() == this.key)
					{
						if (l.tiles2[roundUp(this.x)][roundUp(this.y)].color() == this.key)
						{
							this.lib.audio.clipList.get(3).stop();
							this.lib.audio.clipList.get(3).setFramePosition(0);
							this.lib.audio.clipList.get(3).start();
							this.events.add(new Event("break", roundUp(this.x), roundUp(this.y)));
							this.key = "";
						}
					}
					else
					{
						this.lib.audio.clipList.get(1).stop();
						this.lib.audio.clipList.get(1).setFramePosition(0);
						this.lib.audio.clipList.get(1).start();
					}
				}
			}
			else if (l.tiles2[roundUp(this.x)][roundDown(this.y)] != null)
			{
				if (l.tiles2[roundUp(this.x)][roundDown(this.y)].isSolid)
				{
					if (roundUp(this.y) - this.y < this.y - roundDown(this.y))
					{
						this.vX = 0;
						this.vY = this.maxSpeed;
					}
					else
					{
						this.vX *= -1;
					}
					if (l.tiles2[roundUp(this.x)][roundDown(this.y)].breakable)
					{
						this.lib.audio.clipList.get(1).stop();
						this.lib.audio.clipList.get(1).setFramePosition(0);
						this.lib.audio.clipList.get(1).start();
						this.events.add(new Event("break", roundUp(this.x), roundDown(this.y)));
					}
					else if (l.tiles2[roundUp(this.x)][roundDown(this.y)].id >= 8 && l.tiles2[roundUp(this.x)][roundDown(this.y)].id <= 11 && l.tiles2[roundUp(this.x)][roundDown(this.y)].color() == this.key)
					{
						if (l.tiles2[roundUp(this.x)][roundDown(this.y)].color() == this.key)
						{
							this.lib.audio.clipList.get(3).stop();
							this.lib.audio.clipList.get(3).setFramePosition(0);
							this.lib.audio.clipList.get(3).start();
							this.events.add(new Event("break", roundUp(this.x), roundDown(this.y)));
							this.key = "";
						}
					}
					else
					{
						this.lib.audio.clipList.get(1).stop();
						this.lib.audio.clipList.get(1).setFramePosition(0);
						this.lib.audio.clipList.get(1).start();
					}
				}
			}
		}
		else if (this.vX < 0)
		{
			if (l.tiles2[roundDown(this.x)][roundUp(this.y)] != null && l.tiles2[roundDown(this.x)][roundDown(this.y)] != null)
			{
				if (l.tiles2[roundDown(this.x)][roundUp(this.y)].isSolid && l.tiles2[roundDown(this.x)][roundDown(this.y)].isSolid)
				{
					this.vX *= -1;
					if (l.tiles2[roundDown(this.x)][roundUp(this.y)].breakable)
					{
						this.lib.audio.clipList.get(1).stop();
						this.lib.audio.clipList.get(1).setFramePosition(0);
						this.lib.audio.clipList.get(1).start();
						this.events.add(new Event("break", roundDown(this.x), roundUp(this.y)));
					}
					else if (l.tiles2[roundDown(this.x)][roundUp(this.y)].id >= 8 && l.tiles2[roundDown(this.x)][roundUp(this.y)].id <= 11 && l.tiles2[roundDown(this.x)][roundUp(this.y)].color() == this.key)
					{
						if (l.tiles2[roundDown(this.x)][roundUp(this.y)].color() == this.key)
						{
							this.lib.audio.clipList.get(3).stop();
							this.lib.audio.clipList.get(3).setFramePosition(0);
							this.lib.audio.clipList.get(3).start();
							this.events.add(new Event("break", roundDown(this.x), roundUp(this.y)));
							this.key = "";
						}
					}
					if (l.tiles2[roundDown(this.x)][roundDown(this.y)].breakable)
					{
						this.lib.audio.clipList.get(1).stop();
						this.lib.audio.clipList.get(1).setFramePosition(0);
						this.lib.audio.clipList.get(1).start();
						this.events.add(new Event("break", roundDown(this.x), roundDown(this.y)));
					}
					else if (l.tiles2[roundDown(this.x)][roundDown(this.y)].id >= 8 && l.tiles2[roundDown(this.x)][roundDown(this.y)].id <= 11 && l.tiles2[roundDown(this.x)][roundDown(this.y)].color() == this.key)
					{
						if (l.tiles2[roundDown(this.x)][roundDown(this.y)].color() == this.key)
						{
							this.lib.audio.clipList.get(3).stop();
							this.lib.audio.clipList.get(3).setFramePosition(0);
							this.lib.audio.clipList.get(3).start();
							this.events.add(new Event("break", roundDown(this.x), roundDown(this.y)));
							this.key = "";
						}
					}
					this.x += roundDown(this.x) + 1 - x;
				}
			}
			else if (l.tiles2[roundDown(this.x)][roundUp(this.y)] != null)
			{
				if (l.tiles2[roundDown(this.x)][roundUp(this.y)].isSolid)
				{
					if (roundUp(this.y) - this.y > this.y - roundDown(this.y))
					{
						this.vX = 0;
						this.vY = -this.maxSpeed;
					}
					else
					{
						this.vX *= -1;
					}
					if (l.tiles2[roundDown(this.x)][roundUp(this.y)].breakable)
					{
						this.events.add(new Event("break", roundDown(this.x), roundUp(this.y)));
						this.lib.audio.clipList.get(1).stop();
						this.lib.audio.clipList.get(1).setFramePosition(0);
						this.lib.audio.clipList.get(1).start();
					}
					else if (l.tiles2[roundDown(this.x)][roundUp(this.y)].id >= 8 && l.tiles2[roundDown(this.x)][roundUp(this.y)].id <= 11 && l.tiles2[roundDown(this.x)][roundUp(this.y)].color() == this.key)
					{
						if (l.tiles2[roundDown(this.x)][roundUp(this.y)].color() == this.key)
						{

							this.lib.audio.clipList.get(3).stop();
							this.lib.audio.clipList.get(3).setFramePosition(0);
							this.lib.audio.clipList.get(3).start();
							this.events.add(new Event("break", roundDown(this.x), roundUp(this.y)));
							this.key = "";
						}
					}
					else
					{

						this.lib.audio.clipList.get(1).stop();
						this.lib.audio.clipList.get(1).setFramePosition(0);
						this.lib.audio.clipList.get(1).start();
					}
				}
			}
			else if (l.tiles2[roundDown(this.x)][roundDown(this.y)] != null)
			{
				if (l.tiles2[roundDown(this.x)][roundDown(this.y)].isSolid)
				{
					if (roundUp(this.y) - this.y < this.y - roundDown(this.y))
					{
						this.vX = 0;
						this.vY = this.maxSpeed;
					}
					else
					{
						this.vX *= -1;
					}
					if (l.tiles2[roundDown(this.x)][roundDown(this.y)].breakable)
					{
						this.lib.audio.clipList.get(1).stop();
						this.lib.audio.clipList.get(1).setFramePosition(0);
						this.lib.audio.clipList.get(1).start();
						this.events.add(new Event("break", roundDown(this.x), roundDown(this.y)));
					}
					else if (l.tiles2[roundDown(this.x)][roundDown(this.y)].id >= 8 && l.tiles2[roundDown(this.x)][roundDown(this.y)].id <= 11 && l.tiles2[roundDown(this.x)][roundDown(this.y)].color() == this.key)
					{
						if (l.tiles2[roundDown(this.x)][roundDown(this.y)].color() == this.key)
						{
							this.lib.audio.clipList.get(3).stop();
							this.lib.audio.clipList.get(3).setFramePosition(0);
							this.lib.audio.clipList.get(3).start();
							this.events.add(new Event("break", roundDown(this.x), roundDown(this.y)));
							this.key = "";
						}
					}
					else
					{
						this.lib.audio.clipList.get(1).stop();
						this.lib.audio.clipList.get(1).setFramePosition(0);
						this.lib.audio.clipList.get(1).start();
					}
				}
			}
		}
		else if (this.vY > 0)
		{
			if (l.tiles2[roundUp(this.x)][roundUp(this.y)] != null && l.tiles2[roundDown(this.x)][roundUp(this.y)] != null)
			{
				if (l.tiles2[roundUp(this.x)][roundUp(this.y)].isSolid && l.tiles2[roundDown(this.x)][roundUp(this.y)].isSolid)
				{
					this.vY *= -1;
					if (l.tiles2[roundUp(this.x)][roundUp(this.y)].breakable)
					{
						this.lib.audio.clipList.get(1).stop();
						this.lib.audio.clipList.get(1).setFramePosition(0);
						this.lib.audio.clipList.get(1).start();
						this.events.add(new Event("break", roundUp(this.x), roundUp(this.y)));
					}
					else if (l.tiles2[roundUp(this.x)][roundUp(this.y)].id >= 8 && l.tiles2[roundUp(this.x)][roundUp(this.y)].id <= 11 && l.tiles2[roundUp(this.x)][roundUp(this.y)].color() == this.key)
					{
						if (l.tiles2[roundUp(this.x)][roundUp(this.y)].color() == this.key)
						{
							this.lib.audio.clipList.get(3).stop();
							this.lib.audio.clipList.get(3).setFramePosition(0);
							this.lib.audio.clipList.get(3).start();
							this.events.add(new Event("break", roundUp(this.x), roundUp(this.y)));
							this.key = "";
						}
					}
					if (l.tiles2[roundDown(this.x)][roundUp(this.y)].breakable)
					{
						this.lib.audio.clipList.get(1).stop();
						this.lib.audio.clipList.get(1).setFramePosition(0);
						this.lib.audio.clipList.get(1).start();
						this.events.add(new Event("break", roundDown(this.x), roundUp(this.y)));
					}
					else if (l.tiles2[roundDown(this.x)][roundUp(this.y)].id >= 8 && l.tiles2[roundDown(this.x)][roundUp(this.y)].id <= 11 && l.tiles2[roundDown(this.x)][roundUp(this.y)].color() == this.key)
					{
						if (l.tiles2[roundDown(this.x)][roundUp(this.y)].color() == this.key)
						{
							this.lib.audio.clipList.get(3).stop();
							this.lib.audio.clipList.get(3).setFramePosition(0);
							this.lib.audio.clipList.get(3).start();
							this.events.add(new Event("break", roundDown(this.x), roundUp(this.y)));
							this.key = "";
						}
					}
					this.y -= this.y + 1 - roundUp(this.y);
				}
			}
			else if (l.tiles2[roundUp(this.x)][roundUp(this.y)] != null)
			{
				if (l.tiles2[roundUp(this.x)][roundUp(this.y)].isSolid)
				{
					if (roundUp(this.x) - this.x > this.x - roundDown(this.x))
					{
						this.vX = -this.maxSpeed;
						this.vY = 0;
					}
					else
					{
						this.vY *= -1;
					}
					if (l.tiles2[roundUp(this.x)][roundUp(this.y)].breakable)
					{
						this.lib.audio.clipList.get(1).stop();
						this.lib.audio.clipList.get(1).setFramePosition(0);
						this.lib.audio.clipList.get(1).start();
						this.events.add(new Event("break", roundUp(this.x), roundUp(this.y)));
					}
					else if (l.tiles2[roundUp(this.x)][roundUp(this.y)].id >= 8 && l.tiles2[roundUp(this.x)][roundUp(this.y)].id <= 11 && l.tiles2[roundUp(this.x)][roundUp(this.y)].color() == this.key)
					{
						if (l.tiles2[roundUp(this.x)][roundUp(this.y)].color() == this.key)
						{
							this.lib.audio.clipList.get(3).stop();
							this.lib.audio.clipList.get(3).setFramePosition(0);
							this.lib.audio.clipList.get(3).start();
							this.events.add(new Event("break", roundUp(this.x), roundUp(this.y)));
							this.key = "";
						}
					}
					else
					{
						this.lib.audio.clipList.get(1).stop();
						this.lib.audio.clipList.get(1).setFramePosition(0);
						this.lib.audio.clipList.get(1).start();
					}
				}
			}
			else if (l.tiles2[roundDown(this.x)][roundUp(this.y)] != null)
			{
				if (l.tiles2[roundDown(this.x)][roundUp(this.y)].isSolid)
				{
					if (roundUp(this.x) - this.x < this.x - roundDown(this.x))
					{
						this.vX = this.maxSpeed;
						this.vY = 0;
					}
					else
					{
						this.vY *= -1;
					}
					if (l.tiles2[roundDown(this.x)][roundUp(this.y)].breakable)
					{
						this.lib.audio.clipList.get(1).stop();
						this.lib.audio.clipList.get(1).setFramePosition(0);
						this.lib.audio.clipList.get(1).start();
						this.events.add(new Event("break", roundDown(this.x), roundUp(this.y)));
					}
					else if (l.tiles2[roundDown(this.x)][roundUp(this.y)].id >= 8 && l.tiles2[roundDown(this.x)][roundUp(this.y)].id <= 11 && l.tiles2[roundDown(this.x)][roundUp(this.y)].color() == this.key)
					{
						if (l.tiles2[roundDown(this.x)][roundUp(this.y)].color() == this.key)
						{
							this.lib.audio.clipList.get(3).stop();
							this.lib.audio.clipList.get(3).setFramePosition(0);
							this.lib.audio.clipList.get(3).start();
							this.events.add(new Event("break", roundDown(this.x), roundUp(this.y)));
							this.key = "";
						}
					}
					else
					{
						this.lib.audio.clipList.get(1).stop();
						this.lib.audio.clipList.get(1).setFramePosition(0);
						this.lib.audio.clipList.get(1).start();
					}
				}
			}
		}
		else if (this.vY < 0)
		{
			if (l.tiles2[roundUp(this.x)][roundDown(this.y)] != null && l.tiles2[roundDown(this.x)][roundDown(this.y)] != null)
			{
				if (l.tiles2[roundUp(this.x)][roundDown(this.y)].isSolid && l.tiles2[roundDown(this.x)][roundDown(this.y)].isSolid)
				{
					this.vY *= -1;
					if (l.tiles2[roundUp(this.x)][roundDown(this.y)].breakable)
					{
						this.lib.audio.clipList.get(1).stop();
						this.lib.audio.clipList.get(1).setFramePosition(0);
						this.lib.audio.clipList.get(1).start();
						this.events.add(new Event("break", roundUp(this.x), roundDown(this.y)));
					}
					else if (l.tiles2[roundUp(this.x)][roundDown(this.y)].id >= 8 && l.tiles2[roundUp(this.x)][roundDown(this.y)].id <= 11)
					{
						if (l.tiles2[roundUp(this.x)][roundDown(this.y)].color() == this.key)
						{
							this.lib.audio.clipList.get(3).stop();
							this.lib.audio.clipList.get(3).setFramePosition(0);
							this.lib.audio.clipList.get(3).start();
							this.events.add(new Event("break", roundUp(this.x), roundDown(this.y)));
							this.key = "";
						}
					}
					if (l.tiles2[roundDown(this.x)][roundDown(this.y)].breakable)
					{
						this.lib.audio.clipList.get(1).stop();
						this.lib.audio.clipList.get(1).setFramePosition(0);
						this.lib.audio.clipList.get(1).start();
						this.events.add(new Event("break", roundDown(this.x), roundDown(this.y)));
					}
					else if (l.tiles2[roundDown(this.x)][roundDown(this.y)].id >= 8 && l.tiles2[roundDown(this.x)][roundDown(this.y)].id <= 11)
					{
						if (l.tiles2[roundDown(this.x)][roundDown(this.y)].color() == this.key)
						{
							this.lib.audio.clipList.get(3).stop();
							this.lib.audio.clipList.get(3).setFramePosition(0);
							this.lib.audio.clipList.get(3).start();
							this.events.add(new Event("break", roundDown(this.x), roundDown(this.y)));
							this.key = "";
						}
					}
					this.y += roundDown(this.y) + 1 - y;
				}
			}
			else if (l.tiles2[roundUp(this.x)][roundDown(this.y)] != null)
			{
				if (l.tiles2[roundUp(this.x)][roundDown(this.y)].isSolid)
				{
					if (roundUp(this.x) - this.x > this.x - roundDown(this.x))
					{
						this.vX = -this.maxSpeed;
						this.vY = 0;
					}
					else
					{
						this.vY *= -1;
					}
					if (l.tiles2[roundUp(this.x)][roundDown(this.y)].breakable)
					{
						this.lib.audio.clipList.get(1).stop();
						this.lib.audio.clipList.get(1).setFramePosition(0);
						this.lib.audio.clipList.get(1).start();
						this.events.add(new Event("break", roundUp(this.x), roundDown(this.y)));
					}
					else if (l.tiles2[roundUp(this.x)][roundDown(this.y)].id >= 8 && l.tiles2[roundUp(this.x)][roundDown(this.y)].id <= 11)
					{
						if (l.tiles2[roundUp(this.x)][roundDown(this.y)].color() == this.key)
						{
							this.lib.audio.clipList.get(3).stop();
							this.lib.audio.clipList.get(3).setFramePosition(0);
							this.lib.audio.clipList.get(3).start();
							this.events.add(new Event("break", roundUp(this.x), roundDown(this.y)));
							this.key = "";
						}
					}
					else
					{
						this.lib.audio.clipList.get(1).stop();
						this.lib.audio.clipList.get(1).setFramePosition(0);
						this.lib.audio.clipList.get(1).start();
					}
				}
			}
			else if (l.tiles2[roundDown(this.x)][roundDown(this.y)] != null)
			{
				if (l.tiles2[roundDown(this.x)][roundDown(this.y)].isSolid)
				{
					if (roundUp(this.x) - this.x < this.x - roundDown(this.x))
					{
						this.vX = this.maxSpeed;
						this.vY = 0;
					}
					else
					{
						this.vY *= -1;
					}
					if (l.tiles2[roundDown(this.x)][roundDown(this.y)].breakable)
					{
						this.lib.audio.clipList.get(1).stop();
						this.lib.audio.clipList.get(1).setFramePosition(0);
						this.lib.audio.clipList.get(1).start();
						this.events.add(new Event("break", roundDown(this.x), roundDown(this.y)));
					}
					else if (l.tiles2[roundDown(this.x)][roundDown(this.y)].id >= 8 && l.tiles2[roundDown(this.x)][roundDown(this.y)].id <= 11)
					{
						if (l.tiles2[roundDown(this.x)][roundDown(this.y)].color() == this.key)
						{
							this.lib.audio.clipList.get(3).stop();
							this.lib.audio.clipList.get(3).setFramePosition(0);
							this.lib.audio.clipList.get(3).start();
							this.events.add(new Event("break", roundDown(this.x), roundDown(this.y)));
							this.key = "";
						}
					}
					else
					{
						this.lib.audio.clipList.get(1).stop();
						this.lib.audio.clipList.get(1).setFramePosition(0);
						this.lib.audio.clipList.get(1).start();
					}
				}
			}
		}
		}
		return this;
	}
	protected static int roundUp(double d)
	{
		int a = (int) Math.round(d);
		if (a < d)
			a++;
		return a;
	}
	protected static int roundDown(double d)
	{
		int a = (int) Math.round(d);
		if (a > d)
			a--;
		return a;
	}
}