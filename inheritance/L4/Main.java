import java.util.HashMap;

public class Main
{
    public static void main(String args[])
    {
       Figure figures[] = buildFiguresFromArgs(args);

        // use them
        for (Figure f : figures)
            System.out.println(f.getName() + " area = " + f.area() + " perimeter = " + f.perimeter());
    }

    public static Figure[] buildFiguresFromArgs(String args[])
    {
        // strore all the figures
        Figure figures [] = new Figure[2];
        HashMap<String, FigureBuilder> figureBuildersMap = new HashMap<String, FigureBuilder>()
        {{
            put("c", new CircleBuilder());
            put("s", new SquareBuilder());
        }};

        // c -> circle [1]
        // s -> square [1]
        // r -> rectagle [2]
        // for (String arg : args)
            // figures[i] = figureBuildersMap.get(arg).buildFigure(args) // substring

        // code
        figures[0] = new Circle(4.2);

        // code
        figures[1] = new Square(9.3);

        return figures;
    }
}
