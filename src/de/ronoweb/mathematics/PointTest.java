package de.ronoweb.mathematics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    void testEquals() {
        Point p1 = new Point(3, 4, 5);
        assertEquals(p1, new Point(3, 4, 5));
        assertNotEquals(p1, new Point(1, 4, 5));
        assertEquals(p1, p1);
        assertNotEquals(null, p1);
    }

    @Test
    void testToString() {
        String expected = "x=1,11 y=2,22 z=3,33";
        assertEquals(expected, new Point(1.1111, 2.22222, 3.333333).toString());
    }

    Point p;

    @BeforeEach
    void setUp() {
        p = new Point(1, 2, 3);
    }

    @Test
    void getX() {
        assertEquals(1, p.GetX());
    }

    @Test
    void getY() {
        assertEquals(2, p.GetY());
    }

    @Test
    void getZ() {
        assertEquals(3, p.GetZ());
    }


}