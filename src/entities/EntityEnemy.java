package entities;

import levels.Level;
import data.LibLibrary;

public class EntityEnemy extends Entity
{
	public EntityEnemy(double x, double y, int vX, int vY, int i, LibLibrary lib)
	{
		super(x, y, i, lib);
		this.maxSpeed = 2;
		this.vX = vX*this.maxSpeed;
		this.vY = vY*this.maxSpeed;
	}
	
	public EntityEnemy dupl()
	{
		return new EntityEnemy(this.x, this.y, this.vX, this.vY, this.texInd, this.lib);
	}
	
	public EntityEnemy update(double t, Level l)
	{
		this.x += this.vX*t;
		this.y += this.vY*t;
		if (this.vX > 0 && this.vY == 0)
		{
			if(l.tiles[roundUp(this.x)][(int) Math.round(this.y)].isSolid)
				this.vX *= -1;
			if(l.tiles2[roundUp(this.x)][(int) Math.round(this.y)] != null)
				if(l.tiles2[roundUp(this.x)][(int) Math.round(this.y)].isSolid)
					this.vX *= -1;
		}
		else if (this.vX < 0 && this.vY == 0)
		{
			if(l.tiles[roundDown(this.x)][(int) Math.round(this.y)].isSolid)
				this.vX *= -1;
			if(l.tiles2[roundDown(this.x)][(int) Math.round(this.y)] != null)
				if(l.tiles2[roundDown(this.x)][(int) Math.round(this.y)].isSolid)
					this.vX *= -1;
		}
		else if (this.vY > 0 && this.vX == 0)
		{
			if(l.tiles[(int) Math.round(this.x)][roundUp(this.y)].isSolid)
				this.vY *= -1;
			if(l.tiles2[(int) Math.round(this.x)][roundUp(this.y)] != null)
				if(l.tiles2[(int) Math.round(this.x)][roundUp(this.y)].isSolid)
					this.vY *= -1;
		}
		else if (this.vY < 0 && this.vX == 0)
		{
			if(l.tiles[(int) Math.round(this.x)][roundDown(this.y)].isSolid)
				this.vY *= -1;
			if(l.tiles2[(int) Math.round(this.x)][roundDown(this.y)] != null)
				if(l.tiles2[(int) Math.round(this.x)][roundDown(this.y)].isSolid)
					this.vY *= -1;
		}
		else if (this.vY < 0 && this.vX < 0)
		{
			if(l.tiles[roundDown(this.x)][(int) Math.round(this.y)].isSolid)
				this.vX *= -1;
			else if(l.tiles[(int) Math.round(this.x)][roundDown(this.y)].isSolid)
				this.vY *= -1;
			if (l.tiles2[roundDown(this.x)][(int) Math.round(this.y)] != null)
			{
				if(l.tiles2[roundDown(this.x)][(int) Math.round(this.y)].isSolid)
					this.vX *= -1;
			}
			else if (l.tiles2[(int) Math.round(this.x)][roundDown(this.y)] != null)
			{
				if(l.tiles2[(int) Math.round(this.x)][roundDown(this.y)].isSolid)
					this.vY *= -1;
			}
		}
		else if (this.vY < 0 && this.vX > 0)
		{
			if(l.tiles[roundUp(this.x)][(int) Math.round(this.y)].isSolid)
				this.vX *= -1;
			else if(l.tiles[(int) Math.round(this.x)][roundDown(this.y)].isSolid)
				this.vY *= -1;
			if (l.tiles2[roundUp(this.x)][(int) Math.round(this.y)] != null)
			{
				if(l.tiles2[roundUp(this.x)][(int) Math.round(this.y)].isSolid)
					this.vX *= -1;
			}
			else if (l.tiles2[(int) Math.round(this.x)][roundDown(this.y)] != null)
			{
				if(l.tiles2[(int) Math.round(this.x)][roundDown(this.y)].isSolid)
					this.vY *= -1;
			}
		}
		else if (this.vY > 0 && this.vX < 0)
		{
			if(l.tiles[roundDown(this.x)][(int) Math.round(this.y)].isSolid)
				this.vX *= -1;
			else if(l.tiles[(int) Math.round(this.x)][roundUp(this.y)].isSolid)
				this.vY *= -1;
			if (l.tiles2[roundDown(this.x)][(int) Math.round(this.y)] != null)
			{
				if(l.tiles2[roundDown(this.x)][(int) Math.round(this.y)].isSolid)
					this.vX *= -1;
			}
			else if (l.tiles2[(int) Math.round(this.x)][roundUp(this.y)] != null)
			{
				if(l.tiles2[(int) Math.round(this.x)][roundUp(this.y)].isSolid)
					this.vY *= -1;
			}
		}
		else if (this.vY > 0 && this.vX > 0)
		{
			if(l.tiles[roundUp(this.x)][(int) Math.round(this.y)].isSolid)
				this.vX *= -1;
			else if(l.tiles[(int) Math.round(this.x)][roundUp(this.y)].isSolid)
				this.vY *= -1;
			if (l.tiles2[roundUp(this.x)][(int) Math.round(this.y)] != null)
			{
				if(l.tiles2[roundUp(this.x)][(int) Math.round(this.y)].isSolid)
					this.vX *= -1;
			}
			else if (l.tiles2[(int) Math.round(this.x)][roundUp(this.y)] != null)
			{
				if(l.tiles2[(int) Math.round(this.x)][roundUp(this.y)].isSolid)
					this.vY *= -1;
			}
		}
		return this;
	}
}