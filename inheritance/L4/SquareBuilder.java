public class SquareBuilder extends FigureBuilder
{
    @Override
    public Figure buildFigure(String args[])
    {
        return new Square(Double.parseDouble(args[0]));
    }
}