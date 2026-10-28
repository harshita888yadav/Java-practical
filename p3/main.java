
class Shape {
    double area() {
        return 0;
    }

    // Method overloading
    int area(int side) {
        return side * side;
    }

    int area(int length, int breadth) {
        return length * breadth;
    }
}

class Circle extends Shape {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private double length, breadth;

    Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    double area() {
        return length * breadth;
    }
}

public class PolymorphismDemo {
    public static void main(String[] args) {
        Shape s = new Shape();

        System.out.println("Square: " + s.area(4));
        System.out.println("Rectangle: " + s.area(4, 5));

        // Parent references, child objects
        Shape a = new Circle(3);
        Shape b = new Rectangle(4, 5);

        System.out.printf("Circle area: %.2f%n", a.area());
        System.out.println("Rectangle area: " + b.area());
    }
}

