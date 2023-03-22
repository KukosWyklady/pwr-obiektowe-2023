public class Main
{
    private Main() throws InstantiationError
    {
        throw new InstantiationError("This is a static class!");
    }

    public static void main(final String[] args)
    {
        for (final String arg : args)
        {
            try
            {
                final int argNumber = Integer.parseInt(arg);
                final int gDiv = Primes.gDiv(argNumber);
                System.out.println(argNumber + " --> " + gDiv);
            }
            catch (final IllegalArgumentException e) // NumberFormatException is a subclass of alternative IllegalArgumentException
            {
                System.out.println(e.toString());
            }
        }
    }
}
