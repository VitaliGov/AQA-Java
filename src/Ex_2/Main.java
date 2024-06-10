package Ex_2;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(5.0, "Red", "Black");
        Shape rectangle = new Rectangle(4.0, 6.0, "Blue", "Green");
        Shape triangle = new Triangle(3.0, 4.0, 5.0, "Yellow", "Purple");

        printShapeDetails(circle);
        printShapeDetails(rectangle);
        printShapeDetails(triangle);
    }

    public static void printShapeDetails(Shape shape) {
        System.out.println("Perimeter: " + shape.getPerimeter());
        System.out.println("Area: " + shape.getArea());
        System.out.println("Fill Color: " + shape.getFillColor());
        System.out.println("Border Color: " + shape.getBorderColor());
        System.out.println();
    }
}

