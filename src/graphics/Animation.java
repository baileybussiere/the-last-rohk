package graphics;

import java.awt.Image;

public class Animation
{
	public double x;
	public double y;
	public int height;
	public int width;
	public Image[] frames;
	public int tick = 0;
	
	public Animation(Image[] imgs, double x, double y, int height, int width)
	{
		this.x = x;
		this.y = y;
		this.frames = imgs;
		this.height = height;
		this.width = width;
	}
	
	public Animation tick()
	{
		this.tick++;
		if (this.tick >= this.frames.length)
			return null;
		else return this;
	}
}