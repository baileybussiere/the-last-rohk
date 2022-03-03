package data;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import main.Main;

public class AudioLibrary
{
	public ArrayList<Clip> clipList= new ArrayList<Clip>();
	public ArrayList<Clip> songList= new ArrayList<Clip>();
	
	public AudioLibrary() throws LineUnavailableException, IOException, UnsupportedAudioFileException
	{
		init();
		initSongs();
	}

	private void init() throws LineUnavailableException, IOException, UnsupportedAudioFileException
	{
		Clip death = AudioSystem.getClip();
		death.open(AudioSystem.getAudioInputStream(new File("src/resources/Audio/death.wav")));
		this.clipList.add(death);
		Clip bounce = AudioSystem.getClip();
		bounce.open(AudioSystem.getAudioInputStream(new File("src/resources/Audio/bounce.wav")));
		this.clipList.add(bounce);
		Clip pickUpKey = AudioSystem.getClip();
		pickUpKey.open(AudioSystem.getAudioInputStream(new File("src/resources/Audio/pickUp.wav")));
		this.clipList.add(pickUpKey);
		Clip openLock = AudioSystem.getClip();
		openLock.open(AudioSystem.getAudioInputStream(new File("src/resources/Audio/open.wav")));
		this.clipList.add(openLock);
		Clip nextLvl = AudioSystem.getClip();
		nextLvl.open(AudioSystem.getAudioInputStream(new File("src/resources/Audio/nextLvl.wav")));
		this.clipList.add(nextLvl);
		Clip sign = AudioSystem.getClip();
		sign.open(AudioSystem.getAudioInputStream(new File("src/resources/Audio/sign.wav")));
		this.clipList.add(sign);
	}
	
	private void initSongs() throws LineUnavailableException, IOException, UnsupportedAudioFileException
	{
		Clip song1 = AudioSystem.getClip();
		song1.open(AudioSystem.getAudioInputStream(new File("src/resources/Audio/song 1.wav")));
		this.songList.add(song1);
		Clip song2 = AudioSystem.getClip();
		song2.open(AudioSystem.getAudioInputStream(new File("src/resources/Audio/song 2.wav")));
		this.songList.add(song2);
	}
}