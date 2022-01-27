/*
    1. Create a class Shape having atmost two dimensions. Define two subclasses circle and rectangle of Shape.

    i) Override a method calculateArea.

    ii) Show compile time and run time polymorphism(Dynamic method dispatch).

    iii) Use a final method for toString.

    iv) use super keyword.
*/

abstract class Shape
{
    // @SupressWarnings("unused")
    private static double m_length;
    private static double m_breadth;

    /*
    //  @brief: Need The Default Constructor
    //          or else the compiler will give error
    //          because the explicit consturctor gets called automatically
    */
    public Shape(){}

    public Shape(double length, double breadth)
    {
        m_length = length;
        m_breadth = breadth;
    }

/*
    // @brief: Does Nothing need to extend this class
    //         then define the method in the subclass
*/
    abstract double calculateArea();

/*
    // @brief: Does Nothing need to extend this class
    //         then define the method in the subclass
*/
    public String toString()
    {
        return "This is a Shape";
    }

    abstract double calculatePerimeter();
}


final class Circle extends Shape
{
    private float m_radius;
    private static final float PI = 3.14f;

    final double calculateDiameter()
    {
        return 2 * m_radius;
    }

    // Uses an explicit counstructor
    public Circle(float radius)
    {
        m_radius = radius;
    }

    @Override
    double calculateArea()
    {
        return PI * m_radius * m_radius;
    }

    @Override
    final public double calculatePerimeter()
    {
        return 2 * PI * m_radius;
    }

    @Override
    final public String toString()
    {
        return "Shape = Circle\t" + "Radius = " + m_radius + "\tDiameter = " + calculateDiameter() + "\tCircumference:" + calculatePerimeter() +  "\tArea = " + calculateArea();
    }
}

final class Rectangle extends Shape
{
    private float m_length;
    private float m_breadth;

    // Uses an explicit counstructor
    public Rectangle(float length, float breadth)
    {
        super(length, breadth); // Does not have any effect done for the sake of doing it in the subclass
        m_length = length;
        m_breadth = breadth;
    }

    @Override
    final double calculateArea()
    {
        return m_length * m_breadth;
    }

    @Override
    final double calculatePerimeter()
    {
        return 2 * (m_length + m_breadth);
    }

    @Override
    final public String toString()
    {
        return "Shape = Rectangle\t" + "Length = " + m_length + "\tBreadth = " + m_breadth + "\tPerimeter = " + calculatePerimeter() + "\tArea = " + calculateArea();
    }

}

public class assignment
{
    public static void main(String[] args)
    {
        /*
        // @brief: cannot create an instance of Shape
        // Reason: Shape is an abstract class

        Shape shape_S = new Shape(5f, 6.69f);
        System.out.println(shape_S.toString());
        */

        Circle circleObject = new Circle(3.473f);
        Shape shapeObject = new Circle(15.00006453f);  // Polymorphism!!!!

        Rectangle rectangleObject = new Rectangle(5.5f, 6.5f);
        Shape shapeObject2 = new Rectangle(2.775439007f, 7.009845f);  // Polymorphism!!!!

        System.out.println(circleObject.toString() + "\n");
        System.out.println(shapeObject.toString() + "\n");

        System.out.println(rectangleObject.toString()+ "\n");
        System.out.println(shapeObject2.toString() + "\n");
    }
}