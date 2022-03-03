package data;

public class TileKey extends Tile
{
	String color;
	public TileKey(int id, TextureLibrary lib, int tex, String color)
	{
		super(false, id, lib, tex);
		this.color = color;
		this.isKey = true;
	}
	
	public String color()
	{
		return this.color;
	}
	
	public Tile dupl()
	{
		return new TileKey(this.id, this.texLib, this.tex, this.color);
	}
}
