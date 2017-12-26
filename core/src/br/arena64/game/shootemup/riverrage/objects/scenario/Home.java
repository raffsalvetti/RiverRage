package br.arena64.game.shootemup.riverrage.objects.scenario;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import br.arena64.game.shootemup.riverrage.objects.base.Drawable;
import br.arena64.game.shootemup.riverrage.util.ResourceLoader;

public class Home implements Drawable {

	@Override
	public void draw(SpriteBatch batch) {
		batch.draw(ResourceLoader.house, 0, 0);
	}

}
