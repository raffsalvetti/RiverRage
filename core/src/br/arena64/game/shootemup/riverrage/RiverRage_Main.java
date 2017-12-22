package br.arena64.game.shootemup.riverrage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import br.arena64.game.shootemup.riverrage.objects.base.Drawable;
import br.arena64.game.shootemup.riverrage.objects.base.GameObject;
import br.arena64.game.shootemup.riverrage.objects.player.Plane;
import br.arena64.game.shootemup.riverrage.objects.player.enemy.Boat;
import br.arena64.game.shootemup.riverrage.objects.player.enemy.Copter;
import br.arena64.game.shootemup.riverrage.objects.player.enemy.Jet;
import br.arena64.game.shootemup.riverrage.objects.player.enemy.base.Enemy;
import br.arena64.game.shootemup.riverrage.util.MapLoader;

public class RiverRage_Main extends ApplicationAdapter {
	private final int PLAYER_SPEED_BASE = 100;
	private Dashboard dashboard;
	private List<GameObject> gameObjects = new ArrayList<GameObject>();
	private List<Enemy> enemys = new ArrayList<Enemy>();
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Plane player1, player2;
	
	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch = new SpriteBatch();
		MapLoader ml = new MapLoader();
		
		Random r = new Random(System.currentTimeMillis());
		
		enemys.add(new Boat(r.nextInt(Gdx.graphics.getWidth() + 1) / 2, Gdx.graphics.getHeight() / 2));
		enemys.add(new Boat(r.nextInt(Gdx.graphics.getWidth() + 1) / 3, Gdx.graphics.getHeight() / 3));
		enemys.add(new Copter(r.nextInt(Gdx.graphics.getWidth() + 1), r.nextInt(Gdx.graphics.getHeight() + 1)));
		enemys.add(new Jet(r.nextInt(Gdx.graphics.getWidth() + 1), r.nextInt(Gdx.graphics.getHeight() + 1)));
		enemys.add(new Jet(r.nextInt(Gdx.graphics.getWidth() + 1), r.nextInt(Gdx.graphics.getHeight() + 1)));
		
		gameObjects.addAll(enemys);
		
		player1 = new Plane(1, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), enemys);
		player2 = new Plane(2, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), enemys);
		
		gameObjects.add(player1);
		gameObjects.add(player2);
		dashboard = new Dashboard(player1, player2, camera);
	}
	
	private void readInput() {
		/* ------------  SYSTEM  ------------ */
		if(Gdx.input.isKeyPressed(Keys.ESCAPE)) {
			Gdx.app.exit();
		}
		
		/* ------------ PLAYER 1 ------------ */
		
		if(Gdx.input.isKeyPressed(Keys.LEFT)) {
			if(player1.getCollisionBox().x > 0)
				player1.getCollisionBox().x -= PLAYER_SPEED_BASE * Gdx.graphics.getDeltaTime();
		}
		if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
			if(player1.getCollisionBox().x + player1.getCollisionBox().width < Gdx.graphics.getWidth())
				player1.getCollisionBox().x += PLAYER_SPEED_BASE * Gdx.graphics.getDeltaTime();
		}
		if(Gdx.input.isKeyPressed(Keys.UP)) {
			if(player1.getCollisionBox().y + player1.getCollisionBox().height < Gdx.graphics.getHeight())
				player1.getCollisionBox().y += PLAYER_SPEED_BASE * Gdx.graphics.getDeltaTime();
		}
		if(Gdx.input.isKeyPressed(Keys.DOWN)) { 
			if(player1.getCollisionBox().y > 0)
				player1.getCollisionBox().y -= PLAYER_SPEED_BASE * Gdx.graphics.getDeltaTime();
		}
		if(Gdx.input.isKeyJustPressed(Keys.SPACE)) {
			player1.shoot();
		}
		
		/* ------------ PLAYER 2 ------------ */
		if(Gdx.input.isKeyJustPressed(Keys.BACKSPACE)) {
			player2.shoot();
		}
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0.18F, 0.2F, 0.72F, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();

		readInput();

		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		for (GameObject gameObject : gameObjects) {
			if(gameObject != null)
				((Drawable)gameObject).draw(batch);
		}
		batch.end();
		dashboard.draw(batch);
	}
	
	@Override
	public void dispose () {
		for (GameObject gameObject : gameObjects) {
			if(gameObject != null)
				gameObject.dispose();
		}
		batch.dispose();
	}
}
