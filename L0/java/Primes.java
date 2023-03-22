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
     *
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
}
