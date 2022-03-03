package levels;

import data.LibLibrary;
import data.Tile;
import data.TileBallista;
import entities.Entity;
import entities.EntityBolt;

public class Level
{
	LibLibrary lib;
	public Tile tiles[][] = new Tile[38][25];
	public Tile tiles2[][] = new Tile[38][25];
	//public ArrayList<Entity> ents2 = new ArrayList<Entity>();
	public Entity ents2[] = new Entity[10];
	public Entity entities[];
	private int ent2t = 0;
	
	public Level(int[][] tileCodes, int[][] t2codes, Entity[] entity, LibLibrary lib)
	{
		this.lib = lib;
		this.entities = entity;
		this.placeTiles(tileCodes);
		this.place2Tiles(t2codes);
	}
	
	public void spawn(Entity ent)
	{
		if (this.ent2t < 10)
		{
			this.ents2[ent2t] = ent;
			this.ent2t++;
		}
		else
		{
			this.ent2t = 0;
			this.ents2[ent2t] = ent;
			this.ent2t++;
		}
	}
	
	public void spawn(Entity[] ent)
	{
		for (int i = 0; i < ent.length; i++)
		{
			if (this.ent2t < 10)
			{
				this.ents2[ent2t] = ent[i];
				this.ent2t++;
			}
			else
			{
				this.ent2t = 0;
				this.ents2[ent2t] = ent[i];
				this.ent2t++;
			}
		}
	}

	private void placeTiles(int[][] t)
	{
		if (t != null)
		{
		for (int y = 0; y < 25; y++)
		{
			for (int x = 0; x < 38; x++)
			{
				if (t[x][y] == 1)
					this.tiles[x][y] = this.lib.tile.tileList.get(0).dupl();
				else if (t[x][y] == 0)
					this.tiles[x][y] = this.lib.tile.tileList.get(1).dupl();
				else if (t[x][y] == 2)
					this.tiles[x][y] = this.lib.tile.tileList.get(32).dupl();
				else if (t[x][y] == 3)
					this.tiles[x][y] = this.lib.tile.tileList.get(33).dupl();
				else
					this.tiles[x][y] = this.lib.tile.tileList.get(t[x][y]).dupl();
			}
		}
		for (int y = 0; y < 25; y++)
		{
			for (int x = 0; x < 38; x++)
			{
				boolean[] borders = new boolean[4];
				boolean[] corners = new boolean[4];
				if (y - 1 >= 0)
				{
					if (this.tiles[x][y - 1].id != this.tiles[x][y].id)
						borders[0] = true;
				}
				if (x + 1 < 38)
				{
					if (this.tiles[x + 1][y].id != this.tiles[x][y].id)
						borders[1] = true;
				}
				if (y + 1 < 25)
				{
					if (this.tiles[x][y + 1].id != this.tiles[x][y].id)
						borders[2] = true;
				}
				if (x - 1 >= 0)
				{
					if (this.tiles[x - 1][y].id != this.tiles[x][y].id)
						borders[3] = true;
				}
				if (y - 1 >= 0 && x + 1 < 38)
				{
					if (this.tiles[x + 1][y - 1].id != this.tiles[x][y].id)
						corners[1] = true;
				}
				if (y - 1 >= 0 && x - 1 >= 0)
				{
					if (this.tiles[x - 1][y - 1].id != this.tiles[x][y].id)
						corners[0] = true;
				}
				if (y + 1 < 25 && x + 1 < 38)
				{
					if (this.tiles[x + 1][y + 1].id != this.tiles[x][y].id)
						corners[2] = true;
				}
				if (y + 1 < 25 && x - 1 >= 0 )
				{
					if (this.tiles[x - 1][y + 1].id != this.tiles[x][y].id)
						corners[3] = true;
				}				
				if (this.tiles[x][y].isSolid == true)
				{
					this.tiles[x][y].placeBorders(borders[0], borders[1], borders[2], borders[3]);
					this.tiles[x][y].placeCorners(corners[0], corners[1], corners[2], corners[3]);
				}
			}
		}
		}
	}
	
	private void place2Tiles(int[][] t)
	{
		if (t != null)
		for (int y = 0; y < 25; y++)
		{
			for (int x = 0; x < 38; x++)
			{
				if (t[x][y] == 1)
					this.tiles2[x][y] = this.lib.tile.tileList.get(0);
				else if (t[x][y] == 0)
					this.tiles2[x][y] = null;
				else if (t[x][y] >= 8 && t[x][y] <= 11)
				{
					Tile shite = this.lib.tile.tileList.get(t[x][y]).dupl();
					this.tiles2[x][y] = shite;
					this.tiles2[x-1][y] = shite;
					this.tiles2[x][y-1] = shite;
					this.tiles2[x-1][y-1] = shite;
				}
				else if (t[x][y] >= 90 && t[x][y] <= 93)
				{
					int qwe = t[x][y] - 90;
					this.tiles2[x][y] = ((TileBallista) this.lib.tile.tileList.get(35 + qwe)).load(new EntityBolt(0, 0, 0, 0, 0, lib)).dupl();
				}
				else
					this.tiles2[x][y] = this.lib.tile.tileList.get(t[x][y]).dupl();
			}
		}
		for (int y = 1; y < 24; y++)
		{
			for (int x = 1; x < 37; x++)
			{
				if (this.tiles2[x][y] != null && this.tiles2[x][y].id == 12)
				{
					int i = 0;
					if (this.tiles2[x-1][y] != null && this.tiles2[x-1][y].id == this.tiles2[x][y].id)
						i++;
					if (this.tiles2[x][y-1] != null && this.tiles2[x][y-1].id == this.tiles2[x][y].id)
						i += 2;
					if (this.tiles2[x+1][y] != null && this.tiles2[x+1][y].id == this.tiles2[x][y].id)
						i += 4;
					if (this.tiles2[x][y+1] != null && this.tiles2[x][y+1].id == this.tiles2[x][y].id)
						i += 8;
					this.tiles2[x][y] = this.lib.tile.tileList.get(this.tiles2[x][y].id + i);
				}
			}
		}
		for (int x = 0; x < 38; x++)
		{
			if (this.tiles2[x][0] != null && this.tiles2[x][0].id == 12)
			{
				this.tiles2[x][0] = this.lib.tile.tileList.get(this.tiles2[x][0].id + 17);
			}
			if (this.tiles2[x][24] != null && this.tiles2[x][24].id == 12)
			{
				this.tiles2[x][24] = this.lib.tile.tileList.get(this.tiles2[x][24].id + 19);
			}
		}
		for (int y = 0; y < 25; y++)
		{
			if (this.tiles2[0][y] != null && this.tiles2[0][y].id == 12)
			{
				this.tiles2[0][y] = this.lib.tile.tileList.get(this.tiles2[0][y].id + 16);
			}
			if (this.tiles2[37][y] != null && this.tiles2[37][y].id == 12)
			{
				this.tiles2[37][y] = this.lib.tile.tileList.get(this.tiles2[37][y].id + 18);
			}
		}
	}
}