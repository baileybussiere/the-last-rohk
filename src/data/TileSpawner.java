package data;

import levels.Level;
import entities.Entity;

public class TileSpawner extends Tile
{
	Entity spawn;
	
	public TileSpawner(int id, TextureLibrary lib, int tex, Entity spawn)
	{
		super(false, id, lib, tex);
		this.spawn = spawn;
	}

	public Tile dupl()
	{
		return new TileSpawner(this.id, this.texLib, this.tex, this.spawn);
	}
	
	public Tile tick(Level l, int x, int y, LibLibrary lib)
	{
		boolean x1 = false;
		boolean y1 = false;
		if (l.entities[0].x == Math.round(l.entities[0].x))
		{
			if ((int) l.entities[0].x == x)
			{
				x1 = true;
			}
		}
		else if (Math.round(l.entities[0].x) == x || Math.round(l.entities[0].x) + 1 == x)
		{
			x1 = true;
		}
		if (l.entities[0].y == Math.round(l.entities[0].y))
		{
			if ((int) l.entities[0].y == y)
			{
				y1 = true;
			}
		}
		else if (Math.round(l.entities[0].y) == y || Math.round(l.entities[0].y) + 1 == y)
		{
			y1 = true;
		}
		if (x1 && y1){}
		else
		{
			l.spawn(this.spawn.dupl());
		}
		return this;
	}
}