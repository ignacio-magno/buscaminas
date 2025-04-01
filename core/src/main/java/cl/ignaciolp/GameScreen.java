package cl.ignaciolp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameScreen extends ScreenAdapter {
    private Stage uiStage;
    private Stage boardStage;
    private Viewport uiViewport;
    private Viewport boardViewport;
    private SpriteBatch batch;

    public GameScreen() {
        batch = new SpriteBatch();

        // Viewport para la UI (Mismo ancho que el tablero)
        uiViewport = new ScreenViewport();
        uiStage = new Stage(uiViewport, batch);

        // Viewport para el tablero (Mantiene proporciones)
        boardViewport = new FitViewport(800, 600);
        boardStage = new Stage(boardViewport, batch);

        // Crear una tabla para la UI arriba
        Table uiTable = new Table();
        uiTable.top().setFillParent(true);
        uiTable.add(new Label("Puntaje: 0", new Label.LabelStyle(new BitmapFont(), Color.WHITE))).expandX().padTop(10);
        uiStage.addActor(uiTable);

        // Fondo del tablero
        Image boardBackground = new Image(new Texture("tapado.png"));
        boardBackground.setSize(800, 600);
        boardStage.addActor(boardBackground);
    }

    @Override
    public void render(float delta) {
        // Limpiar pantalla
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Dibujar UI
        uiStage.act(delta);
        uiStage.draw();

        // Dibujar el tablero
        boardStage.act(delta);
        boardStage.draw();
    }

    @Override
    public void resize(int width, int height) {
        uiViewport.update(width, height, true);

        // Ajustar viewport del tablero para que su ancho sea el mismo que el de la UI
        boardViewport.update(width, (int) (height * 0.75f), true);
    }

    @Override
    public void dispose() {
        uiStage.dispose();
        boardStage.dispose();
        batch.dispose();
    }
}

