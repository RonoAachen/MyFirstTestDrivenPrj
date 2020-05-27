package de.ronoweb.mathematics;

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

    public double getValue(int row, int column) {
        return data[row][column];
    }

    public void setValue(int row, int column, double value) {
        data[row][column] = value;
    }

    public int getRowCount() {
        return numOfRows;
    }

    public int getColumnCount() {
        return numOfColumns;
    }

    public double[][] toArray() {
        return this.data;
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


    public double[] solveGauss(double[] r) {
        var result = new double[r.length];
        var m = triangleWithGauss(this.data, r);

        // print out for test
        // ------------------
        for(int i=0; i<r.length; i++) {
            System.out.printf("%d: ", i);
            for (int j=0; j<r.length + 1; j++) {
                System.out.printf("%.2f\t", m[i][j]);
            }
            System.out.println();
        }

        result[r.length - 1] = r[r.length - 1] / m[r.length - 1][r.length - 1];
        for (int i = r.length - 2; i>=0; i--) {
            double tmp = 0.0;
            for (int j = i + 1; j<r.length; j++) {
                tmp += m[i][j] * result[j];
            }
            result[i] = (r[i] - tmp) / m[i][i];
        }

        return result;
    }


    public double determinantLaplace() {
        return matrixDeterminantRecursively(data);
    }
    public double determinantGauss() {
        var matrix = triangleWithGauss(this.data);
        double result = 1.0;
        for (var i=0; i<this.numOfRows; i++) {
            result *= this.data[i][i];
        }
        return result;
    }

    // Matrix Determinante mit Hilfe des
    // Laplace-Entwicklungssatzes
    private static double matrixDeterminantRecursively(double[][] matrix) {
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

            result += matrix[0][i] * Math.pow (-1, (double) i) * matrixDeterminantRecursively(temporary);
        }
        return (result);
    }

    private double[][] triangleWithGauss(double[][] matrix) {
        if (matrix.length < matrix[0].length) {
            System.out.println("There is no unique solution for these equations!");
            return null;
        }

        var result = matrix;
        for (var col=0; col<this.numOfColumns - 1; col++) {
            for (var row= col + 1; row<this.numOfRows; row++) {
                if (this.data[row][col] != 0) {
                    var factor = (this.data[col][col] / this.data[row][col]) * -1.0;
                    var tmpRow = product(getDataRow(result, row), factor);
                    var newRow = add(getDataRow(result,col), tmpRow);
                    result = setDataRow(result, newRow, row);
                }
            }
        }

        return result;
    }

    private double[][] triangleWithGauss(double[][] matrix, double[] vector) {
        if (matrix.length < matrix[0].length) {
            System.out.println("There is no unique solution for these equations!");
            return null;
        }

        var m = matrix;
        var v = vector;
        for (var col=0; col<this.numOfColumns - 1; col++) {
            for (var row= col + 1; row<this.numOfRows; row++) {
                if (this.data[row][col] != 0) {
                    var factor = (this.data[col][col] / this.data[row][col]) * -1.0;
                    var tmpRow = product(getDataRow(m, row), factor);
                    var newRow = add(getDataRow(m,col), tmpRow);
                    m = setDataRow(m, newRow, row);

                    v[row] = v[col] + (v[row] * factor);
                }
            }
        }

        double[][] result = new double[m.length][m.length + 1];
        for(var row=0; row<m.length; row++) {
            for(var col=0; col<m[0].length; col++) {
                result[row][col] = m[row][col];
            }
            result[row][result[0].length-1] = v[row];
        }

        return result;
    }

    private double[] getDataRow(double[][] matrix, int row) {
        double[] result = new double[matrix[0].length];
        for (var col=0; col<result.length; col++){
            result[col] = matrix[row][col];
        }
        return result;
    }

    private double[][] setDataRow(double[][] matrix, double[] rowData, int row) {
        var result = matrix;
        for (var col=0; col<rowData.length; col++){
            result[row][col] = rowData[col];
        }
        return result;
    }

    private static double[] add(double[] data1, double[] data2) {
        double[] result = new double[data1.length];
        for (var i=0; i<data1.length; i++) {
            result[i] = data1[i] + data2[i];
        }
        return result;
    }

    private static double[] product(double[] data, double value) {
        var result = new double[data.length];
        for (var i=0; i<data.length; i++) {
            result[i] = data[i] * value;
        }

        return result;
    }
    
    private static double shortMatrixDeterminant(double[][] m) {
        return (m[0][0] * m[1][1]) - (m[1][0] * m[0][1]);
    }

    private static double signFactor(int row, int col) {
        return Math.pow(-1, (row + col));
    }

    private static double signFactor(double[][] m, int row, int col) {
        int rowCount = m.length;
        int colCount = m[0].length;
        double tmp = (row * colCount) + col;

        if (tmp % 2 == 0) {
            return 1.0;
        }

        return -1.0;
    }

}

