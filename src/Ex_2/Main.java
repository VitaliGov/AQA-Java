package Ex_2;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(5.0, "Red", "Black");
        Shape rectangle = new Rectangle(4.0, 6.0, "Blue", "Green");
        Shape triangle = new Triangle(3.0, 4.0, 5.0, "Yellow", "Purple");

        circle.printShapeDetails();
        rectangle.printShapeDetails();
        triangle.printShapeDetails();
    }
}