package graphics;

import java.awt.Image;

public class Particle extends Animation
{
	double v;
	double rot;
	double dec;
	
	public Particle(Image img, int x, int y, double v, double rot, double dec, int tick)
	{
		super(new Image[] {img}, x, y, img.getWidth(null), img.getHeight(null));
		this.v = v;
		this.rot = rot;
		this.dec = dec;
		this.tick = tick;
	}
	
	public Particle tick()
	{
		this.x += Math.sin(this.rot)*this.v;
		this.y += Math.cos(this.rot)*this.v;
		this.v -= this.dec;
		if (this.v <= 0)
		{
			this.v = 0;
			this.dec = 0;
		}
		this.tick--;
		if (this.tick <= 0)
			return null;
		else return this;
	}
}