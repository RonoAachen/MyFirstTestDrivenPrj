package de.ronoweb.mathematics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VectorTest {

    @Test
    void constructor2Points() {
        Point p1 = new Point(3,2,1);
        Point p2 = new Point(6,7,8);
        Vector3D expected = new Vector3D(3,5,7);
        assertEquals(expected, new Vector3D(p1, p2));
    }

    @Test
    void magnitude() {
        Vector3D v = new Vector3D(3, 4, 5);
        assertEquals(7.071067812, v.magnitude(),0.000000001);

        v = new Vector3D(3, 4, 0);
        assertEquals(5, v.magnitude(),0.000000001);
    }

    @Test
    void add() {
        Vector3D expected = new Vector3D(7, 9, 11);
        Vector3D v = new Vector3D(3, 4, 5);
        assertEquals(expected, v.add(new Vector3D(4, 5, 6)));
    }

    @Test
    void equals() {
        Vector3D a = new Vector3D(3, 4, 5);
        assertEquals(a, new Vector3D(3, 4, 5));
        assertNotEquals(a, new Vector3D(1, 4, 5));
        assertEquals(a, a);
        assertNotEquals(null, a);
    }

    @Test
    void dotProduct(){
        Vector3D a = new Vector3D(1, 3, 5);
        Vector3D b = new Vector3D(2, 0, 4);
        assertEquals(22, a.dotProduct(b));
    }

    @Test
    void cosAlpha(){
        Vector3D a = new Vector3D(3, 4, 5);
        Vector3D b = new Vector3D(4, 2, -4);
        assertEquals(0, a.cosAlpha(b));
    }

    @Test
    void isLinearDependent() {
        Vector3D a = new Vector3D(1, 1, 1);
        Vector3D b = new Vector3D(2, 2, 2);
        assertTrue(a.isLinearDependent(b));

        b = new Vector3D(1, 2, 3);
        assertFalse(a.isLinearDependent(b));
    }

    @Test
    void crossProduct() {
        Vector3D a = new Vector3D(1, 2, 3);
        Vector3D b = new Vector3D(4, 5, 6);
        Vector3D expected = new Vector3D(-3,6,-3);
        assertEquals(expected, a.crossProduct(b));
    }
}