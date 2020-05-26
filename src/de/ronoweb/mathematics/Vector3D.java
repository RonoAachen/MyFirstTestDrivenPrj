package de.ronoweb.mathematics;

public class Vector3D {
    private final double x;
    private final double y;
    private final double z;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        Vector3D o = (Vector3D)obj;
        return (x == o.x && y == o.y && z == o.z);
    }

    @Override
    public String toString() {
        return String.format("x=%.2f y=%.2f z=%.2f",this.x, this.y, this.z);
    }

    // create a vector on 3 direction parameters
    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3D(double[] data) {
        this.x = data[0];
        this.y = data[1];
        this.z = data[2];
    }

    // create a vector between 2 different points
    public Vector3D(Point p1, Point p2) {
        this.x = p2.GetX() - p1.GetX();
        this.y = p2.GetY() - p1.GetY();
        this.z = p2.GetZ() - p1.GetZ();
    }

    public double getX(){
        return this.x;
    }
    public double getY(){
        return this.y;
    }
    public double getZ(){
        return this.z;
    }
    public double[] getData() {
        return new double[] {this.x, this.y, this.z };
    }


    public double magnitude(){
        return Math.sqrt((x * x) + (y * y) + (z * z));
    }

    public Vector3D add(Vector3D vector3D){
        if (vector3D == null)
        {
            return this;
        }
        return new Vector3D(x + vector3D.x, y + vector3D.y, z + vector3D.z);
    }

    public Vector3D sub(Vector3D vector3D){
        if (vector3D == null)
        {
            return this;
        }
        return new Vector3D(x - vector3D.x, y - vector3D.y, z - vector3D.z);
    }

    public Vector3D product(double number){
        return new Vector3D(x * number, y * number, z * number);
    }

    public double dotProduct(Vector3D v){
        return x * v.x + y * v.y + z * v.z;
    }

    public double cosAlpha(Vector3D v){
        return this.dotProduct(v) / (this.magnitude() * v.magnitude());
    }

    public boolean isLinearDependent(Vector3D v) {
        double fx = x * v.x;
        double fy = y * v.y;
        double fz = z * v.z;
        return (fx == fy) && (fx == fz);
    }

    public Vector3D crossProduct(Vector3D v) {
        double i = this.y * v.z - this.z * v.y;
        double j = this.z * v.x - this.x * v.z;
        double k = this.x * v.y - this.y * v.x;
        return new Vector3D(i, j, k);
    }
}
