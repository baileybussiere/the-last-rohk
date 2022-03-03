package data;

import java.util.ArrayList;

public class TileLibrary
{
	public TextureLibrary textureLibrary;
	public ArrayList<Tile> tileList = new ArrayList<Tile>();
	
	public TileLibrary(TextureLibrary tex)
	{
		this.textureLibrary = tex;
		init();
	}
	
	public void init()
	{
		Tile wall = new Tile(true, 1, this.textureLibrary, 8);
		this.tileList.add(wall);															//0
		Tile ground = new Tile(false, 0, this.textureLibrary, 9);
		this.tileList.add(ground);															//1
		Tile exit = new Tile(false, 2, this.textureLibrary, 10);
		this.tileList.add(exit);															//2
		Tile breakableWall = new Tile(true, 3, this.textureLibrary, 11).setBreakable(3);
		this.tileList.add(breakableWall);													//3
		Tile keyCopper = new TileKey(4, this.textureLibrary, 15, "copper");
		this.tileList.add(keyCopper);														//4
		Tile keySilver = new TileKey(5, this.textureLibrary, 16, "silver");
		this.tileList.add(keySilver);														//5
		Tile keyGold = new TileKey(6, this.textureLibrary, 17, "gold");
		this.tileList.add(keyGold);															//6
		Tile keyRusted = new TileKey(7, this.textureLibrary, 18, "rusted");
		this.tileList.add(keyRusted);														//7
		Tile lockCopper = new TileLock(8, this.textureLibrary, 19, "copper");
		this.tileList.add(lockCopper);														//8
		Tile lockSilver = new TileLock(9, this.textureLibrary, 20, "silver");
		this.tileList.add(lockSilver);														//9
		Tile lockGold = new TileLock(10, this.textureLibrary, 21, "gold");
		this.tileList.add(lockGold);														//10
		Tile lockRusted = new TileLock(11, this.textureLibrary, 22, "rusted");
		this.tileList.add(lockRusted);														//11
		Tile wallSpiked = new Tile(true, 12, this.textureLibrary, 23);
		this.tileList.add(wallSpiked);														//12
		Tile wallSpiked_l = new Tile(true, 12, this.textureLibrary, 24);
		this.tileList.add(wallSpiked_l);													//13
		Tile wallSpiked_t = new Tile(true, 12, this.textureLibrary, 25);
		this.tileList.add(wallSpiked_t);													//14
		Tile wallSpiked_tl = new Tile(true, 12, this.textureLibrary, 26);
		this.tileList.add(wallSpiked_tl);													//15
		Tile wallSpiked_r = new Tile(true, 12, this.textureLibrary, 27);
		this.tileList.add(wallSpiked_r);													//16
		Tile wallSpiked_h = new Tile(true, 12, this.textureLibrary, 28);
		this.tileList.add(wallSpiked_h);													//17
		Tile wallSpiked_tr = new Tile(true, 12, this.textureLibrary, 29);
		this.tileList.add(wallSpiked_tr);													//18
		Tile wallSpiked_ht = new Tile(true, 12, this.textureLibrary, 30);
		this.tileList.add(wallSpiked_ht);													//19
		Tile wallSpiked_b = new Tile(true, 12, this.textureLibrary, 31);
		this.tileList.add(wallSpiked_b);													//20
		Tile wallSpiked_bl = new Tile(true, 12, this.textureLibrary, 32);
		this.tileList.add(wallSpiked_bl);													//21
		Tile wallSpiked_v = new Tile(true, 12, this.textureLibrary, 33);
		this.tileList.add(wallSpiked_v);													//22
		Tile wallSpiked_vl = new Tile(true, 12, this.textureLibrary, 34);
		this.tileList.add(wallSpiked_vl);													//23
		Tile wallSpiked_br = new Tile(true, 12, this.textureLibrary, 35);
		this.tileList.add(wallSpiked_br);													//24
		Tile wallSpiked_hb = new Tile(true, 12, this.textureLibrary, 36);
		this.tileList.add(wallSpiked_hb);													//25
		Tile wallSpiked_vr = new Tile(true, 12, this.textureLibrary, 37);
		this.tileList.add(wallSpiked_vr);													//26
		Tile wallSpiked_hv = new Tile(true, 12, this.textureLibrary, 38);
		this.tileList.add(wallSpiked_hv);													//27
		Tile wallSpiked_border = new Tile(true, 12, this.textureLibrary, 39);
		this.tileList.add(wallSpiked_border);												//28
		Tile wallSpiked_border1 = new Tile(true, 12, this.textureLibrary, 40);
		this.tileList.add(wallSpiked_border1);												//29
		Tile wallSpiked_border2 = new Tile(true, 12, this.textureLibrary, 41);
		this.tileList.add(wallSpiked_border2);												//30
		Tile wallSpiked_border3 = new Tile(true, 12, this.textureLibrary, 42);
		this.tileList.add(wallSpiked_border3);												//31
		Tile grass = new Tile(false, 13, this.textureLibrary, 43);
		this.tileList.add(grass);															//32
		Tile wallStone = new Tile(true, 14, this.textureLibrary, 44);
		this.tileList.add(wallStone);														//33
		Tile wallDirt = new Tile(true, 15, this.textureLibrary, 45).setBreakable(4);
		this.tileList.add(wallDirt);														//34
		Tile ballista = new TileBallista(16, textureLibrary, 49, 0);
		this.tileList.add(ballista);														//35
		Tile ballista2 = new TileBallista(16, textureLibrary, 49, 1);
		this.tileList.add(ballista2);														//36
		Tile ballista3 = new TileBallista(16, textureLibrary, 49, 2);
		this.tileList.add(ballista3);														//37
		Tile ballista4 = new TileBallista(16, textureLibrary, 49, 3);
		this.tileList.add(ballista4);														//38
		Tile spikeTrap = new TileSpikeTrap(17, textureLibrary, 56);
		this.tileList.add(spikeTrap);														//39
	}
}