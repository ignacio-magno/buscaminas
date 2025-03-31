package cl.ignaciolp;

import Logic.Tablero;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class CellActor extends Actor {
    private final GameTextures texture;
    private final Tablero tablero;
    private final int col;
    private final int row;
    boolean print;

    public CellActor(GameTextures texture, int col, int row, Logic.Tablero tablero) {
        this.texture = texture;
        print = col == 3 && row == 3;
        this.tablero = tablero;
        this.col = col;
        this.row = row;

        setBounds(col, row, 1, 1); // Posición y tamaño

        // Agregar listener para clicks en esta celda específica
        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                tablero.Click(col, row);
            }
        });
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        // Obtener la textura apropiada basada en el estado de la celda
        Texture cellTexture = GetTexture();
        batch.draw(cellTexture, getX(), getY(), getWidth(), getHeight());
    }

    private Texture GetTexture() {
        Logic.Cell cell = tablero.Cell(col, row);

        if (cell instanceof Logic.CellNotOpened ) return texture.GetDefault();
        if (cell instanceof Logic.CellMine) return texture.GetMine();
        if (cell instanceof Logic.CellEmpty) return texture.GetEmpty();

        return texture.GetNumber(1);
    }

}
