package ru.job4j;

import org.junit.Test;
import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.KingBlack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class LogicTest {
    @Test
    public void whenFigureOnTheWay() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.B1));
        logic.add(new KingBlack(Cell.C2));
        assertThat(logic.move(Cell.B1, Cell.D3), is(false));
    }

    @Test
    public void whenMove() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.B1));
        boolean rsl = logic.move(Cell.B1, Cell.D3);
        boolean expected = true;
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenMoveWithOutFigureOnSource() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        boolean rsl = logic.move(Cell.B1, Cell.D3);
        assertThat(rsl, is(false));
    }

    @Test
    public void whenWrongDiagonal() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.B1));
        boolean rsl = logic.move(Cell.B1, Cell.D2);
    }

}
