package de.ronoweb;

import de.ronoweb.mathematics.BasicArithmeticOperations;
import de.ronoweb.mathematics.Vector;

public class Main {

    public static void main(String[] args) {
        System.out.println("3 + 4 = " + BasicArithmeticOperations.add(3,4));
        System.out.println("3 - 4 = " + BasicArithmeticOperations.sub(3,4));
        System.out.println("3 * 4 = " + BasicArithmeticOperations.mul(3,4));
        System.out.println("4 / 0 = " + BasicArithmeticOperations.div(4,0));

        Vector a = new Vector(3, 4, 5);
        Vector b = new Vector(3, 4, 5);
        System.out.println(a.add(b));

        System.out.println(a + " and " + b + " are equals " + a.equals(b));
    }
}
