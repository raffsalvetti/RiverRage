package br.arena64.game.shootemup.riverrage.objects.unit.enemy;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import br.arena64.game.shootemup.riverrage.objects.base.Drawable;
import br.arena64.game.shootemup.riverrage.objects.unit.enemy.base.Enemy;
import br.arena64.game.shootemup.riverrage.util.ResourceLoader;

public class GasStation extends Enemy implements Drawable {
	
	public GasStation(int xPosition, int yPosition) {
		super(ResourceLoader.gasStation, xPosition, yPosition);
		getCollisionBox().setCenter(xPosition, yPosition);
		setScore(60L);
		setVisible(true);
	}

	@Override
	public void draw(SpriteBatch batch) {
		if(isVisible()) {
			batch.draw(getTexture(), getCollisionBox().x, getCollisionBox().y);
		}
	}

}
