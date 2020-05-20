package de.ronoweb;

import de.ronoweb.mathematics.BasicArithmeticOperations;
import de.ronoweb.mathematics.Matrix;
import de.ronoweb.mathematics.Vector;

public class Main {

    public static void main(String[] args) {
        System.out.println("3 + 4 = " + BasicArithmeticOperations.add(3,4));
        System.out.println("3 - 4 = " + BasicArithmeticOperations.sub(3,4));
        System.out.println("3 * 4 = " + BasicArithmeticOperations.mul(3,4));
        System.out.println("4 / 0 = " + BasicArithmeticOperations.div(4,0));

        Vector a = new Vector(1, 2, 3);
        Vector b = new Vector(4, 5, 6);
        System.out.println(a.add(b));

        System.out.println(a + " and " + b + " are equals " + a.equals(b));
        System.out.println("a x b = " + a.crossProduct(b));
        double[][] m = new double[][] {
                { 11, 12, 13 },
                { 21, 22, 23 },
                { 31, 32, 33 }
        };

//        Matrix A = new Matrix(m);
//        System.out.printf("Rows: %d, Columns:%d\n", A.GetRowCount(), A.GetColumnCount());
//        for (var row = 0; row < 3; row++) {
//            System.out.printf("%d: %.1f, %.1f, %.1f\n", row, A.GetValue(row, 0), A.GetValue(row, 1), A.GetValue(row, 2));
//        }
//
//        System.out.println(A.toString());

        Matrix A = new Matrix(3,3);
        A.SetValue(0,0, 1);
        A.SetValue(1,0, -1);
        A.SetValue(2,0, 4);

        A.SetValue(0,1, 3);
        A.SetValue(1,1, 2);
        A.SetValue(2,1, 2);

        A.SetValue(0,2, 5);
        A.SetValue(1,2, 0);
        A.SetValue(2,2, -3);

        System.out.println(A.toString());
        System.out.println("det A = " + A.determinant());

    }
}
