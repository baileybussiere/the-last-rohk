package entities;

import levels.Level;
import data.LibLibrary;

public class EntityBolt extends EntityEnemy
{
	public boolean homing = false;
	public boolean stuck = true;
	
	public EntityBolt(double x, double y, int vX, int vY, int i, LibLibrary lib)
	{
		super(x, y, vX, vY, i, lib);
	}
	
	public EntityEnemy homing(boolean i)
	{
		this.homing = i;
		return this;
	}
	
	public EntityEnemy dupl()
	{
		return new EntityBolt(this.x, this.y, this.vX, this.vY, this.texInd, this.lib).homing(this.homing);
	}
	
	public EntityEnemy update(double t, Level l)
	{
		if (!this.stuck)
		{
			this.x += this.vX*t;
			this.y += this.vY*t;
			//if (!this.homing)
			//{
				if (this.vX == 0 && this.vY > 0)
				{
					if (l.tiles[(int) this.x][roundUp(this.y - .25)].isSolid && l.tiles[(int) this.x][roundUp(this.y - .25)].id != 16)
					{
						this.stuck = true;
					}
				}
				else if (this.vX == 0 && this.vY < 0)
				{
					if (l.tiles[(int) this.x][roundDown(this.y + .25)].isSolid && l.tiles[(int) this.x][roundUp(this.y - .25)].id != 16)
					{
						this.stuck = true;
					}
				}
				else if (this.vY == 0 && this.vX > 0)
				{
					if (l.tiles[roundUp(this.x - .25)][(int) this.y].isSolid && l.tiles[(int) this.x][roundUp(this.y - .25)].id != 16)
					{
						this.stuck = true;
					}
				}
				else if (this.vY == 0 && this.vX < 0)
				{
					if (l.tiles[roundDown(this.x + .25)][(int) this.y].isSolid && l.tiles[(int) this.x][roundUp(this.y - .25)].id != 16)
					{
						this.stuck = true;
					}
				}
			//}
		}
		return this;
	}
}