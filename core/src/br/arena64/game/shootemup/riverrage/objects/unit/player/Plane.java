package br.arena64.game.shootemup.riverrage.objects.unit.player;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;

import br.arena64.game.shootemup.riverrage.objects.base.Drawable;
import br.arena64.game.shootemup.riverrage.objects.base.GameObject;
import br.arena64.game.shootemup.riverrage.objects.base.Playable;
import br.arena64.game.shootemup.riverrage.objects.unit.enemy.GasStation;
import br.arena64.game.shootemup.riverrage.objects.unit.enemy.base.Enemy;
import br.arena64.game.shootemup.riverrage.objects.unit.player.base.HitListener;
import br.arena64.game.shootemup.riverrage.util.ResourceLoader;

public class Plane extends GameObject implements Playable, Drawable, HitListener {

	private List<Enemy> enemys;
	private List<Projectile> projectiles = new ArrayList<Projectile>();
	private long score = 0;
	private float fuel = 66F;
	private int playerNumber;
	
	private long timeSpaceSpendFuel = 3000000000L;
	private long timeSpaceFillFuel = 100000000L;
	private long deltaTimeSpendFuel = TimeUtils.nanoTime();
	private long deltaTimeFillFuel = TimeUtils.nanoTime();
	
	public Plane(int playerNumber, int screenWidth, int screenHeigth, List<Enemy> enemys) {
		this((playerNumber == 1 ? ResourceLoader.player1 : ResourceLoader.player2), screenWidth, screenHeigth);
		if(playerNumber == 1)
			getCollisionBox().x = (screenWidth / 2) - getTexture().getWidth();
		else
			getCollisionBox().x = (screenWidth / 2) + getTexture().getWidth();
		getCollisionBox().y = 10;
		
		this.playerNumber = playerNumber;
		
		this.enemys = enemys;
		
		for(int i = 0 ; i < 1 ; i++) {
			projectiles.add(
					new Projectile(
						(playerNumber == 1 ? ResourceLoader.player1_projectile : ResourceLoader.player2_projectile), 
						enemys, 
						this)
					);
		}
		setVisible(true);
	}
	
	private Plane(Texture texture, int x, int y) {
		super(texture, x, y);
	}

	@Override
	public void draw(SpriteBatch batch) {
		if(isVisible()) {
			for (Enemy enemy : enemys) {
				if(enemy.isVisible() && enemy.collides(this)) {
					if(enemy instanceof GasStation) {
						if(TimeUtils.nanoTime() - deltaTimeFillFuel > timeSpaceFillFuel) {
							deltaTimeFillFuel = TimeUtils.nanoTime();
							addFuel();
						}
					} else {
						enemy.setVisible(false);
						setVisible(false);
					}
				}
			}
			batch.draw(getTexture(), getCollisionBox().x, getCollisionBox().y);
			if(TimeUtils.nanoTime() - deltaTimeSpendFuel > timeSpaceSpendFuel) {
				deltaTimeSpendFuel = TimeUtils.nanoTime();
				spendFuel();
			}
		}
		for (Projectile projectile : projectiles) {
			projectile.draw(batch);
		}
	}
	
	public void shoot() {
		if(!isVisible())
			return;
		
		Iterator<Projectile> iterator = projectiles.iterator();
		while(iterator.hasNext()) {
			Projectile p = iterator.next();
			if(!p.isVisible()) {
				p.getCollisionBox().setCenter(getCollisionBox().x + (getCollisionBox().width / 2), getCollisionBox().y);
				p.setVisible(true);
				break;
			}
		}
	}
	
	public int getPlayerNumber() {
		return playerNumber;
	}

	public long getScore() {
		return score;
	}

	public void addScore(long score) {
		this.score += score;
	}

	@Override
	public void onHit(long score) {
		addScore(score);
		System.out.println("Player hit: " + getScore());
	}

	public float getFuelLevel() {
		return fuel;
	}

	public void addFuel() {
		fuel += 5L;
		if(fuel > 66)
			fuel = 66;
	}
	
	public void spendFuel() {
		fuel -= 5L;
		if(fuel < 5)
			setVisible(false);
	}
}
