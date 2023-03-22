public class TestPrimes
{
    private TestPrimes() throws InstantiationError
    {
        throw new InstantiationError("This is a static class!");
    }

    static private void testGDivException(final int n)
    {
        try
        {
            Primes.gDiv(n);
            assert false : "Exception should be raised";

        }
        catch (final IllegalArgumentException e)
        {

        }
    }

    static private void testGDiv()
    {
        testGDivException(-100);
        testGDivException(-1);
        testGDivException(0);
        testGDivException(1);

        assert Primes.gDiv(2) == 1 : "gDiv(2) == 1";
        assert Primes.gDiv(17) == 1 : "gDiv(17) == 1";
        assert Primes.gDiv(1234567891) == 1 : "gDiv(1234567891) == 1";
        assert Primes.gDiv(1234567892) == 617283946 : "gDiv(1234567892) == 617283946";
        assert Primes.gDiv(Integer.MAX_VALUE) == 1 : "gDiv(Integer.MAX_VALUE) == 1";
    }

    static private void testIsPrime()
    {
        assert Primes.isPrime(0) == false : "0 is not prime";
        assert Primes.isPrime(1) == false : "1 is not prime";
        assert Primes.isPrime(-1) == false : "-1 is not prime";
        assert Primes.isPrime(-100) == false : "-100 is not prime";
        assert Primes.isPrime(2) == true : "2 is prime";
        assert Primes.isPrime(1234567891) == true : "1234567891 is prime";
        assert Primes.isPrime(1234567892) == false : "1234567892 is not prime";
    }

    static public void testPrimes()
    {
        testGDiv();
        testIsPrime();
    }
}
