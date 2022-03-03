package data;

import java.awt.Image;

import levels.Level;

public class Tile
{
	public boolean isKey = false;
	public boolean isSolid;
	public boolean breakable = false;
	public Boolean[] borders = new Boolean[4];
	public Boolean[] corners = new Boolean[4];
 	public Image texture;
	public int id;
	public int tex;
	public int damage = 0;
	public int maxDamage = 0;
	public boolean needsTick = false;
	public int tick = 0;
	public TextureLibrary texLib;
	
	public Tile(boolean isSolid, int id, TextureLibrary lib, int tex)
	{
		this.isSolid = isSolid;
		this.id = id;
		this.tex = tex;
		this.texLib = lib;
		this.texture = this.texLib.imageListTile.get(this.tex);
	}
	
	public Tile placeBorders(boolean t, boolean r, boolean b, boolean l)
	{
		this.borders = new Boolean[]{t, r, b, l};
		return this;
	}
	
	public Tile setBreakable(int max)
	{
		if (max > 0)
		{
			this.breakable = true;
			this.maxDamage = max;
		}
		return this;
	}
	
	public Tile tick(Level l, int x, int y, LibLibrary lib)
	{
		return this;
	}
	
	public String color()
	{
		return null;
	}
	
	public Tile placeCorners(boolean tl, boolean tr, boolean br, boolean bl)
	{
		if (this.borders[0])
		{
			tl = false;
			tr = false;
		}
		if (this.borders[1])
		{
			tr = false;
			br = false;
		}
		if (this.borders[2])
		{
			bl = false;
			br = false;
		}
		if (this.borders[3])
		{
			tl = false;
			bl = false;
		}
		this.corners = new Boolean[]{tl, tr, br, bl};
		return this;
	}
	
	public int damage()
	{
		this.damage++;
		int i;
		if (this.damage >= this.maxDamage)
		{
			i = -1;
		}
		else 
		{
			i = 0;
			this.texture = this.texLib.imageListTile.get(this.tex + this.damage);
		}
		return i;
	}
	
	public String getText()
	{
		return null;
	}
	
	public Tile dupl()
	{
		return new Tile(this.isSolid, this.id, this.texLib, this.tex).setBreakable(this.maxDamage);
	}
}