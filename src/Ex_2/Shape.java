package Ex_2;

public interface Shape {
    double getPerimeter();

    double getArea();

    String getFillColor();

    String getBorderColor();

    default void printShapeDetails() {
        System.out.println("Perimeter: " + getPerimeter());
        System.out.println("Area: " + getArea());
        System.out.println("Fill Color: " + getFillColor());
        System.out.println("Border Color: " + getBorderColor());
        System.out.println();
    }
}