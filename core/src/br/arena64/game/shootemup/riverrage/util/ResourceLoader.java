package br.arena64.game.shootemup.riverrage.util;

import java.io.File;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public final class ResourceLoader {
	public static File map1;
	public static File map2;
	
	public static Texture player1;
	public static Texture player1_projectile;
	public static Texture player2;
	public static Texture player2_projectile;
	
	public static Texture fuelMeter;
	public static Texture fuelMeterIndicator;
	
	public static Texture water;
	public static Texture grass;
	public static Texture house;
	
	public static Texture gasStation;
	public static Texture enemyBoat;
	public static Texture enemyCopter;
	public static Texture enemyJet;
		
	public static Sound explosion1;
	public static Sound explosion2;
	public static Sound shoot;
	public static Sound fuelDown;
	public static Sound fuelUp;
	
	public static Music musicStage1;
	
	static {
		map1 = Gdx.files.internal("map/stage1.png").file();
		map2 = Gdx.files.internal("map/stage2.png").file();
		
		fuelMeter = new Texture(Gdx.files.internal("interface/fuel_meter.png"));
		fuelMeterIndicator = new Texture(Gdx.files.internal("interface/fuel_meter_indicator.png"));
		
		player1 = new Texture(Gdx.files.internal("units/player1.png"));
		player2 = new Texture(Gdx.files.internal("units/player2.png"));
		player1_projectile = new Texture(Gdx.files.internal("units/player1_projectile.png"));
		player2_projectile = new Texture(Gdx.files.internal("units/player2_projectile.png"));
		
		gasStation = new Texture(Gdx.files.internal("units/gas_station.png"));

		grass = new Texture(Gdx.files.internal("scenario/grass.png"));
		house = new Texture(Gdx.files.internal("scenario/house.png"));
		enemyBoat = new Texture(Gdx.files.internal("units/enemy_boat.png"));
		enemyCopter = new Texture(Gdx.files.internal("units/enemy_copter.png"));
		enemyJet = new Texture(Gdx.files.internal("units/enemy_jet.png"));
		
//		explosion1 = Gdx.audio.newSound(Gdx.files.internal("explosion1.wav"));
//		explosion2 = Gdx.audio.newSound(Gdx.files.internal("explosion2.wav"));
//		shoot = Gdx.audio.newSound(Gdx.files.internal("shoot.wav"));
//		fuelDown = Gdx.audio.newSound(Gdx.files.internal("fuel_down.wav"));
//		fuelUp = Gdx.audio.newSound(Gdx.files.internal("fuel_up.wav"));
		
//		musicStage1 = Gdx.audio.newMusic(Gdx.files.internal("musicStage1.mp3"));
	}
}
