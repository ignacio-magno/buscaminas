package cl.ignaciolp;

import Logic.Tablero;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class GameX extends ScreenAdapter {
    private Tablero tablero;
    private GameTextures texture;
    private Stage stage;
    private Stage uiStage;

    public GameX() {
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        stage.act(delta);
        uiStage.act(delta);
        uiStage.draw();
        stage.draw();

        if (tablero.Win()){
            System.out.println("Ganaste");
        }

        if (tablero.Lose()){
            System.out.println("Perdiste");
        }
    }

    @Override
    public void show() {
        tablero = Logic.TableroBuilder
            .Create(7,8)
            .WithMines(2,2)
            .Build();

        texture = new GameTextures();
        stage = new Stage(new FitViewport(tablero.getWidth(), tablero.getHeight()));
        Gdx.input.setInputProcessor(stage);

        //DrawTablero();

        Skin skin = new Skin(Gdx.files.internal("uiskin.json")); // Usa un skin de LibGDX

        uiStage = new Stage(new FitViewport(800, 900)); // Mayor resolución para UI

        // Crear el Label para "Perdiste"
        Label loseLabel = new Label("¡Perdiste!", skin);
        loseLabel.setFontScale(1f);
        loseLabel.setVisible(true);

        uiStage.addActor(loseLabel);
    }

    private void DrawTablero() {
        for (int i = 0; i < tablero.getWidth(); i++) {
            for (int j = 0; j < tablero.getHeight(); j++) {
                CellActor actor = new CellActor(texture, i, j, tablero);
                stage.addActor(actor);
            }
        }
    }


    @Override
    public void dispose() {
        texture.dispose();
        stage.dispose();
    }
}
