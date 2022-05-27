# Java-Shape-Calculator
This program was created as a way of calculating certain values of a shape using others given by a user. Eventually it will expand to include solids and trigometry, but, as of yet, this program can only work with flat shapes. 
By putting in a shape's side lengths (other inputs will be made possible later), it is possible to calculate the area and perimeter of basic 2D shapes.

## Project Goals
The goal of this project is to draw together and simplify geometric equations in a way that is easier to understand and thus more usable. Details of such equations will soon be provided in order to simplify equations and relate them to other shapes.

### Current Planned Additions
1. Basic equations for flat shapes.
2. Solid shape classes and their methods.
3. Updated user interface to include new solid shapes.

### Project Completion
- [x] 2D shape classes
- [x] Working user interface
- [ ] Basic 3D shape classes
- [ ] Polished user interface
- [ ] Linking of shape classes for cohesion
- [ ] Revision of shape classes
- [ ] Basic trigonometry implemented through Triangle class
- [ ] Interface update to support trigonometry
- [ ] More advanced trigonometry
- [ ] Complex shapes (i.e. ellipses, hedrons, and other advanced shapes)
- [ ] Matching interface update
- [ ] Custom shapes
- [ ] Major interface update

## Examples

The following code applies to the Rectangle class and is used to calculate area and perimeter given a rectangle's length and width. If the user wanted to create a rectangle with a length of three and a width of two, that rectangle's area would be six and it's perimeter twelve.

```
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
```

More examples coming soon.
