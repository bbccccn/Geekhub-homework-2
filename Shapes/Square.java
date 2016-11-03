package Shapes;

import static java.lang.Math.sqrt;

public class Square implements Shape{
    protected double a;

    public Square(double a) {
        this.a = a;
    }

    @Override
    public double getPerimeter() {
        return a*4;
    }

    @Override
    public double getArea() {
        return a*a;
    }

    public Triangle getTriangle(){
        return new Triangle(a,a,sqrt(getArea()*2));
    }

    @Override
    public String toString() {
        return "Square info {" +
                "a = " + a +
                ", area = "+ getArea() +
                ", perimeter = "+ getPerimeter() +
                ", triangle info : " + getTriangle().toString() +
                '}';
    }
}
