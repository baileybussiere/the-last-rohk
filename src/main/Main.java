package main;

import java.io.IOException;

import graphics.GameI;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.SwingUtilities;

import data.LibLibrary;

public class Main
{
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				new Main();
			}
		});
	}
	
	public Main()
	{
		LibLibrary lib = null;
		try
		{
			lib = new LibLibrary();
		}
		catch (LineUnavailableException | IOException | UnsupportedAudioFileException e)
		{
			e.printStackTrace();
		}
		@SuppressWarnings("unused")
		GameI game = new GameI(lib);
	}
}