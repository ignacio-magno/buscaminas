package cl.ignaciolp;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture image;
    private Sound sound;
    FitViewport viewport;
    private int position = 0;
    private ShapeRenderer shapeRenderer;

    @Override
    public void create() {
        batch = new SpriteBatch();
        image = new Texture("libgdx.png");
        sound = Gdx.audio.newSound(Gdx.files.internal("jump.wav"));
        viewport = new FitViewport(10, 10);
        sound.play();
        shapeRenderer = new ShapeRenderer();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();

        batch.draw(image,position%10 , Math.round((float) position / 10), 1,1);
        shapeRenderer.setProjectionMatrix(viewport.getCamera().combined);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(1, 0, 0, 1);
        // dibuja las lineas
        for (int i = 0; i < 10; i++) {
            shapeRenderer.line(0, i, 10, i);
            shapeRenderer.line(i, 0, i, 10);
        }

        batch.end();
        shapeRenderer.end();
        position++;
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
        sound.dispose();
    }
}
