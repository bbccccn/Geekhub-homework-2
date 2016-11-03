package Shapes;

import static java.lang.Math.sqrt;

public class Rectangle extends Square {
    protected double b;

    public Rectangle(double a, double b) {
        super(a);
        this.b = b;
    }

    @Override
    public double getPerimeter() {
        return a*2 + b*2;
    }

    @Override
    public double getArea() {
        return a*b;
    }

    public Triangle getTriangle(){
        return new Triangle(a,b,sqrt(getArea()*2));
    }


    @Override
    public String toString() {
        return "Rectangle info {" +
                "a = " + a +
                "b = " + b +
                ", area = "+ getArea() +
                ", perimeter = "+ getPerimeter() +
                ", triangle info : " + getTriangle().toString() +
                '}';
    }
}
