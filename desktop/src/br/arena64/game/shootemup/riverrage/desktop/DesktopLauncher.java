package br.arena64.game.shootemup.riverrage.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import br.arena64.game.shootemup.riverrage.RiverRage_Main;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "River Rage";
		config.width = 320;
		config.height = 240;
		config.resizable = false;
		new LwjglApplication(new RiverRage_Main(), config);
	}
}
