package br.arena64.game.shootemup.riverrage.objects.base;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public abstract class GameObject {
	private Texture texture;
	private Sprite sprite;
	private Rectangle collisionBox;
	private boolean visible = false;
	
	public GameObject(Texture texture, int x, int y) {
		this.texture = texture;
		collisionBox = new Rectangle(x, y, texture.getWidth(), texture.getHeight());
	}
	
	public boolean collides(GameObject object) {
		return collisionBox.overlaps(object.getCollisionBox());
	}

	public Texture getTexture() {
		return texture;
	}

	public Sprite getSprite() {
		return sprite;
	}

	public Rectangle getCollisionBox() {
		return collisionBox;
	}
	
	public void dispose() {
		texture.dispose();
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	
}
