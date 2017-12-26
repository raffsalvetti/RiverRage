package br.arena64.game.shootemup.riverrage.objects.unit.enemy;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import br.arena64.game.shootemup.riverrage.objects.base.Drawable;
import br.arena64.game.shootemup.riverrage.objects.unit.enemy.base.Enemy;
import br.arena64.game.shootemup.riverrage.util.Constants;
import br.arena64.game.shootemup.riverrage.util.ResourceLoader;

public class Jet extends Enemy implements Drawable {
	private boolean toRight = true;
	
	public Jet(int xPosition, int yPosition) {
		super(ResourceLoader.enemyJet, xPosition, yPosition);
		getCollisionBox().setCenter(xPosition, yPosition);
		setVisible(true);
		setSpeedModificator(3F);
		setScore(40L);
		toRight = new Random(System.currentTimeMillis()).nextBoolean();
	}

	@Override
	public void draw(SpriteBatch batch) {
		if(isVisible()) {
			/* MOVIMENTO X */
			if(getCollisionBox().x >= Gdx.graphics.getWidth() + getCollisionBox().width)
				getCollisionBox().x = -1 * getCollisionBox().width;
			if(getCollisionBox().x < -1 * getCollisionBox().width)
				getCollisionBox().x = Gdx.graphics.getWidth() + getCollisionBox().width;
			getCollisionBox().x += (toRight ? 1 : -1) * getSpeed() * Gdx.graphics.getDeltaTime();
			
			/* MOVIMENTO Y */
			if(getCollisionBox().y < (-1) * getCollisionBox().getHeight())
				getCollisionBox().y = Gdx.graphics.getHeight() + getCollisionBox().getHeight();
			
			getCollisionBox().y -= Constants.Y_SPEED * Gdx.graphics.getDeltaTime();
			
			batch.draw(
					getTexture(), 
					getCollisionBox().x, 
					getCollisionBox().y, 
					getTexture().getWidth(), 
					getTexture().getHeight(),
					0,
					0,
					getTexture().getWidth(),
					getTexture().getHeight(),
					toRight,
					false
					);
		}
	}

}
