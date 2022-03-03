package data;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class TextureLibrary
{
	public ArrayList<Image> imageListTile = new ArrayList<Image>();
	public ArrayList<Image> imageListEnt = new ArrayList<Image>();
	public ArrayList<Image> imageListParticles = new ArrayList<Image>();
	public ArrayList<Image> imageListGUI = new ArrayList<Image>();
	ArrayList<Image> imageList = new ArrayList<Image>();
	public ArrayList<Image[]> animationList = new ArrayList<Image[]>();
	
	public TextureLibrary()
	{
		initTile();
		initEnt();
		initGUI();
		initImages();
		initParticles();
		initAnims();
	}
	private void initImages()
	{
		final Image EXPLODE_1 = new ImageIcon("src/resources/Anim/Explode/2.png").getImage();
		this.imageList.add(EXPLODE_1);
		final Image EXPLODE_2 = new ImageIcon("src/resources/Anim/Explode/4.png").getImage();
		this.imageList.add(EXPLODE_2);
		final Image EXPLODE_3 = new ImageIcon("src/resources/Anim/Explode/6.png").getImage();
		this.imageList.add(EXPLODE_3);
		final Image EXPLODE_4 = new ImageIcon("src/resources/Anim/Explode/8.png").getImage();
		this.imageList.add(EXPLODE_4);
		final Image EXPLODE_5 = new ImageIcon("src/resources/Anim/Explode/9.png").getImage();
		this.imageList.add(EXPLODE_5);
		final Image EXPLODE_6 = new ImageIcon("src/resources/Anim/Explode/10.png").getImage();
		this.imageList.add(EXPLODE_6);
		final Image EXPLODE_7 = new ImageIcon("src/resources/Anim/Explode/11.png").getImage();
		this.imageList.add(EXPLODE_7);
		final Image EXPLODE_8 = new ImageIcon("src/resources/Anim/Explode/12.png").getImage();
		this.imageList.add(EXPLODE_8);
		final Image EXPLODE_9 = new ImageIcon("src/resources/Anim/Explode/13.png").getImage();
		this.imageList.add(EXPLODE_9);
	}
	private void initParticles()
	{
		final Image PARTICLE_1 = new ImageIcon("src/resources/Particles/1.png").getImage();
		this.imageListParticles.add(PARTICLE_1);
	}
	private void initAnims()
	{
		this.animationList.add(createAnim(9, 4));
	}
	private Image[] createAnim(int i, int j)
	{
		Image[] anim = new Image[i*j];
		for (int a = 0; a < i; a++)
		{
			for (int b = 0; b < j; b++)
			{
				anim[(a*j) + b] = this.imageList.get(a);
			}
		}
		return anim;
	}
	private void initGUI()
	{
		final Image HELT = new ImageIcon("src/resources/GUI/Helt.png").getImage();
		imageListGUI.add(HELT);
	}
	public void initTile()
	{
		final Image BORDER_TOP = new ImageIcon("src/resources/Tiles/Border_top.png").getImage();				//0
		imageListTile.add(BORDER_TOP);
		final Image BORDER_RIGHT = new ImageIcon("src/resources/Tiles/Border_right.png").getImage();			//1
		imageListTile.add(BORDER_RIGHT);
		final Image BORDER_BOTTOM = new ImageIcon("src/resources/Tiles/Border_bottom.png").getImage();			//2
		imageListTile.add(BORDER_BOTTOM);
		final Image BORDER_LEFT = new ImageIcon("src/resources/Tiles/Border_left.png").getImage();				//3
		imageListTile.add(BORDER_LEFT);
		final Image BORDER_TL = new ImageIcon("src/resources/Tiles/Border_tl.png").getImage();					//4
		imageListTile.add(BORDER_TL);
		final Image BORDER_TR = new ImageIcon("src/resources/Tiles/Border_tr.png").getImage();					//5
		imageListTile.add(BORDER_TR);
		final Image BORDER_BR = new ImageIcon("src/resources/Tiles/Border_br.png").getImage();					//6
		imageListTile.add(BORDER_BR);
		final Image BORDER_BL = new ImageIcon("src/resources/Tiles/Border_bl.png").getImage();					//7
		imageListTile.add(BORDER_BL);
		final Image WALL = new ImageIcon("src/resources/Tiles/Wall.png").getImage();							//8
		imageListTile.add(WALL);
		final Image GROUND = new ImageIcon("src/resources/Tiles/Ground.png").getImage();						//9
		imageListTile.add(GROUND);
		final Image EXIT = new ImageIcon("src/resources/Tiles/Exit.png").getImage();							//10
		imageListTile.add(EXIT);
		final Image WALL_B_0 = new ImageIcon("src/resources/Tiles/Wall_b_0.png").getImage();					//11
		imageListTile.add(WALL_B_0);
		final Image WALL_B_1 = new ImageIcon("src/resources/Tiles/Wall_b_1.png").getImage();					//12
		imageListTile.add(WALL_B_1);
		final Image WALL_B_2 = new ImageIcon("src/resources/Tiles/Wall_b_2.png").getImage();					//13
		imageListTile.add(WALL_B_2);
		final Image SIGN = new ImageIcon("src/resources/Tiles/Sign.png").getImage();							//14
		imageListTile.add(SIGN);
		final Image KEY_COPPER = new ImageIcon("src/resources/Tiles/Key_copper.png").getImage();				//15
		imageListTile.add(KEY_COPPER);
		final Image KEY_SILVER = new ImageIcon("src/resources/Tiles/Key_silver.png").getImage();				//16
		imageListTile.add(KEY_SILVER);
		final Image KEY_GOLD = new ImageIcon("src/resources/Tiles/Key_gold.png").getImage();					//17
		imageListTile.add(KEY_GOLD);
		final Image KEY_RUSTED = new ImageIcon("src/resources/Tiles/Key_rusted.png").getImage();				//18
		imageListTile.add(KEY_RUSTED);
		final Image LOCK_COPPER = new ImageIcon("src/resources/Tiles/Lock_copper.png").getImage();				//19
		imageListTile.add(LOCK_COPPER);
		final Image LOCK_SILVER = new ImageIcon("src/resources/Tiles/Lock_silver.png").getImage();				//20
		imageListTile.add(LOCK_SILVER);
		final Image LOCK_GOLD = new ImageIcon("src/resources/Tiles/Lock_gold.png").getImage();					//21
		imageListTile.add(LOCK_GOLD);
		final Image LOCK_RUSTED = new ImageIcon("src/resources/Tiles/Lock_rusted.png").getImage();				//22
		imageListTile.add(LOCK_RUSTED);
		final Image WALLSPIKED = new ImageIcon("src/resources/Tiles/WallSpiked.png").getImage();				//23
		imageListTile.add(WALLSPIKED);
		final Image WALLSPIKED_l = new ImageIcon("src/resources/Tiles/WallSpiked_l.png").getImage();			//24
		imageListTile.add(WALLSPIKED_l);
		final Image WALLSPIKED_t = new ImageIcon("src/resources/Tiles/WallSpiked_t.png").getImage();			//25
		imageListTile.add(WALLSPIKED_t);
		final Image WALLSPIKED_tl = new ImageIcon("src/resources/Tiles/WallSpiked_tl.png").getImage();			//26
		imageListTile.add(WALLSPIKED_tl);
		final Image WALLSPIKED_r = new ImageIcon("src/resources/Tiles/WallSpiked_r.png").getImage();			//27
		imageListTile.add(WALLSPIKED_r);
		final Image WALLSPIKED_h = new ImageIcon("src/resources/Tiles/WallSpiked_h.png").getImage();			//28
		imageListTile.add(WALLSPIKED_h);
		final Image WALLSPIKED_tr = new ImageIcon("src/resources/Tiles/WallSpiked_tr.png").getImage();			//29
		imageListTile.add(WALLSPIKED_tr);
		final Image WALLSPIKED_ht = new ImageIcon("src/resources/Tiles/WallSpiked_ht.png").getImage();			//30
		imageListTile.add(WALLSPIKED_ht);
		final Image WALLSPIKED_b = new ImageIcon("src/resources/Tiles/WallSpiked_b.png").getImage();			//31
		imageListTile.add(WALLSPIKED_b);
		final Image WALLSPIKED_bl = new ImageIcon("src/resources/Tiles/WallSpiked_bl.png").getImage();			//32
		imageListTile.add(WALLSPIKED_bl);
		final Image WALLSPIKED_v = new ImageIcon("src/resources/Tiles/WallSpiked_v.png").getImage();			//33
		imageListTile.add(WALLSPIKED_v);
		final Image WALLSPIKED_vl = new ImageIcon("src/resources/Tiles/WallSpiked_vl.png").getImage();			//34
		imageListTile.add(WALLSPIKED_vl);
		final Image WALLSPIKED_br = new ImageIcon("src/resources/Tiles/WallSpiked_br.png").getImage();			//35
		imageListTile.add(WALLSPIKED_br);
		final Image WALLSPIKED_hb = new ImageIcon("src/resources/Tiles/WallSpiked_hb.png").getImage();			//36
		imageListTile.add(WALLSPIKED_hb);
		final Image WALLSPIKED_vr = new ImageIcon("src/resources/Tiles/WallSpiked_vr.png").getImage();			//37
		imageListTile.add(WALLSPIKED_vr);
		final Image WALLSPIKED_hv = new ImageIcon("src/resources/Tiles/WallSpiked_hv.png").getImage();			//38
		imageListTile.add(WALLSPIKED_hv);
		final Image WALLSPIKED_borderleft = new ImageIcon("src/resources/Tiles/WallSpiked_borderleft.png").getImage();	//39
		imageListTile.add(WALLSPIKED_borderleft);
		final Image WALLSPIKED_bordertop = new ImageIcon("src/resources/Tiles/WallSpiked_bordertop.png").getImage();	//40
		imageListTile.add(WALLSPIKED_bordertop);
		final Image WALLSPIKED_borderright = new ImageIcon("src/resources/Tiles/WallSpiked_borderright.png").getImage();//41
		imageListTile.add(WALLSPIKED_borderright);
		final Image WALLSPIKED_borderbottom = new ImageIcon("src/resources/Tiles/WallSpiked_borderbottom.png").getImage();//42
		imageListTile.add(WALLSPIKED_borderbottom);
		final Image GRASS = new ImageIcon("src/resources/Tiles/grass.png").getImage();							//43
		imageListTile.add(GRASS);
		final Image WALL_STONE = new ImageIcon("src/resources/Tiles/Wall_stone.png").getImage();				//44
		imageListTile.add(WALL_STONE);
		final Image WALL_DIRT = new ImageIcon("src/resources/Tiles/WallDirt.png").getImage();					//45
		imageListTile.add(WALL_DIRT);
		final Image WALL_DIRT1 = new ImageIcon("src/resources/Tiles/WallDirt_1.png").getImage();				//46
		imageListTile.add(WALL_DIRT1);
		final Image WALL_DIRT2 = new ImageIcon("src/resources/Tiles/WallDirt_2.png").getImage();				//47
		imageListTile.add(WALL_DIRT2);
		final Image WALL_DIRT3 = new ImageIcon("src/resources/Tiles/WallDirt_3.png").getImage();				//48
		imageListTile.add(WALL_DIRT3);
		final Image BALLISTA = new ImageIcon("src/resources/Tiles/catapult.png").getImage();					//49
		imageListTile.add(BALLISTA);
		final Image BALLISTA0 = new ImageIcon("src/resources/Tiles/catapult_0.png").getImage();					//50
		imageListTile.add(BALLISTA0);
		final Image BALLISTA1 = new ImageIcon("src/resources/Tiles/catapult_1.png").getImage();					//51
		imageListTile.add(BALLISTA1);
		final Image BALLISTA2 = new ImageIcon("src/resources/Tiles/catapult_2.png").getImage();					//52
		imageListTile.add(BALLISTA2);
		final Image BALLISTA3 = new ImageIcon("src/resources/Tiles/catapult_3.png").getImage();					//53
		imageListTile.add(BALLISTA3);
		final Image BALLISTA4 = new ImageIcon("src/resources/Tiles/catapult_4.png").getImage();					//54
		imageListTile.add(BALLISTA4);
		final Image BALLISTA5 = new ImageIcon("src/resources/Tiles/catapult_5.png").getImage();					//55
		imageListTile.add(BALLISTA5);
		final Image SPIKETRAP0 = new ImageIcon("src/resources/Tiles/SpikeTrap_0.png").getImage();					//56
		imageListTile.add(SPIKETRAP0);
		final Image SPIKETRAP1 = new ImageIcon("src/resources/Tiles/SpikeTrap_1.png").getImage();					//57
		imageListTile.add(SPIKETRAP1);
		final Image SPIKETRAP2 = new ImageIcon("src/resources/Tiles/SpikeTrap_2.png").getImage();					//58
		imageListTile.add(SPIKETRAP2);
		final Image SPIKETRAP3 = new ImageIcon("src/resources/Tiles/SpikeTrap_3.png").getImage();					//59
		imageListTile.add(SPIKETRAP3);
	}
	public void initEnt()
	{
		final Image PLAYER = new ImageIcon("src/resources/Entities/Player.png").getImage();
		imageListEnt.add(PLAYER);
		final Image BOMB1 = new ImageIcon("src/resources/Entities/Bomb1.png").getImage();
		imageListEnt.add(BOMB1);
		final Image BOLT_LEFT = new ImageIcon("src/resources/Entities/bolt_left.png").getImage();
		imageListEnt.add(BOLT_LEFT);
		final Image BOLT_UP = new ImageIcon("src/resources/Entities/bolt_up.png").getImage();
		imageListEnt.add(BOLT_UP);
		final Image BOLT_RIGHT = new ImageIcon("src/resources/Entities/bolt_right.png").getImage();
		imageListEnt.add(BOLT_RIGHT);
		final Image BOLT_DOWN = new ImageIcon("src/resources/Entities/bolt_down.png").getImage();
		imageListEnt.add(BOLT_DOWN);
	}
}