public class Circle extends Figure
{
    private double radius;

    Circle(double radius)
    {
        super("circle(" + radius + ")");
        this.radius = radius;
    }

    @Override
    public double area()
    {
        return radius * radius * Math.PI;
    }

    @Override
    public double perimeter()
    {
        return 2.0 * Math.PI * radius;
    }
}
