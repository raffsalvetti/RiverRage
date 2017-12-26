package br.arena64.game.shootemup.riverrage.objects.scenario;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import br.arena64.game.shootemup.riverrage.objects.base.Drawable;
import br.arena64.game.shootemup.riverrage.objects.base.GameObject;
import br.arena64.game.shootemup.riverrage.util.ResourceLoader;

public class Grass extends GameObject implements Drawable {
	public Grass(int x, int y) {
		super(ResourceLoader.grass, x, y);
		getCollisionBox().x = x;
		getCollisionBox().y = y;
	}

	@Override
	public void draw(SpriteBatch batch) {
		batch.draw(getTexture(), getCollisionBox().x, getCollisionBox().y);
	}
}
