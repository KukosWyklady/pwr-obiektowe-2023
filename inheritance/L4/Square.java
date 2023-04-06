public class Square extends Figure
{
    private double a;

    Square(double a)
    {
        super("square(" + a + ")");
        this.a = a;
    }

    @Override
    public double area()
    {
        return a * a;
    }

    @Override
    public double perimeter()
    {
        return 4.0 * a;
    }
}
