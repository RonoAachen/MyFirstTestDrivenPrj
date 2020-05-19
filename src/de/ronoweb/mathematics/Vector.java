package de.ronoweb.mathematics;

public class Vector {
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

        Vector o = (Vector)obj;
        return (x == o.x && y == o.y && z == o.z);
    }

    @Override
    public String toString() {
        return x + "\t" + y + "\t" + z;
    }

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector(Point p1, Point p2) {
        this.x = p2.GetX() - p1.GetX();
        this.y = p2.GetY() - p1.GetY();
        this.z = p2.GetZ() - p1.GetZ();
    }

    public double GetX(){
        return this.x;
    }

    public double GetY(){
        return this.y;
    }

    public double GetZ(){
        return this.z;
    }

    public double magnitude(){
        return Math.sqrt((x * x) + (y * y) + (z * z));
    }

    public Vector add(Vector vector){
        if (vector == null)
        {
            return this;
        }
        return new Vector(x + vector.x, y + vector.y, z + vector.z);
    }

    public Vector sub(Vector vector){
        if (vector == null)
        {
            return this;
        }
        return new Vector(x - vector.x, y - vector.y, z - vector.z);
    }

    public Vector product(double number){
        return new Vector(x * number, y * number, z * number);
    }

    public double dotProduct(Vector v){
        return x * v.x + y * v.y + z * v.z;
    }

    public double cosAlpha(Vector v){
        return this.dotProduct(v) / (this.magnitude() * v.magnitude());
    }

    public boolean isLinearDependent(Vector v) {
        double fx = x * v.x;
        double fy = y * v.y;
        double fz = z * v.z;
        return (fx == fy) && (fx == fz);
    }
}
