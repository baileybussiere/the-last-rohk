package data;

public class TileSign extends Tile
{
	public String text;
	public int signId;
	public TileSign(TextureLibrary lib, int signId, int tex, String text)
	{
		super(false, -1, lib, tex);
		this.signId = signId;
		this.text = text;
	}
	
	public String getText()
	{
		return this.text;
	}
	
	public Tile dupl()
	{
		return new TileSign(this.texLib, this.id, this.tex, this.text);
	}
}
