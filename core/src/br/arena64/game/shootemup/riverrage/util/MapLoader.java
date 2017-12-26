package br.arena64.game.shootemup.riverrage.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.arena64.game.shootemup.riverrage.objects.base.Drawable;
import br.arena64.game.shootemup.riverrage.objects.scenario.Grass;
import br.arena64.game.shootemup.riverrage.objects.scenario.Home;

public class MapLoader {
	
	private final static char GRASS = 'G';
	private final static char RIVER = ' ';
	private final static char ROAD = 'S';
	private final static char BRIDGE = 'B';
	private final static char HOUSE = 'H';
	private final static char UPPER_LEFT_CORNER = 'I';
	private final static char UPPER_RIGHT_CORNER = 'O';
	private final static char BOTTOM_LEFT_CORNER = 'K';
	private final static char BOTTOM_RIGHT_CORNER = 'L';
	
	public List<Drawable> load(int mapNumber) throws IOException {
		List<Drawable> mapElements = new ArrayList<Drawable>();
		BufferedReader br = new BufferedReader(new FileReader(ResourceLoader.map1));
		try {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    String everything = sb.toString();
		} finally {
		    br.close();
		}
		return mapElements;
	}
	
	private Drawable loadDrawableByCode(char code) {
		Drawable drawable;
		switch (code) {
		case GRASS:
			drawable = new Grass(0, 0);
			break;
		case HOUSE:
			drawable = new Home();	
		default:
			drawable = null;
			break;
		}
		return drawable;
	}
}
