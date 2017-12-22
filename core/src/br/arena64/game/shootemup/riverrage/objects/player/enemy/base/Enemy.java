package br.arena64.game.shootemup.riverrage.objects.player.enemy.base;

import com.badlogic.gdx.graphics.Texture;

import br.arena64.game.shootemup.riverrage.objects.base.GameObject;

public abstract class Enemy extends GameObject {

	private final int ENEMY_SPEED_BASE = 80;
	private long score;
	private long scoreBonus;
	private float speedModificator;
	
	public Enemy(Texture texture, int x, int y) {
		super(texture, x, y);
	}

	public long getScore() {
		return score;
	}

	public void setScore(long score) {
		this.score = score;
	}

	public long getScoreBonus() {
		return scoreBonus;
	}

	public void setScoreBonus(long scoreBonus) {
		this.scoreBonus = scoreBonus;
	}

	public float getSpeed() {
		return ENEMY_SPEED_BASE + speedModificator;
	}

	public void setSpeedModificator(float speedModificator) {
		this.speedModificator = speedModificator;
	}
	
}
