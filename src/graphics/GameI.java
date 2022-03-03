package graphics;

import graphics.Screen;

import java.awt.Toolkit;

import javax.swing.JFrame;

import data.LibLibrary;

public class GameI
{
	public int screenWidth;
	public int screenHeight;
	LibLibrary lib;
	
	public GameI(LibLibrary lib)
	{
		this.lib = lib;
		prepareGui();
	}
	private void prepareGui()
	{
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		screenWidth = toolkit.getScreenSize().width;
		screenHeight = toolkit.getScreenSize().height;
		JFrame frame = new JFrame();
		frame.setTitle("The Last Rohk");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		
		//Custom Icon
		
		//Custom Cursor
		
		//Screen
		frame.add(new Screen(frame, this.lib));
		frame.setVisible(true);
	}
}