import java.util.ArrayList;
import java.util.Collections;

/**
 * @class Primes
 *
 * @brief Primes class is a static class constains only static methods relative with primes numbers
 *        such a isPrime or gDiv
 */
public class Primes
{
    private Primes() throws InstantiationError
    {
        throw new InstantiationError("This is a static class!");
    }

    /**
     * @brief Calculates the greatest divider (n itself excluded) for n
     *        Example: gDiv(4) = 2
     *                 gDiv(2) = 1
     *                 gDiv(41) = 1
     *                 gDiv(0) = N/A (IllegalArgumentException exception)
     *                 gDiv(1) = N/A (IllegalArgumentException exception)
     *                 gDiv(-1) = N/A (IllegalArgumentException exception)
     *
     * @param n - any number, but for numbers <= 1 the exception will be raised
     *
     * @return The greatest divider (n itself excluded) for n
     */
    static public int gDiv(final int n) throws IllegalArgumentException
    {
        if (n <= 1)
            throw new IllegalArgumentException("parameter n should be > 1, got " + n);

        /*
         * the loop can end at sqrt point, because it means that the n number is a prime number
         * Example:
         *   18 = 2 * 9 or 3 * 6 (mirror is here) 6 * 3 or 9 * 2
         *   The mirror is in the middle of x * y equation -> sqrt(n)
         *   If there is no divider in <2;sqrt(n)> the number is a primer number
         */
        final int maxDivider = (int)Math.ceil(Math.sqrt((double)n));
        for (int divider = 2; divider <= maxDivider; ++divider)
            if (n % divider == 0)
                return n / divider;

        return 1; // primer number
    }

    /**
     * @brief Checks if number n is a prime number
     *        Example: isPrime(-1) -> false
     *                 isPrime(0) -> false
     *                 isPrime(1) -> false
     *                 isPrime(2) -> true
     *                 isPrime(3) -> true
     *                 isPrime(4) -> false
     * @param n - any number
     *
     * @return true if n is prime otherwise false
     */
    static public boolean isPrime(final int n)
    {
        try
        {
            return gDiv(n) == 1;
        }
        // The prime theory is well-defined (no exception fwd needed),
        // any number can be checked, negative values, 0 and 1 are not prime
        catch (final IllegalArgumentException e)
        {
            return false;
        }
    }

    /**
     * @brief Function using Erastotenes's Sieve creating ArrayList with primes <= n and >= 2
     *        For numbers < 2 the IllegalArgumentException is raised
     *
     *        Example: erastotenesSieve(2) -> {2}
     *                 erastotenesSieve(10) -> {2, 3, 5, 7}
     *                 erastotenesSieve(11) -> {2, 3, 5, 7, 11}
     * @param n - end of the range to find primes
     *
     * @return ArrayList with primes from range <2;n> both included
     */
    static public ArrayList<Integer> erastotenesSieve(final int n) throws IllegalArgumentException
    {
        if (n < 2)
            throw new IllegalArgumentException("n should be at least 2");

        if (n > Integer.MAX_VALUE - 1)
            throw new IllegalArgumentException("function will allocate array with size n + 1, max value is " + Integer.toString((Integer.MAX_VALUE - 1)) + " got " + Integer.toString(n));

        // Erastotenes's Sieve algorithm: https://cp-algorithms.com/algebra/sieve-of-eratosthenes.html#asymptotic-analysis
        final ArrayList<Boolean> primesMap = new ArrayList<Boolean>(Collections.nCopies(n + 1, Boolean.TRUE));
        primesMap.set(0, false);
        primesMap.set(1, false);

        for (int i = 2; i <= (int)Math.ceil(Math.sqrt((double)n)); ++i)
            if (primesMap.get(i))
                for (long j = (long)i * (long)i; j <= (long)n; j += (long)i)
                    primesMap.set((int)j, false);

        // Produce list of primes from primesMap
        final ArrayList<Integer> primes = new ArrayList<Integer>();
        for (int i = 0; i <= n; ++i)
            if (primesMap.get(i))
                primes.add(i);

        return primes;
    }
}
