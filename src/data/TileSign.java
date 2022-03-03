package data;

public class TileSign extends Tile
{
	public String text;
	public TileSign(TextureLibrary lib, int tex, String text)
	{
		super(false, -1, lib, tex);
		this.text = text;
	}
	
	public String getText()
	{
		return this.text;
	}
	
	public Tile dupl()
	{
		return new TileSign(this.texLib, this.tex, this.text);
	}
}