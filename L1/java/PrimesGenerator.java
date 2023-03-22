import java.util.ArrayList;

/**
 * @class PrimesGenerator
 *
 * @brief Primes class is a class that contains prime numbers from range <2,n> both included
 *        First you need to create object with argument n which generate prime numbers from range <2,n>
 *        Then you can get all of the primes from requested index in the sequence
 *
 *        Example:
 *        try
 *        {
 *            final PrimesGenerator pg = new PrimesGenerator(10); // {2, 3, 4, 5, 7} has been produced
 *            final int prime = pg.getPrime(0); // 2
 *        }
 *        catch (final IllegalArgumentException e)
 *        {
 *            // exception handling from both constructor and prime getter
 *        }
 *
 */
public class PrimesGenerator
{
    private final ArrayList<Integer> primes;


    /**
     * @brief Creates class instance with generated prime sequence from 2 to n both included
     *
     * @param n end of the range
     */
    public PrimesGenerator(int n) throws IllegalArgumentException
    {
        // IllegalArgumentException fwd
        primes = Primes.erastotenesSieve(n);
    }

    /**
     * @brief Getting in O(1) time prime number from generated sequence on index primeIndex
     *
     * @param primeIndex - index of the prime sequence (counting from 0)
     *
     * @return prime number on index primeIndex
     */
    public int getPrime(int primeIndex) throws IllegalArgumentException
    {
        if (primeIndex < 0 || primeIndex >= primes.size())
            throw new IllegalArgumentException("primeIndex is out of range please use <0, " + Integer.toString(primes.size() - 1) + ">");

        return primes.get(primeIndex);
    }
}
