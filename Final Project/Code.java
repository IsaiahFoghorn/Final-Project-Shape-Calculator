import java.util.*;
import java.lang.*;

class Main {
  public static void main(String[] args) {
    TwoDimensionalShape rec = new EquilateralPolygon(9, 2, 3);
    System.out.println(((EquilateralPolygon)rec).getSideLength());
    
  }
}

class GeometricObject {
  public GeometricObject() {
    
  }
}

// You can rename this class FlatShape

abstract class TwoDimensionalShape extends GeometricObject {
  protected TwoDimensionalShape() {
    
  }

  public abstract double getPerimeter();
  public abstract double getArea();
}

class Rectangle extends TwoDimensionalShape {
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
}

// Improving this class would require Calculus level geometry, so don't try it until later

class Triangle {
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
}

class Circle {
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
}

// Consider improving the constructors for the class below

class EquilateralPolygon extends TwoDimensionalShape {
  private double apothem;
  private double radius;
  private double sideLength = 2;
  private double numOfSides = 9;

  private double angleX; // This angle is used to calculate apothem, radius, and side lengths

  public EquilateralPolygon() {
    
  }

  public EquilateralPolygon(double numOfSides, double value, int selector) {
    this.numOfSides = numOfSides;
    this.angleX = Math.toRadians((180 - (360 / numOfSides)) / 2);

    // Possible bugs below if program lacks valid values
    
    switch(selector) {
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

  public void setApothem(double value) {
    this.apothem = value;
    calculateRadius();
    calculateSideLength();
  }

  // Consider making calculate functions private
  
  public void calculateApothem() {
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
  
  public void calculateRadius() {
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
  
  public void calculateSideLength() {
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
}

// This class could be renamed to SolidShape

abstract class ThreeDimensionalShape extends GeometricObject {
  protected ThreeDimensionalShape() {
    
  }

  public abstract double getBaseArea();
  public abstract double getVolume();
}
