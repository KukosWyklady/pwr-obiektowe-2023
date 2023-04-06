public class CircleBuilder extends FigureBuilder
{
    @Override
    public Figure buildFigure(String args[])
    {
        return new Circle(Double.parseDouble(args[0]));
    }
}
