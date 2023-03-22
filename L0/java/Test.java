public class Test
{
    private Test() throws InstantiationError
    {
        throw new InstantiationError("This is a static class!");
    }

    // run as java -ea Test
    public static void main(final String[] args)
    {
        TestPrimes.testPrimes();
    }
}