package de.ronoweb.mathematics;

import java.util.Arrays;

public class Matrix {
    private double[][] data;
    private int numOfRows;
    private int numOfColumns;

    public Matrix(int numOfRows, int numOfColumns) {
        this.numOfRows = numOfRows;
        this.numOfColumns = numOfColumns;
        data = new double[numOfRows][numOfColumns];
    }

    public Matrix(double[][] data) {
        this.data = data;
        this.numOfRows = data.length;
        this.numOfColumns = data[0].length;
    }

    public double GetValue(int row, int column) {
        return data[row][column];
    }

    public void SetValue(int row, int column, double value) {
        data[row][column] = value;
    }

    public int GetRowCount() {
        return numOfRows;
    }

    public int GetColumnCount() {
        return numOfColumns;
    }

    @Override
    public String toString() {
        String result = new String();
        for (var row = 0; row < numOfRows; row++) {
            String tmpString = String.format("%d: ", row);
            for (var col = 0; col < numOfColumns; col++)
            {
                if (col < (numOfColumns - 1)) {
                    var valStr = String.format("%.1f, ", this.data[row][col]);
                    tmpString = tmpString.concat(valStr);
                }
                else {
                    var valStr = String.format("%.1f\n", this.data[row][col]);
                    tmpString = tmpString.concat(valStr);
                }
            }
            result =  result.concat(tmpString);
        }
        return result;
    }

    public double determinant() {
        return matrixDeterminant(data);
    }

    public static double matrixDeterminant (double[][] matrix) {
        double temporary[][];
        double result = 0;

        if (matrix.length == 1) {
            result = matrix[0][0];
            return (result);
        }

        if (matrix.length == 2) {
            result = ((matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]));
            return (result);
        }

        for (int i = 0; i < matrix[0].length; i++) {
            temporary = new double[matrix.length - 1][matrix[0].length - 1];

            for (int j = 1; j < matrix.length; j++) {
                for (int k = 0; k < matrix[0].length; k++) {
                    if (k < i) {
                        temporary[j - 1][k] = matrix[j][k];
                    } else if (k > i) {
                        temporary[j - 1][k - 1] = matrix[j][k];
                    }
                }
            }

            result += matrix[0][i] * Math.pow (-1, (double) i) * matrixDeterminant (temporary);
        }
        return (result);
    }

}

