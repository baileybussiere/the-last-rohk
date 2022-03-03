package data;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class LibLibrary
{
	public TextureLibrary tex;
	public TileLibrary tile;
	public AudioLibrary audio;
	
	public LibLibrary() throws LineUnavailableException, IOException, UnsupportedAudioFileException
	{
		this.tex = new TextureLibrary();
		this.tile = new TileLibrary(this.tex);
		this.audio = new AudioLibrary();
	}
}