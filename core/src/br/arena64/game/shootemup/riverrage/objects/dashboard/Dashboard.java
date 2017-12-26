package br.arena64.game.shootemup.riverrage.objects.dashboard;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import br.arena64.game.shootemup.riverrage.objects.base.Drawable;
import br.arena64.game.shootemup.riverrage.objects.unit.player.Plane;
import br.arena64.game.shootemup.riverrage.util.ResourceLoader;

public class Dashboard implements Drawable {

	private Plane player1;
	private Plane player2;
	private Camera camera;
	
	public Dashboard(Plane player1, Plane player2, Camera camera) {
		this.player1 = player1;
		this.player2 = player2;
		this.camera = camera;
	}
	
	private void drawPainel(SpriteBatch batch){
		ShapeRenderer srender = new ShapeRenderer();
		srender.setProjectionMatrix(batch.getProjectionMatrix());
		srender.begin(ShapeType.Filled);
		srender.setColor(0.56F, 0.56F, 0.56F, 1F);
		srender.rect(0, 0, Gdx.graphics.getWidth(), 37);
		srender.setColor(Color.BLACK);
		srender.rect(0, 37, Gdx.graphics.getWidth(), 1);
		srender.end();
	}
	
	private void drawPlayerInfo(SpriteBatch batch, Plane player) {
		Texture fuelMeter = ResourceLoader.fuelMeter;
		Texture fuelMeterIndicator = ResourceLoader.fuelMeterIndicator;
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		if(player.getPlayerNumber() == 1) {
			batch.draw(fuelMeterIndicator, player.getFuelLevel() + 22, 12);
			batch.draw(fuelMeter, 20, 10);
		} else if(player.getPlayerNumber() == 2) {
			batch.draw(fuelMeterIndicator, Gdx.graphics.getWidth() + player.getFuelLevel() - 66 - 20 - 6 - 4, 12);
			batch.draw(fuelMeter, Gdx.graphics.getWidth() - fuelMeter.getWidth() - 20, 10);
		}
		batch.end();
	}
	
	@Override
	public void draw(SpriteBatch batch) {
		drawPainel(batch);
		drawPlayerInfo(batch, player1);
		drawPlayerInfo(batch, player2);
	}
}
