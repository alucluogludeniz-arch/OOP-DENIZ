public class Triangle extends Shape {
    private Coordinates vertex1;
    private Coordinates vertex2;
    private Coordinates vertex3;

    public Triangle(Coordinates v1, Coordinates v2, Coordinates v3) {
        super(3, v1);
        this.vertex1 = v1;
        this.vertex2 = v2;
        this.vertex3 = v3;
    }

    @Override
    public double getPerimeter() {
        double a = vertex1.distance(vertex2);
        double b = vertex2.distance(vertex3);
        double c = vertex3.distance(vertex1);
        return a + b + c;
    }

    @Override
    public double getArea() {
        double a = vertex1.distance(vertex2);
        double b = vertex2.distance(vertex3);
        double c = vertex3.distance(vertex1);
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public void translate(int dx, int dy) {
        vertex1.translate(dx, dy);
        vertex2.translate(dx, dy);
        vertex3.translate(dx, dy);
    }

    @Override
    public void scale(int factor, boolean sign) {
        vertex1.scale(factor, sign);
        vertex2.scale(factor, sign);
        vertex3.scale(factor, sign);
    }

    @Override
    public String display() {
        return "Triangle with vertices: (" + vertex1.display() + "), (" +
                vertex2.display() + "), (" + vertex3.display() + ")" +
                ", Area = " + getArea() + ", Perimeter = " + getPerimeter();
    }
}
