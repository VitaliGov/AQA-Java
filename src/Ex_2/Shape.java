package Ex_2;

public abstract class Shape {
    private String fillColor;
    private String borderColor;

    public Shape(String fillColor, String borderColor) {
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public abstract double getPerimeter();

    public abstract double getArea();

    public String getFillColor() {
        return fillColor;
    }

    public String getBorderColor() {
        return borderColor;
    }
}
