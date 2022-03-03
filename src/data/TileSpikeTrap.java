package data;

import levels.Level;

public class TileSpikeTrap extends Tile
{
	int length;
	int dir;
	
	public TileSpikeTrap(int id, TextureLibrary lib, int texInd)
	{
		super(false, id, lib, texInd);
		this.needsTick = true;
	}
	
	public Tile tick(Level l, int x, int y, LibLibrary lib)
	{
		if (this.tick == 400)
			this.tick = 0;
		else if (this.tick > 0 && this.tick <= 200)
			this.texture = lib.tex.imageListTile.get(this.tex);
		else if (this.tick > 200 && this.tick <= 220)
			this.texture = lib.tex.imageListTile.get(this.tex + 1);
		else if (this.tick > 220 && this.tick <= 240)
			this.texture = lib.tex.imageListTile.get(this.tex + 2);
		else if (this.tick > 240)
			this.texture = lib.tex.imageListTile.get(this.tex + 3);
		return this;
	}
}