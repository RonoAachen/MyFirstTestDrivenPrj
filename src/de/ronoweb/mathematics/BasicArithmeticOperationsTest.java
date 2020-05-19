package de.ronoweb.mathematics;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BasicArithmeticOperationsTest {
    @Test
    void add() {
        assertEquals(7, BasicArithmeticOperations.add(3,4));
    }

    @Test
    void sub() {
        assertEquals(-1, BasicArithmeticOperations.sub(3,4));
    }

    @Test
    void mul() {
        assertEquals(12, BasicArithmeticOperations.mul(3,4));
    }

    @Test
    void div() {
        assertEquals(2, BasicArithmeticOperations.div(4, 2));
        assertEquals(Double.POSITIVE_INFINITY, BasicArithmeticOperations.div(4, 0));
    }
}