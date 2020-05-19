package de.ronoweb.mathematics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VectorTest {

    @Test
    void constructor2Points() {
        Point p1 = new Point(3,2,1);
        Point p2 = new Point(6,7,8);
        Vector expected = new Vector(3,5,7);
        assertEquals(expected, new Vector(p1, p2));
    }

    @Test
    void magnitude() {
        Vector v = new Vector(3, 4, 5);
        assertEquals(7.071067812, v.magnitude(),0.000000001);

        v = new Vector(3, 4, 0);
        assertEquals(5, v.magnitude(),0.000000001);
    }

    @Test
    void add() {
        Vector expected = new Vector(7, 9, 11);
        Vector v = new Vector(3, 4, 5);
        assertEquals(expected, v.add(new Vector(4, 5, 6)));
    }

    @Test
    void equals() {
        Vector a = new Vector(3, 4, 5);
        assertEquals(a, new Vector(3, 4, 5));
        assertNotEquals(a, new Vector(1, 4, 5));
        assertEquals(a, a);
        assertNotEquals(null, a);
    }

    @Test
    void dotProduct(){
        Vector a = new Vector(1, 3, 5);
        Vector b = new Vector(2, 0, 4);
        assertEquals(22, a.dotProduct(b));
    }

    @Test
    void cosAlpha(){
        Vector a = new Vector(3, 4, 5);
        Vector b = new Vector(4, 2, -4);
        assertEquals(0, a.cosAlpha(b));
    }

    @Test
    void isLinearDependent() {
        Vector a = new Vector(1, 1, 1);
        Vector b = new Vector(2, 2, 2);
        assertTrue(a.isLinearDependent(b));

        b = new Vector(1, 2, 3);
        assertFalse(a.isLinearDependent(b));
    }
}