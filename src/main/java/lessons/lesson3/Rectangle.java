package lessons.lesson3;

import lombok.Data;
@Data
public class Rectangle {

    private double width;
    private double length;

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }
    public double calculateSquare() {
        return width * length;
    }
    public double calculatePerimeter() {
        return 2 * (width + length);
    }
}

