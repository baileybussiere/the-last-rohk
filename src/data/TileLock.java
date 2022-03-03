package data;

public class TileLock extends Tile
{
	String color;
	public TileLock(int id, TextureLibrary lib, int tex, String color)
	{
		super(true, id, lib, tex);
		this.color = color;
		this.maxDamage = 0;
	}
	
	public String color()
	{
		return this.color;
	}
	
	public Tile dupl()
	{
		return new TileLock(this.id, this.texLib, this.tex, this.color);
	}
}