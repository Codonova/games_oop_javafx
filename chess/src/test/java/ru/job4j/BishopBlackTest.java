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

public class BishopBlackTest {
    @Test
    public void whenTruePosition() {
        BishopBlack bb = new BishopBlack(Cell.C1);
        Cell rsl = bb.position();
        Cell expected = Cell.C1;
        assertEquals(rsl, expected);
    }

    @Test
    public void whenCopy() {
        BishopBlack bb = new BishopBlack(Cell.A1);
        Figure rsl = bb.copy(Cell.C3);
        Figure expected = new BishopBlack(Cell.C3);
        assertEquals(rsl.position(), expected.position());

    }

    @Test
    public void whenWay() {
        BishopBlack bb = new BishopBlack(Cell.B1);
        Cell[] rsl = bb.way(Cell.B1, Cell.E4);
        Cell[] expected = {Cell.C2, Cell.D3, Cell.E4};
        assertThat(rsl, is(expected));
    }

    @Test(expected = IllegalStateException.class)
    public void whenWrongDiagonal() {
        BishopBlack bb = new BishopBlack(Cell.B1);
        Cell[] rsl = bb.way(Cell.B1, Cell.D2);
    }
}
