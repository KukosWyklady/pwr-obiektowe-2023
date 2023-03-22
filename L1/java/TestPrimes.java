import java.util.ArrayList;
import java.util.Arrays;

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

    static private void testErastotenesSieveException(final int n)
    {
        try
        {
            Primes.erastotenesSieve(n);
            assert false : "Exception should be raised";

        }
        catch (final IllegalArgumentException e)
        {

        }
    }

    // Integer instead of int is required by .equals method
    static private void testErastotenesSieveNormalCase(final int n, final Integer[] expectedPrimes)
    {
        final ArrayList<Integer> primes = Primes.erastotenesSieve(n);

        assert primes.size() == expectedPrimes.length : "primes length should be the same as expectedPrimes length";
        assert Arrays.asList(expectedPrimes).equals(primes) : "primes numbers not matching expected primes numbers";
    }

    static private void testErastotenesSievePerformance(final int n)
    {
        final long startTime = System.currentTimeMillis();

        final ArrayList<Integer> primes = Primes.erastotenesSieve(n);

        final long stopTime = System.currentTimeMillis();
        System.out.println("Primes.erastotenesSieve(" + n + ") took: " + (stopTime - startTime) + "ms");
    }

    static private void testErastotenesSieve()
    {
        testErastotenesSieveException(-100);
        testErastotenesSieveException(-1);
        testErastotenesSieveException(0);
        testErastotenesSieveException(1);
        testErastotenesSieveException(Integer.MAX_VALUE);

        testErastotenesSieveNormalCase(2, new Integer[] {2});
        testErastotenesSieveNormalCase(7, new Integer[] {2, 3, 5, 7});
        testErastotenesSieveNormalCase(20, new Integer[] {2, 3, 5, 7, 11, 13, 17, 19});

        testErastotenesSievePerformance(10 * 1000);
        testErastotenesSievePerformance(1 * 1000 * 1000);
        testErastotenesSievePerformance(1 * 1000 * 1000 * 1000); // java -Xmx16G
    }

    static public void testPrimes()
    {
        testGDiv();
        testIsPrime();
        testErastotenesSieve();
    }
}
