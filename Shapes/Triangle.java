package Shapes;

import static java.lang.Math.sqrt;

public class Triangle implements Shape{
    protected double a;
    protected double b;
    protected double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getPerimeter() {
        return a+b+c;
    }

    @Override
    public double getArea() {
        double p = (a+b+c)/2.0;
        return sqrt(p*(p-a)*(p-b)*(p-c));
    }

    @Override
    public String toString() {
        return "Triangle info {" +
                "a = " + a +
                ", b = " + b +
                ", c = " + c +
                ", perimeter = " + getPerimeter()+
                ", area = " + getArea()+
                '}';
    }
}
