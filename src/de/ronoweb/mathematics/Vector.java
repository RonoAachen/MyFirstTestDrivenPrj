package de.ronoweb.mathematics;

public class Vector {
    private double[] data;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        Vector o = (Vector)obj;
        boolean result = true;
        for (var i=0; i<this.data.length; i++) {
            if (this.data[i] != o.getValue(i)) {
                result = false;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        // ToDo: build string here
        return super.toString();
    }

    public Vector(int numberOfElements) {
        data = new double[numberOfElements];
    }

    public Vector(double[] data) {
        this.data = data;
    }

    public int getLength() { return this.data.length; }
    public double[] toArray() { return this.data; }
    public double getValue(int position) { return this.data[position]; }
    public void setValue(double value, int position) {
        this.data[position] = value;
    }

    public Vector Product(double scalar) {
        double[] result = new double[this.data.length];
        result[0] = this.data[0] * scalar;
        result[1] = this.data[1] * scalar;
        result[2] = this.data[2] * scalar;

        return new Vector(result);
    }
}
