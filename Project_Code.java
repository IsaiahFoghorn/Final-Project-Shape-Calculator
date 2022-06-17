import java.util.*;
import java.lang.*;

class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in); // String scanner
    Scanner inp = new Scanner(System.in); // Number scanner

    // An array list or multi-dimensional array could be used here to simplify this into a list of choices
    String[] shapes = {"Rectangle", "Triangle", "Circle", "Polygon"};

    int placeholder;
    int shapeType;
    GeometricObject o;

    do {
      System.out.print("Which shape would you like to use? \n1) Rectangle \n2) Triangle \n3) Circle \n4) Regular Polygon \n");

      shapeType = (int)(getValue(""));
      
      switch (shapeType) {
        case 1:
          System.out.printf("\n%s\n", shapes[shapeType - 1]);
          
          o = new Rectangle();
          ((Rectangle)o).setLength(getValue("  Length"));
          ((Rectangle)o).setWidth(getValue("  Width"));
          break;
        case 2:
          System.out.printf("\n%s\n", shapes[shapeType - 1]);
          
          o = new Triangle();
          ((Triangle)o).setSideA(getValue("  Side A"));
          ((Triangle)o).setSideB(getValue("  Side B"));
          ((Triangle)o).setSideC(getValue("  Side C"));
          break;
        case 3:
          System.out.printf("\n%s\n", shapes[shapeType - 1]);
          
          o = new Circle();
          ((Circle)o).setRadius(getValue("  Radius"));
          break;
        case 4:
          System.out.printf("\n%s\n", shapes[shapeType - 1]);
          
          o = new RegPolygon(getValue("  Number of Sides"));

          System.out.print("\nWhich part of the polygon should be used to calculate? \n1) Apothem \n2) Radius \n3) Side Length \n");
          placeholder = (int)(getValue(""));

          switch (placeholder) {
            case 1:
              ((RegPolygon)o).setApothem(getValue("\nApothem"));
              break;
            case 2:
              ((RegPolygon)o).setRadius(getValue("\nRadius"));
              break;
            case 3:
              ((RegPolygon)o).setSideLength(getValue("\nSide Length"));
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
      }
      catch (InputMismatchException ex) {
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

// toString methods will need to be included. Consider .instanceof in order to allow GeometricObject the ability to differentiate between flat shapes and solids.

class GeometricObject {
  public GeometricObject() {

  }

  // This will eventually have a purpose
}

abstract class FlatShape extends GeometricObject {
  protected FlatShape() {

  }

  public abstract double getPerimeter();

  public abstract double getArea();
}

class Rectangle extends FlatShape {
  private double width;
  private double length;

  public Rectangle() {

  }

  public Rectangle(double length, double width) {
    this.length = length;
    this.width = width;
  }

  public void setLength(double newLength) {
    this.length = newLength;
  }

  public double getLength() {
    return length;
  }

  public void setWidth(double newWidth) {
    this.width = newWidth;
  }

  public double getWidth() {
    return width;
  }

  public double getPerimeter() {
    return 2 * (length + width);
  }

  public double getArea() {
    return length * width;
  }

  @Override

  public String toString() {
    return ("Rectangle: \n  Length = " + length + "\n  Width = " + width + "\n\n  Perimeter = " + getPerimeter() + "\n  Area = " + getArea());
  }
}

// Improving this class would require Calculus level geometry, so don't try it until later

class Triangle extends FlatShape {
  private double sideA, sideB, sideC;

  public Triangle() {

  }

  public Triangle(double sideA, double sideB, double sideC) {
    this.sideA = sideA;
    this.sideB = sideB;
    this.sideC = sideC;
  }

  public void setSideA(double newSideLength) {
    this.sideA = newSideLength;
  }

  public double getSideA() {
    return sideA;
  }

  public void setSideB(double newSideLength) {
    this.sideB = newSideLength;
  }

  public double getSideB() {
    return sideB;
  }

  public void setSideC(double newSideLength) {
    this.sideC = newSideLength;
  }

  public double getSideC() {
    return sideC;
  }

  public double getPerimeter() {
    return sideA + sideB + sideC;
  }

  public double getArea() {
    double s = (sideA + sideB + sideC) / 2;
    return (Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC)));
  }

  @Override

  public String toString() {
    return ("Triangle: \n  Side A = " + sideA + "\n  Side B = " + sideB + "\n  Side C = " + sideC + "\n\n  Perimeter = " + getPerimeter() + "\n  Area = " + getArea());
  }
}

class Circle extends FlatShape {
  private double radius;

  public Circle() {

  }

  public Circle(double radius) {
    this.radius = radius;
  }

  public void setRadius(double newRadius) {
    this.radius = newRadius;
  }

  public double getRadius() {
    return radius;
  }

  public double getPerimeter() {
    return 2 * (Math.PI * radius);
  }

  public double getArea() {
    return (Math.PI * Math.pow(radius, 2));
  }

  @Override

  public String toString() {
    return ("Circle: \n  Radius = " + radius + "\n\n  Circumference = " + getPerimeter() + "\n  Area = " + getArea());
  }
}

class RegPolygon extends FlatShape {
  private double apothem;
  private double radius;
  private double sideLength = 1;
  private double numOfSides = 5;
  private double angleX; // This angle is used to calculate apothem, radius, and side lengths

  public RegPolygon() {

  }

  public RegPolygon(double numOfSides) {
    this.numOfSides = numOfSides;
  }

  // This constructor definitely needs to be replaced later on
  
  public RegPolygon(double numOfSides, double value, int selector) {
    this.numOfSides = numOfSides;
    this.angleX = Math.toRadians((180 - (360 / numOfSides)) / 2);

    // Possible bugs below if program lacks valid values

    switch (selector) {
      case 1:
        this.apothem = value;
        calculateRadius();
        calculateSideLength();
      case 2:
        this.radius = value;
        calculateSideLength();
        calculateApothem();
      case 3:
        this.sideLength = value;
        calculateApothem();
        calculateRadius();
    }
  }

  // Consider a broader setValue() method
  
  public void setApothem(double value) {
    this.apothem = value;
    calculateRadius();
    calculateSideLength();
  }

  // Consider making calculate functions private

  private void calculateApothem() {
    this.apothem = Math.tan(angleX) * (sideLength / 2);
  }

  public double getApothem() {
    return apothem;
  }

  public void setRadius(double value) {
    this.radius = value;
    calculateSideLength();
    calculateApothem();
  }

  private void calculateRadius() {
    this.radius = apothem / Math.sin(angleX);
  }

  public double getRadius() {
    return radius;
  }

  public void setSideLength(double value) {
    this.sideLength = value;
    calculateApothem();
    calculateRadius();
  }

  private void calculateSideLength() {
    this.sideLength = (Math.cos(angleX) * radius) * 2;
  }

  public double getSideLength() {
    return sideLength;
  }

  public double getPerimeter() {

    return numOfSides * sideLength;
  }

  public double getArea() {

    return (apothem * getPerimeter()) / 2;
  }

  public String toString() {
    return ("Regular Polygon: \n  Apothem = " + apothem + "\n  Radius = " + radius + "\n  Side Length = " + sideLength + "\n\n  Perimeter = " + getPerimeter() + "\n  Area = " + getArea());
  }
}

abstract class SolidShape extends GeometricObject {
  protected SolidShape() {

  }

  public abstract double getBaseArea();

  public abstract double getVolume();
}
