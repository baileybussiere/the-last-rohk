package entities;

import java.awt.Image;
import java.util.ArrayList;

import levels.Level;
import data.Event;
import data.Tile;
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
		int xu = roundUp(this.x);
		int xd = roundDown(this.x);
		int yu = roundUp(this.y);
		int yd = roundDown(this.y);
		Tile tuu = l.tiles2[xu][yu];
		Tile tud = l.tiles2[xu][yd];
		Tile tdu = l.tiles2[xd][yu];
		Tile tdd = l.tiles2[xd][yd];
		if (tuu != null)
		{
			if (tuu.id == 2)
			{
				this.lib.audio.clipList.get(4).stop();
				this.lib.audio.clipList.get(4).setFramePosition(0);
				this.lib.audio.clipList.get(4).start();
				this.events.add(new Event("nextLvl", xu, yu));
			}
			else if (tuu.id == -1)
			{
				this.lib.audio.clipList.get(5).stop();
				this.lib.audio.clipList.get(5).setFramePosition(0);
				this.lib.audio.clipList.get(5).start();
				this.events.add(new Event("displTxt", xu, yu));
			}
			else if (tuu.id == 12)
			{
				this.lib.audio.clipList.get(0).stop();
				this.lib.audio.clipList.get(0).setFramePosition(0);
				this.lib.audio.clipList.get(0).start();
				this.dead = true;
			}
			else if (tuu.isKey && this.ticksTillKey <= 0)
			{
				this.lib.audio.clipList.get(2).stop();
				this.lib.audio.clipList.get(2).setFramePosition(0);
				this.lib.audio.clipList.get(2).start();
				String k = tuu.color();
				if (this.key.equals(""))
					l.tiles2[xu][yu] = null;
				else if (this.key.equals("copper"))
					l.tiles2[xu][yu] = lib.tile.tileList.get(4);
				else if (this.key.equals("silver"))
					l.tiles2[xu][yu] = lib.tile.tileList.get(5);
				else if (this.key.equals("gold"))
					l.tiles2[xu][yu] = lib.tile.tileList.get(6);
				else if (this.key.equals("rusted"))
					l.tiles2[xu][yu] = lib.tile.tileList.get(7);
				this.key = k;
				this.ticksTillKey = 40;
			}
			else if (tuu.id == 17 && tuu.tick > 240)
			{
				this.lib.audio.clipList.get(0).stop();
				this.lib.audio.clipList.get(0).setFramePosition(0);
				this.lib.audio.clipList.get(0).start();
				this.dead = true;
			}
		}
		if (tud != null)
		{
			if (tud.id == 2)
			{
				this.lib.audio.clipList.get(4).stop();
				this.lib.audio.clipList.get(4).setFramePosition(0);
				this.lib.audio.clipList.get(4).start();
				this.events.add(new Event("nextLvl", xu, yd));
			}
			else if (tud.id == -1)
			{
				this.lib.audio.clipList.get(5).stop();
				this.lib.audio.clipList.get(5).setFramePosition(0);
				this.lib.audio.clipList.get(5).start();
				this.events.add(new Event("displTxt", xu, yd));
			}
			else if (tud.id == 12)
			{
				this.lib.audio.clipList.get(0).stop();
				this.lib.audio.clipList.get(0).setFramePosition(0);
				this.lib.audio.clipList.get(0).start();
				this.dead = true;
			}
			else if (tud.isKey && this.ticksTillKey <= 0)
			{
				this.lib.audio.clipList.get(2).stop();
				this.lib.audio.clipList.get(2).setFramePosition(0);
				this.lib.audio.clipList.get(2).start();
				String k = tud.color();
				if (this.key.equals(""))
					l.tiles2[xu][yd] = null;
				else if (this.key.equals("copper"))
					l.tiles2[xu][yd] = lib.tile.tileList.get(4);
				else if (this.key.equals("silver"))
					l.tiles2[xu][yd] = lib.tile.tileList.get(5);
				else if (this.key.equals("gold"))
					l.tiles2[xu][yd] = lib.tile.tileList.get(6);
				else if (this.key.equals("rusted"))
					l.tiles2[xu][yd] = lib.tile.tileList.get(7);
				this.key = k;
				this.ticksTillKey = 40;
			}
			else if (tud.id == 17 && tud.tick > 240)
			{
				this.lib.audio.clipList.get(0).stop();
				this.lib.audio.clipList.get(0).setFramePosition(0);
				this.lib.audio.clipList.get(0).start();
				this.dead = true;
			}
		}
		if (tdu != null)
		{
			if (tdu.id == 2)
			{
				this.lib.audio.clipList.get(4).stop();
				this.lib.audio.clipList.get(4).setFramePosition(0);
				this.lib.audio.clipList.get(4).start();
				this.events.add(new Event("nextLvl", xd, yu));
			}
			else if (tdu.id == -1)
			{
				this.lib.audio.clipList.get(5).stop();
				this.lib.audio.clipList.get(5).setFramePosition(0);
				this.lib.audio.clipList.get(5).start();
				this.events.add(new Event("displTxt", xd, yu));
			}
			else if (tdu.id == 12)
			{
				this.lib.audio.clipList.get(0).stop();
				this.lib.audio.clipList.get(0).setFramePosition(0);
				this.lib.audio.clipList.get(0).start();
				this.dead = true;
			}
			else if (tdu.isKey && this.ticksTillKey <= 0)
			{
				this.lib.audio.clipList.get(2).stop();
				this.lib.audio.clipList.get(2).setFramePosition(0);
				this.lib.audio.clipList.get(2).start();
				String k = tdu.color();
				if (this.key.equals(""))
					l.tiles2[xd][yu] = null;
				else if (this.key.equals("copper"))
					l.tiles2[xd][yu] = lib.tile.tileList.get(4);
				else if (this.key.equals("silver"))
					l.tiles2[xd][yu] = lib.tile.tileList.get(5);
				else if (this.key.equals("gold"))
					l.tiles2[xd][yu] = lib.tile.tileList.get(6);
				else if (this.key.equals("rusted"))
					l.tiles2[xd][yu] = lib.tile.tileList.get(7);
				this.key = k;
				this.ticksTillKey = 40;
			}
			else if (tdu.id == 17 && tdu.tick > 240)
			{
				this.lib.audio.clipList.get(0).stop();
				this.lib.audio.clipList.get(0).setFramePosition(0);
				this.lib.audio.clipList.get(0).start();
				this.dead = true;
			}
		}
		if (tdd != null)
		{
			if (tdd.id == 2)
			{
				this.lib.audio.clipList.get(4).stop();
				this.lib.audio.clipList.get(4).setFramePosition(0);
				this.lib.audio.clipList.get(4).start();
				this.events.add(new Event("nextLvl", xd, yd));
			}
			else if (tdd.id == -1)
			{
				this.lib.audio.clipList.get(5).stop();
				this.lib.audio.clipList.get(5).setFramePosition(0);
				this.lib.audio.clipList.get(5).start();
				this.events.add(new Event("displTxt", xd, yd));
			}
			else if (tdd.id == 12)
			{
				this.lib.audio.clipList.get(0).stop();
				this.lib.audio.clipList.get(0).setFramePosition(0);
				this.lib.audio.clipList.get(0).start();
				this.dead = true;
			}
			else if (tdd.isKey && this.ticksTillKey <= 0)
			{
				this.lib.audio.clipList.get(2).stop();
				this.lib.audio.clipList.get(2).setFramePosition(0);
				this.lib.audio.clipList.get(2).start();
				String k = tdd.color();
				if (this.key.equals(""))
					l.tiles2[xd][yd] = null;
				else if (this.key.equals("copper"))
					l.tiles2[xd][yd] = lib.tile.tileList.get(4);
				else if (this.key.equals("silver"))
					l.tiles2[xd][yd] = lib.tile.tileList.get(5);
				else if (this.key.equals("gold"))
					l.tiles2[xd][yd] = lib.tile.tileList.get(6);
				else if (this.key.equals("rusted"))
					l.tiles2[xd][yd] = lib.tile.tileList.get(7);
				this.key = k;
				this.ticksTillKey = 40;
			}
			else if (tdd.id == 17 && tdd.tick > 240)
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
			if(l.tiles[xu][yu].isSolid && l.tiles[xu][yd].isSolid)
			{
				this.lib.audio.clipList.get(1).stop();
				this.lib.audio.clipList.get(1).setFramePosition(0);
				this.lib.audio.clipList.get(1).start();
				this.vX *= -1;
				this.x -= this.x + 1 - xu;
			}
			else if (l.tiles[xu][yu].isSolid)
			{
				this.lib.audio.clipList.get(1).stop();
				this.lib.audio.clipList.get(1).setFramePosition(0);
				this.lib.audio.clipList.get(1).start();
				if (yu - this.y > this.y - yd)
				{
					this.vX = 0;
					this.vY = -this.maxSpeed;
				}
				else
				{
					this.vX *= -1;
				}
			}
			else if (l.tiles[xu][yd].isSolid)
			{
				this.lib.audio.clipList.get(1).stop();
				this.lib.audio.clipList.get(1).setFramePosition(0);
				this.lib.audio.clipList.get(1).start();
				if (yu - this.y < this.y - yd)
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
			if(l.tiles[xd][yu].isSolid && l.tiles[xd][yd].isSolid)
			{
				this.lib.audio.clipList.get(1).stop();
				this.lib.audio.clipList.get(1).setFramePosition(0);
				this.lib.audio.clipList.get(1).start();
				this.vX *= -1;
				this.x += xd + 1 - x;
			}
			else if (l.tiles[xd][yu].isSolid)
			{
				this.lib.audio.clipList.get(1).stop();
				this.lib.audio.clipList.get(1).setFramePosition(0);
				this.lib.audio.clipList.get(1).start();
				if (yu - this.y > this.y - yd)
				{
					this.vX = 0;
					this.vY = -this.maxSpeed;
				}
				else
				{
					this.vX *= -1;
				}
			}
			else if (l.tiles[xd][yd].isSolid)
			{
				this.lib.audio.clipList.get(1).stop();
				this.lib.audio.clipList.get(1).setFramePosition(0);
				this.lib.audio.clipList.get(1).start();
				if (yu - this.y < this.y - yd)
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
			if(l.tiles[xu][yu].isSolid && l.tiles[xd][yu].isSolid)
			{
				this.lib.audio.clipList.get(1).stop();
				this.lib.audio.clipList.get(1).setFramePosition(0);
				this.lib.audio.clipList.get(1).start();
				this.vY *= -1;
				this.y -= this.y + 1 - yu;
			}
			else if (l.tiles[xu][yu].isSolid)
			{
				this.lib.audio.clipList.get(1).stop();
				this.lib.audio.clipList.get(1).setFramePosition(0);
				this.lib.audio.clipList.get(1).start();
				if (xu - this.x > this.x - xd)
				{
					this.vX = -this.maxSpeed;
					this.vY = 0;
				}
				else
				{
					this.vY *= -1;
				}
			}
			else if (l.tiles[xd][yu].isSolid)
			{
				this.lib.audio.clipList.get(1).stop();
				this.lib.audio.clipList.get(1).setFramePosition(0);
				this.lib.audio.clipList.get(1).start();
				if (xu - this.x < this.x - xd)
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
			if(l.tiles[xu][yd].isSolid && l.tiles[xd][yd].isSolid)
			{
				this.lib.audio.clipList.get(1).stop();
				this.lib.audio.clipList.get(1).setFramePosition(0);
				this.lib.audio.clipList.get(1).start();
				this.vY *= -1;
				this.y += yd + 1 - y;
			}
			else if (l.tiles[xu][yd].isSolid)
			{
				this.lib.audio.clipList.get(1).stop();
				this.lib.audio.clipList.get(1).setFramePosition(0);
				this.lib.audio.clipList.get(1).start();
				if (xu - this.x > this.x - xd)
				{
					this.vX = -this.maxSpeed;
					this.vY = 0;
				}
				else
				{
					this.vY *= -1;
				}
			}
			else if (l.tiles[xd][yd].isSolid)
			{
				this.lib.audio.clipList.get(1).stop();
				this.lib.audio.clipList.get(1).setFramePosition(0);
				this.lib.audio.clipList.get(1).start();
				if (xu - this.x < this.x - xd)
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
			if (tuu != null && tud != null)
			{
				if (tuu.isSolid && tud.isSolid)
				{
					this.vX *= -1;
					if (tuu.breakable)
					{
						this.lib.audio.clipList.get(1).stop();
						this.lib.audio.clipList.get(1).setFramePosition(0);
						this.lib.audio.clipList.get(1).start();
						this.events.add(new Event("break", xu, yu));
					}
					else if (tuu.id >= 8 && tuu.id <= 11 && tuu.color() == this.key)
					{
						if (tuu.color() == this.key)
						{
							this.lib.audio.clipList.get(3).stop();
							this.lib.audio.clipList.get(3).setFramePosition(0);
							this.lib.audio.clipList.get(3).start();
							this.events.add(new Event("break", xu, yu));
							this.key = "";
						}
					}
					if (tud.breakable)
					{
						this.lib.audio.clipList.get(1).stop();
						this.lib.audio.clipList.get(1).setFramePosition(0);
						this.lib.audio.clipList.get(1).start();
						this.events.add(new Event("break", xu, yd));
					}
					else if (tud.id >= 8 && tud.id <= 11 && tud.color() == this.key)
					{
						if (tud.color() == this.key)
						{
							this.lib.audio.clipList.get(3).stop();
							this.lib.audio.clipList.get(3).setFramePosition(0);
							this.lib.audio.clipList.get(3).start();
							this.events.add(new Event("break", xu, yd));
							this.key = "";
						}
					}
					this.x -= this.x + 1 - xu;
				}
			}
			else if (tuu != null)
			{
				if (tuu.isSolid)
				{
					if (yu - this.y > this.y - yd)
					{
						this.vX = 0;
						this.vY = -this.maxSpeed;
					}
					else
					{
						this.vX *= -1;
					}
					if (tuu.breakable)
					{
						this.lib.audio.clipList.get(1).stop();
						this.lib.audio.clipList.get(1).setFramePosition(0);
						this.lib.audio.clipList.get(1).start();
						this.events.add(new Event("break", xu, yu));
					}
					else if (tuu.id >= 8 && tuu.id <= 11 && tuu.color() == this.key)
					{
						if (tuu.color() == this.key)
						{
							this.lib.audio.clipList.get(3).stop();
							this.lib.audio.clipList.get(3).setFramePosition(0);
							this.lib.audio.clipList.get(3).start();
							this.events.add(new Event("break", xu, yu));
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
			else if (tud != null)
			{
				if (tud.isSolid)
				{
					if (yu - this.y < this.y - yd)
					{
						this.vX = 0;
						this.vY = this.maxSpeed;
					}
					else
					{
						this.vX *= -1;
					}
					if (tud.breakable)
					{
						this.lib.audio.clipList.get(1).stop();
						this.lib.audio.clipList.get(1).setFramePosition(0);
						this.lib.audio.clipList.get(1).start();
						this.events.add(new Event("break", xu, yd));
					}
					else if (tud.id >= 8 && tud.id <= 11 && tud.color() == this.key)
					{
						if (tud.color() == this.key)
						{
							this.lib.audio.clipList.get(3).stop();
							this.lib.audio.clipList.get(3).setFramePosition(0);
							this.lib.audio.clipList.get(3).start();
							this.events.add(new Event("break", xu, yd));
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
			if (tdu != null && tdd != null)
			{
				if (tdu.isSolid && tdd.isSolid)
				{
					this.vX *= -1;
					if (tdu.breakable)
					{
						this.lib.audio.clipList.get(1).stop();
						this.lib.audio.clipList.get(1).setFramePosition(0);
						this.lib.audio.clipList.get(1).start();
						this.events.add(new Event("break", xd, yu));
					}
					else if (tdu.id >= 8 && tdu.id <= 11 && tdu.color() == this.key)
					{
						if (tdu.color() == this.key)
						{
							this.lib.audio.clipList.get(3).stop();
							this.lib.audio.clipList.get(3).setFramePosition(0);
							this.lib.audio.clipList.get(3).start();
							this.events.add(new Event("break", xd, yu));
							this.key = "";
						}
					}
					if (tdd.breakable)
					{
						this.lib.audio.clipList.get(1).stop();
						this.lib.audio.clipList.get(1).setFramePosition(0);
						this.lib.audio.clipList.get(1).start();
						this.events.add(new Event("break", xd, yd));
					}
					else if (tdd.id >= 8 && tdd.id <= 11 && tdd.color() == this.key)
					{
						if (tdd.color() == this.key)
						{
							this.lib.audio.clipList.get(3).stop();
							this.lib.audio.clipList.get(3).setFramePosition(0);
							this.lib.audio.clipList.get(3).start();
							this.events.add(new Event("break", xd, yd));
							this.key = "";
						}
					}
					this.x += xd + 1 - x;
				}
			}
			else if (tdu != null)
			{
				if (tdu.isSolid)
				{
					if (yu - this.y > this.y - yd)
					{
						this.vX = 0;
						this.vY = -this.maxSpeed;
					}
					else
					{
						this.vX *= -1;
					}
					if (tdu.breakable)
					{
						this.events.add(new Event("break", xd, yu));
						this.lib.audio.clipList.get(1).stop();
						this.lib.audio.clipList.get(1).setFramePosition(0);
						this.lib.audio.clipList.get(1).start();
					}
					else if (tdu.id >= 8 && tdu.id <= 11 && tdu.color() == this.key)
					{
						if (tdu.color() == this.key)
						{

							this.lib.audio.clipList.get(3).stop();
							this.lib.audio.clipList.get(3).setFramePosition(0);
							this.lib.audio.clipList.get(3).start();
							this.events.add(new Event("break", xd, yu));
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
			else if (tdd != null)
			{
				if (tdd.isSolid)
				{
					if (yu - this.y < this.y - yd)
					{
						this.vX = 0;
						this.vY = this.maxSpeed;
					}
					else
					{
						this.vX *= -1;
					}
					if (tdd.breakable)
					{
						this.lib.audio.clipList.get(1).stop();
						this.lib.audio.clipList.get(1).setFramePosition(0);
						this.lib.audio.clipList.get(1).start();
						this.events.add(new Event("break", xd, yd));
					}
					else if (tdd.id >= 8 && tdd.id <= 11 && tdd.color() == this.key)
					{
						if (tdd.color() == this.key)
						{
							this.lib.audio.clipList.get(3).stop();
							this.lib.audio.clipList.get(3).setFramePosition(0);
							this.lib.audio.clipList.get(3).start();
							this.events.add(new Event("break", xd, yd));
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
			if (tuu != null && tdu != null)
			{
				if (tuu.isSolid && tdu.isSolid)
				{
					this.vY *= -1;
					if (tuu.breakable)
					{
						this.lib.audio.clipList.get(1).stop();
						this.lib.audio.clipList.get(1).setFramePosition(0);
						this.lib.audio.clipList.get(1).start();
						this.events.add(new Event("break", xu, yu));
					}
					else if (tuu.id >= 8 && tuu.id <= 11 && tuu.color() == this.key)
					{
						if (tuu.color() == this.key)
						{
							this.lib.audio.clipList.get(3).stop();
							this.lib.audio.clipList.get(3).setFramePosition(0);
							this.lib.audio.clipList.get(3).start();
							this.events.add(new Event("break", xu, yu));
							this.key = "";
						}
					}
					if (tdu.breakable)
					{
						this.lib.audio.clipList.get(1).stop();
						this.lib.audio.clipList.get(1).setFramePosition(0);
						this.lib.audio.clipList.get(1).start();
						this.events.add(new Event("break", xd, yu));
					}
					else if (tdu.id >= 8 && tdu.id <= 11 && tdu.color() == this.key)
					{
						if (tdu.color() == this.key)
						{
							this.lib.audio.clipList.get(3).stop();
							this.lib.audio.clipList.get(3).setFramePosition(0);
							this.lib.audio.clipList.get(3).start();
							this.events.add(new Event("break", xd, yu));
							this.key = "";
						}
					}
					this.y -= this.y + 1 - yu;
				}
			}
			else if (tuu != null)
			{
				if (tuu.isSolid)
				{
					if (xu - this.x > this.x - xd)
					{
						this.vX = -this.maxSpeed;
						this.vY = 0;
					}
					else
					{
						this.vY *= -1;
					}
					if (tuu.breakable)
					{
						this.lib.audio.clipList.get(1).stop();
						this.lib.audio.clipList.get(1).setFramePosition(0);
						this.lib.audio.clipList.get(1).start();
						this.events.add(new Event("break", xu, yu));
					}
					else if (tuu.id >= 8 && tuu.id <= 11 && tuu.color() == this.key)
					{
						if (tuu.color() == this.key)
						{
							this.lib.audio.clipList.get(3).stop();
							this.lib.audio.clipList.get(3).setFramePosition(0);
							this.lib.audio.clipList.get(3).start();
							this.events.add(new Event("break", xu, yu));
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
			else if (tdu != null)
			{
				if (tdu.isSolid)
				{
					if (xu - this.x < this.x - xd)
					{
						this.vX = this.maxSpeed;
						this.vY = 0;
					}
					else
					{
						this.vY *= -1;
					}
					if (tdu.breakable)
					{
						this.lib.audio.clipList.get(1).stop();
						this.lib.audio.clipList.get(1).setFramePosition(0);
						this.lib.audio.clipList.get(1).start();
						this.events.add(new Event("break", xd, yu));
					}
					else if (tdu.id >= 8 && tdu.id <= 11 && tdu.color() == this.key)
					{
						if (tdu.color() == this.key)
						{
							this.lib.audio.clipList.get(3).stop();
							this.lib.audio.clipList.get(3).setFramePosition(0);
							this.lib.audio.clipList.get(3).start();
							this.events.add(new Event("break", xd, yu));
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
			if (tud != null && tdd != null)
			{
				if (tud.isSolid && tdd.isSolid)
				{
					this.vY *= -1;
					if (tud.breakable)
					{
						this.lib.audio.clipList.get(1).stop();
						this.lib.audio.clipList.get(1).setFramePosition(0);
						this.lib.audio.clipList.get(1).start();
						this.events.add(new Event("break", xu, yd));
					}
					else if (tud.id >= 8 && tud.id <= 11)
					{
						if (tud.color() == this.key)
						{
							this.lib.audio.clipList.get(3).stop();
							this.lib.audio.clipList.get(3).setFramePosition(0);
							this.lib.audio.clipList.get(3).start();
							this.events.add(new Event("break", xu, yd));
							this.key = "";
						}
					}
					if (tdd.breakable)
					{
						this.lib.audio.clipList.get(1).stop();
						this.lib.audio.clipList.get(1).setFramePosition(0);
						this.lib.audio.clipList.get(1).start();
						this.events.add(new Event("break", xd, yd));
					}
					else if (tdd.id >= 8 && tdd.id <= 11)
					{
						if (tdd.color() == this.key)
						{
							this.lib.audio.clipList.get(3).stop();
							this.lib.audio.clipList.get(3).setFramePosition(0);
							this.lib.audio.clipList.get(3).start();
							this.events.add(new Event("break", xd, yd));
							this.key = "";
						}
					}
					this.y += yd + 1 - y;
				}
			}
			else if (tud != null)
			{
				if (tud.isSolid)
				{
					if (xu - this.x > this.x - xd)
					{
						this.vX = -this.maxSpeed;
						this.vY = 0;
					}
					else
					{
						this.vY *= -1;
					}
					if (tud.breakable)
					{
						this.lib.audio.clipList.get(1).stop();
						this.lib.audio.clipList.get(1).setFramePosition(0);
						this.lib.audio.clipList.get(1).start();
						this.events.add(new Event("break", xu, yd));
					}
					else if (tud.id >= 8 && tud.id <= 11)
					{
						if (tud.color() == this.key)
						{
							this.lib.audio.clipList.get(3).stop();
							this.lib.audio.clipList.get(3).setFramePosition(0);
							this.lib.audio.clipList.get(3).start();
							this.events.add(new Event("break", xu, yd));
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
			else if (tdd != null)
			{
				if (tdd.isSolid)
				{
					if (xu - this.x < this.x - xd)
					{
						this.vX = this.maxSpeed;
						this.vY = 0;
					}
					else
					{
						this.vY *= -1;
					}
					if (tdd.breakable)
					{
						this.lib.audio.clipList.get(1).stop();
						this.lib.audio.clipList.get(1).setFramePosition(0);
						this.lib.audio.clipList.get(1).start();
						this.events.add(new Event("break", xd, yd));
					}
					else if (tdd.id >= 8 && tdd.id <= 11)
					{
						if (tdd.color() == this.key)
						{
							this.lib.audio.clipList.get(3).stop();
							this.lib.audio.clipList.get(3).setFramePosition(0);
							this.lib.audio.clipList.get(3).start();
							this.events.add(new Event("break", xd, yd));
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
