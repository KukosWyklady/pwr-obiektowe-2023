public class Main
{
    private Main() throws InstantiationError
    {
        throw new InstantiationError("This is a static class!");
    }

    public static void main(final String[] args)
    {
        if (args.length < 2)
        {
            System.out.println("Program requires at least 2 args to work properlym, got " + args.length);
            return;
        }

        try
        {
            final int endOfRange = Integer.parseInt(args[0]);
            final PrimesGenerator primesGenerator = new PrimesGenerator(endOfRange);

            for (int i = 1; i < args.length; ++i)
            {
                try
                {
                    final int primeIndex = Integer.parseInt(args[i]);
                    System.out.println(primeIndex + " --> " + primesGenerator.getPrime(primeIndex));
                }
                catch(final IllegalArgumentException e)
                {
                    System.out.println(args[i] + " --> " + e.toString());
                }
            }
        }
        catch(final IllegalArgumentException e) // NumberFormatException is a subclass of alternative IllegalArgumentException
        {
            System.out.println(e.toString());
        }
    }
}
