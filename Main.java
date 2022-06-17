import java.util.*;
import java.lang.*;

class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in); // String scanner
    Scanner inp = new Scanner(System.in); // Number scanner

    // An array list or multi-dimensional array could be used here to simplify this
    // into a list of choices
    String[] shapes = { "Rectangle", "Triangle", "Circle", "Polygon" };

    int placeholder;
    int shapeType;
    GeometricObject o;

    do {
      System.out
          .print("Which shape would you like to use? \n1) Rectangle \n2) Triangle \n3) Circle \n4) Regular Polygon \n");

      shapeType = (int) (getValue(""));

      switch (shapeType) {
        case 1:
          System.out.printf("\n%s\n", shapes[shapeType - 1]);

          o = new Rectangle();
          ((Rectangle) o).setLength(getValue("  Length"));
          ((Rectangle) o).setWidth(getValue("  Width"));
          break;
        case 2:
          System.out.printf("\n%s\n", shapes[shapeType - 1]);

          o = new Triangle();
          ((Triangle) o).setSideA(getValue("  Side A"));
          ((Triangle) o).setSideB(getValue("  Side B"));
          ((Triangle) o).setSideC(getValue("  Side C"));
          break;
        case 3:
          System.out.printf("\n%s\n", shapes[shapeType - 1]);

          o = new Circle();
          ((Circle) o).setRadius(getValue("  Radius"));
          break;
        case 4:
          System.out.printf("\n%s\n", shapes[shapeType - 1]);

          o = new RegPolygon(getValue("  Number of Sides"));

          System.out.print(
              "\nWhich part of the polygon should be used to calculate? \n1) Apothem \n2) Radius \n3) Side Length \n");
          placeholder = (int) (getValue(""));

          switch (placeholder) {
            case 1:
              ((RegPolygon) o).setApothem(getValue("\nApothem"));
              break;
            case 2:
              ((RegPolygon) o).setRadius(getValue("\nRadius"));
              break;
            case 3:
              ((RegPolygon) o).setSideLength(getValue("\nSide Length"));
              break;
            default:
              System.out.println("\nInvalid Input\n");
              continue;
            }
          default:
            System.out.println("\nInvalid Input\n");
            continue;
      }

      System.out.println("" + o.toString() + "\n");
    } while (true);
  }

  public static double getValue(String valueType) {
    Scanner inp = new Scanner(System.in);
    double x;

    do {
      System.out.printf("%s: ", valueType);

      try {
        x = inp.nextDouble();
      } catch (InputMismatchException ex) {
        System.out.println("\nInvalid Input\n");
        inp.next();
        continue;
      }

      if (x <= 0) {
        System.out.println("\nInvalid Input\n");
        continue;
      } else {
        break;
      }
    } while (true);

    return x;
  }
}