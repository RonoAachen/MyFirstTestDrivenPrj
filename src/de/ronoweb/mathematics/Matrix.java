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

    public double[] getRowData(int row) {
        double[] result = new double[this.numOfColumns];
        for (var col=0; col<this.numOfColumns; col++){
            result[col] = this.data[row][col];
        }
        return result;
    }

    public void setRowData(double[] rowData, int row) {
        for (var col=0; col<this.numOfColumns; col++){
            this.data[row][col] = rowData[col];
        }
    }


    public double determinant() {
        return matrixDeterminantRecursively(data);
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

    public double Test() {
       // return shortMatrixDeterminant( new double[][] { {6, 5}, {9, 8} });

        for (var i=0; i < 3; i++) {
            for ( var j=0; j<3; j++) {
                System.out.printf("%d, %d: %f\n",i, j, signFactor(i, j));
            }
        }

        return signFactor(this.data, 2, 0);
    }

    public Matrix triangleWithGauss() {
        if (this.numOfRows < this.numOfColumns) {
            System.out.println("There is no unique solution for these equations!");
            return null;
        }

        Matrix result = new Matrix(this.data);

        for (var col=0; col<this.numOfColumns - 1; col++) {
            for (var row= col + 1; row<this.numOfRows; row++) {
                if (this.data[row][col] != 0) {
                    var factor = (this.data[col][col] / this.data[row][col]) * -1.0;
                    var tmpRow = product(this.getRowData(row), factor);
                    result.setRowData(add(this.getRowData(col), tmpRow), row);
                }
                else {
                    result.setRowData(this.getRowData(row), row);
                }
            }
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

