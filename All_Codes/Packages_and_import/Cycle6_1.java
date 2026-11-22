class Circle {
    final double PI = 3.14159;
    final double radius;
    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return PI * radius * radius;
    }
}

public class Cycle6_1 {
    public static void main(String[] args) {
        Circle myCircle = new Circle(5.0);
        System.out.println("Area of circle: " + myCircle.calculateArea());
    }
}
