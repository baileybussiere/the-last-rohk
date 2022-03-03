package graphics;

public class Message
{
	public int x;
	public int y;
	public int ticks;
	public String name;
	public String type;
	
	public Message(int x, int y, String name, int ticks)
	{
		this.x = x;
		this.y = y;
		this.ticks = ticks;
		this.name = name;
	}
	
	public Message type(String l)
	{
		this.type = l;
		return this;
	}
	
	public Message tick()
	{
		this.ticks--;
		if (this.ticks <= 0)
			return null;
		else return this;
	}
}