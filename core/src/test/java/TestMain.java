import org.junit.Test;

import java.util.Objects;

public class TestMain {
    @Test
    public void game(){
        Logic.Tablero tablero = Logic.TableroBuilder.Create(10, 10)
            .WithMines(10)
            .WithMines(2,5)
            .Build();

        Logic.TurnResult result = tablero.Click(2, 5);

        assert result.GameOver;
    }
}
