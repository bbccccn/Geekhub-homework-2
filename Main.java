import Shapes.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static Shapes.ShapeNames.*;
import static java.lang.Double.parseDouble;


public class Main {

    public static void main(String[] args) throws IOException {
        Shape shape = getShape();
        System.out.print(shape.toString());
    }

    private static Shape getShape() throws IOException {
        ShapeNames shapeName = ShapeNames.valueOf(getShapeName());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        switch (shapeName) {
            case CIRCLE: {
                return getCircle(bufferedReader);
            }
            case SQUARE: {
                return getSquare(bufferedReader);
            }
            case RECTANGLE: {
                return getRectangle(bufferedReader);
            }
            case TRIANGLE: {
                return getTriangle(bufferedReader);
            }
        }

        return null;
    }

    private static String getValidValue(BufferedReader bufferedReader) throws IOException {
        String value = bufferedReader.readLine();
        while (!isValidValue(value)) {
            System.out.println("Your value is not bigger that zero! Please, rewrite value:");
            value = bufferedReader.readLine();
        }
        return value;
    }

    private static boolean isValidValue(String value) {
        return parseDouble(value) > 0;
    }

    private static Shape getTriangle(BufferedReader bufferedReader) throws IOException {
        System.out.println("Enter side A of your rectangle! Must be bigger than 0 by the way.");
        String sideA = getValidValue(bufferedReader);
        System.out.println("Enter side B of your rectangle! Rule the same -- value bigger that zero.");
        String sideB = getValidValue(bufferedReader);
        System.out.println("Enter side C of your rectangle! Again -- value bigger that zero.");
        String sideC = getValidValue(bufferedReader);
        return new Triangle(parseDouble(sideA), parseDouble(sideB), parseDouble(sideC));

    }

    private static Shape getRectangle(BufferedReader bufferedReader) throws IOException {
        System.out.println("Enter side A of your rectangle! Must be bigger than 0 by the way.");
        String sideA = getValidValue(bufferedReader);
        System.out.println("Enter side B of your rectangle! Rule the same -- value bigger that zero.");
        String sideB = getValidValue(bufferedReader);
        return new Rectangle(parseDouble(sideA), parseDouble(sideB));
    }

    private static Shape getSquare(BufferedReader bufferedReader) throws IOException {
        System.out.println("Enter length of your square! Must be bigger than 0 by the way.");
        String value = getValidValue(bufferedReader);
        return new Square(parseDouble(value));
    }

    private static Shape getCircle(BufferedReader bufferedReader) throws IOException {
        System.out.println("Enter radius of your circle! Must be bigger than 0 by the way.");
        String value = getValidValue(bufferedReader);
        return new Circle(parseDouble(value));
    }

    private static String getShapeName() {
        String shapeName = "";

        System.out.print("Hi there, user! Enter shape which you want to create: Circle, Square, Rectangle, Triangle :");
        do {
            try {
                shapeName = getShapeNameFromInput();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (!isShapeNameValid(shapeName));

        return shapeName.toUpperCase();
    }

    private static boolean isShapeNameValid(String input) {
        if (isNameExists(input.toUpperCase())) return true;
        else {
            System.out.println("Can't recognise shape name, please write your shape name again");
            return false;
        }
    }

    private static boolean isNameExists(String name) {
        return name.equals(CIRCLE.toString())
                || name.equals(SQUARE.toString())
                || name.equals(RECTANGLE.toString())
                || name.equals(TRIANGLE.toString());
    }

    private static String getShapeNameFromInput() throws IOException {
        return new BufferedReader(new InputStreamReader(System.in)).readLine();
    }
}
