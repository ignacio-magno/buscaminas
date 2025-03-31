package cl.ignaciolp;

import Logic.Cell;
import Logic.Tablero;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class CellActor extends Actor {
    private final GameTextures texture;
    private final Logic.Cell cell;

    public CellActor(Logic.Cell cell, GameTextures texture, int col, int row) {
        this.cell = cell;
        this.texture = texture;

        setBounds(col, row, 1, 1); // Posición y tamaño

        // Agregar listener para clicks en esta celda específica
        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("Clicked on " + col + ", " + row);
            }
        });
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        // Obtener la textura apropiada basada en el estado de la celda
        Texture cellTexture = GetTexture(cell);
        batch.draw(cellTexture, getX(), getY(), getWidth(), getHeight());
    }

    private Texture GetTexture(Cell cell) {
        if (cell instanceof Logic.CellNotOpened ) return texture.GetDefault();
        if (cell instanceof Logic.CellMine) return texture.GetMine();
        if (cell instanceof Logic.CellEmpty) return texture.GetEmpty();

        return texture.GetNumber(1);
    }

}
