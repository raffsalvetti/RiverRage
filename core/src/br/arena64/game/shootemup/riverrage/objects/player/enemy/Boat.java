package br.arena64.game.shootemup.riverrage.objects.player.enemy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import br.arena64.game.shootemup.riverrage.Constants;
import br.arena64.game.shootemup.riverrage.objects.base.Drawable;
import br.arena64.game.shootemup.riverrage.objects.player.enemy.base.Enemy;
import br.arena64.game.shootemup.riverrage.util.ResourceLoader;

public class Boat extends Enemy implements Drawable {
	private boolean toRight = true;
	
	public Boat(int xPosition, int yPosition) {
		super(ResourceLoader.enemyBoat, xPosition, yPosition);
		getCollisionBox().setCenter(xPosition, yPosition);
		setVisible(true);
		setScore(20L);
	}

	@Override
	public void draw(SpriteBatch batch) {
		if(isVisible()) {
			/* MOVIMENTO X */
			if(getCollisionBox().x + getCollisionBox().width >= Gdx.graphics.getWidth())
				toRight = false;
			if(getCollisionBox().x < 0)
				toRight = true;
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
