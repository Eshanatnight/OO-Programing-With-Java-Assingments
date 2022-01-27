abstract class Figure
{
    // Constants -------------------------
    static final double PI = 3.14159265358979323846;

    public double totalSurfaceArea()
    {
        return 0;
    }

    public double volume()
    {
        return 0;
    }

    public void getData()
    {
        System.out.println("Total Surface Area: " + totalSurfaceArea());
        System.out.println("Volume:             " + volume());
    }
}

class Sphere extends Figure
{

    private double m_radius;

    public Sphere(double radius)
    {
        this.m_radius = radius;
    }

    @Override
    public double totalSurfaceArea()
    {
        return 4 * PI * m_radius * m_radius;
    }

    @Override
    public double volume()
    {
        return (4 * PI * m_radius * m_radius * m_radius )/ 3;
    }


    @Override
    public void getData()
    {
        System.out.println("Information of Sphere:");
        super.getData();
        System.out.println();
    }
}

class Cuboid extends Figure
{
    private double m_width;
    private double m_height;
    private double m_depth;

    public Cuboid(double width, double height, double depth)
    {
        this.m_width = width;
        this.m_height = height;
        this.m_depth = depth;
    }

    @Override
    public double totalSurfaceArea()
    {
        return 2 * ((m_height * m_width) + (m_width * m_depth) + (m_depth * m_height));
    }

    @Override
    public double volume()
    {
        return m_width * m_height * m_depth;
    }

    @Override
    public void getData()
    {
        System.out.println("Information of Cuboid:");
        super.getData();
        System.out.println();
    }

}

class Cylinder extends Figure
{
    private double m_radius;
    private double m_height;

    // only considers that the Radius is the same for both the top and bottom
    public Cylinder(double radius, double height)
    {
        this.m_radius = radius;
        this.m_height = height;
    }

    @Override
    public double totalSurfaceArea()
    {
        return 2 * PI * m_radius * (m_height + m_radius);
    }

    public double volume()
    {
        return PI * m_radius * m_radius * m_height;
    }

    @Override
    public void getData()
    {
        System.out.println("Information of Cuboid:");
        super.getData();
        System.out.println();
    }

}

public class Assignment2
{

    public static void main(String[] args)
    {
        Figure[] figures = new Figure[3];
        figures[0] = new Sphere(5);
        figures[1] = new Cuboid(10, 5, 15);
        figures[2] = new Cylinder(5, 10);

        for (Figure figure : figures)
        {
            figure.getData();
        }
    }
}
