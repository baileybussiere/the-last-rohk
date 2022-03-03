package data;

import levels.Level;
import entities.Entity;
import entities.EntityBolt;

public class TileBallista extends Tile
{
	public Entity bolt;
	public int rot;
	
	public TileBallista(int id, TextureLibrary lib, int tex, int rot)
	{
		super(true, id, lib, tex);
		this.rot = rot;
		this.needsTick = true;
		this.tick = 200;
	}

	public Tile load(Entity bolt)
	{
		this.bolt = bolt;
		return this;
	}
	
	public Tile dupl()
	{
		return new TileBallista(this.id, this.texLib, this.tex, this.rot).load(this.bolt);
	}
	
	public Tile tick(Level l, int x, int y, LibLibrary lib)
	{
		this.tick--;
		if (this.tick == 0)
		{
			this.tick = 200;
			this.texture = this.texLib.imageListTile.get(this.tex);
			switch (this.rot)
			{
				case 0:
				{
					l.spawn(new EntityBolt(x, y - 1, 0, -1, 2, lib));
					return this;
				}
				case 1:
				{
					l.spawn(new EntityBolt(x - 1, y, -1, 0, 3, lib));
					return this;
				}
				case 2:
				{
					l.spawn(new EntityBolt(x, y + 1, 0, 1, 4, lib));
					return this;
				}
				case 3:
				{
					l.spawn(new EntityBolt(x + 1, y, 1, 0, 5, lib));
					return this;
				}
			}
		}
		else if (this.tick > 0 && this.tick <= 15)
		{
			this.texture = this.texLib.imageListTile.get(this.tex + 6);
		}
		else if (this.tick > 15 && this.tick <= 30)
		{
			this.texture = this.texLib.imageListTile.get(this.tex + 5);
		}
		else if (this.tick > 30 && this.tick <= 45)
		{
			this.texture = this.texLib.imageListTile.get(this.tex + 4);
		}
		else if (this.tick > 15*3 && this.tick <= 20*3)
		{
			this.texture = this.texLib.imageListTile.get(this.tex + 3);
		}
		else if (this.tick > 20*3 && this.tick <= 25*3)
		{
			this.texture = this.texLib.imageListTile.get(this.tex + 2);
		}
		else if (this.tick > 25*3 && this.tick <= 30*3)
		{
			this.texture = this.texLib.imageListTile.get(this.tex + 1);
		}
		else
		{
			this.texture = this.texLib.imageListTile.get(this.tex);
		}
		return this;
	}
}