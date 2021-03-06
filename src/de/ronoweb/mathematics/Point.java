package de.ronoweb.mathematics;

public class Point {
    private final double x;
    private final double y;
    private final double z;

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }

        if (obj == null){
            return false;
        }

        Point o = (Point)obj;
        return (x == o.x && y == o.y && z == o.z);
    }

    @Override
    public String toString() {
        return String.format("x=%.2f y=%.2f z=%.2f", this.x, this.y, this.z);
    }

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double GetX() {
        return this.x;
    }

    public double GetY() {
        return this.y;
    }

    public double GetZ() {
        return this.z;
    }
}
