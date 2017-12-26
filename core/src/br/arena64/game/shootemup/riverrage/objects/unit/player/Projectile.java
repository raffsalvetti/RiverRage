package br.arena64.game.shootemup.riverrage.objects.unit.player;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import br.arena64.game.shootemup.riverrage.objects.base.Drawable;
import br.arena64.game.shootemup.riverrage.objects.base.GameObject;
import br.arena64.game.shootemup.riverrage.objects.unit.enemy.base.Enemy;
import br.arena64.game.shootemup.riverrage.objects.unit.player.base.HitListener;

public class Projectile extends GameObject implements Drawable {

	private final int PROJECTILE_SPEED_BASE = 200;
	private List<Enemy> enemys;
	private HitListener hitListener;
	
	public Projectile(Texture texture, List<Enemy> enemys, HitListener listener) {
		super(texture, 0, 0);
		this.enemys = enemys;
		this.hitListener = listener;
	}

	@Override
	public void draw(SpriteBatch batch) {
		if(isVisible()) {
			if(getCollisionBox().y + getCollisionBox().height > Gdx.graphics.getHeight()) {
				setVisible(false);
				return;
			}
			
			for (Enemy enemy : enemys) {
				if(enemy.isVisible() && enemy.collides(this)) {
					enemy.setVisible(false);
					setVisible(false);
					if(hitListener != null)
						hitListener.onHit(enemy.getScore());
					return;
				}
			}
			
			getCollisionBox().y += PROJECTILE_SPEED_BASE * Gdx.graphics.getDeltaTime();
			batch.draw(getTexture(), getCollisionBox().x, getCollisionBox().y);
		}
	}
}
