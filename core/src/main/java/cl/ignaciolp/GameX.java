package cl.ignaciolp;

import Logic.Cell;
import Logic.Tablero;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class GameX extends ScreenAdapter {
    private FitViewport viewport;
    private SpriteBatch batch;
    private Tablero tablero;
    private GameTextures texture;

    public GameX() {
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();

        DrawTablero();

        batch.end();
    }

    @Override
    public void show() {
        Logic.Tablero tablero = Logic.TableroBuilder
            .Create(7,8)
            .WithMines(2,2)
            .Build();

        batch = new SpriteBatch();
        viewport = new FitViewport(tablero.getWidth(), tablero.getHeight());
        texture = new GameTextures();
        this.tablero = tablero;
    }

    private void DrawTablero() {
        for (int i = 0; i < tablero.getWidth(); i++) {
            for (int j = 0; j < tablero.getHeight(); j++) {
                Logic.Cell cell = tablero.Cell(i, j);

                Texture texture = GetTexture(cell);

                batch.draw(texture, i, j, 1, 1);
            }
        }
    }

    private Texture GetTexture(Cell cell) {
        if (cell instanceof Logic.CellNotOpened ) return texture.GetDefault();
        if (cell instanceof Logic.CellMine) return texture.GetMine();
        if (cell instanceof Logic.CellEmpty) return texture.GetEmpty();

        return texture.GetNumber(1);
    }

    @Override
    public void dispose() {
        batch.dispose();
        texture.dispose();
    }
}
