#ifndef PRIMES_GENERATOR_HPP
#define PRIMES_GENERATOR_HPP

#include <vector>
#include <stdexcept>

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
 *            const PrimesGenerator pg(10); // {2, 3, 4, 5, 7} has been produced
 *            const int prime1 = pg.getPrime(0); // 2
 *            const int prime2 = pg[1]; // 3
 *        }
 *        catch (const std::invalid_argument& e)
 *        {
 *            // exception handling from both constructor and prime getter
 *        }
 *
 */
class PrimesGenerator
{
private:
    std::vector<int> primes;

    const int& getPrimeRef(size_t primeIndex) const noexcept(false);

public:
    /**
     * @brief Creates class instance with generated prime sequence from 2 to n both included
     *
     * @param n end of the range
     */
    explicit PrimesGenerator(int n) noexcept(false);

    /**
     * @brief Getting in O(1) time prime number from generated sequence on index primeIndex
     *
     * @param primeIndex - index of the prime sequence (counting from 0)
     *
     * @return prime number on index primeIndex
     */
    int getPrime(size_t primeIndex) const noexcept(false);

    virtual ~PrimesGenerator() noexcept(true) = default;
    PrimesGenerator(const PrimesGenerator&) noexcept(true) = default;
    PrimesGenerator(PrimesGenerator&&) noexcept(true) = default;
    PrimesGenerator& operator=(const PrimesGenerator&) noexcept(true) = default;
    PrimesGenerator& operator=(PrimesGenerator&&) noexcept(true) = default;

    /**
     * @brief Getting in O(1) time prime number from generated sequence on index primeIndex
     *
     * @param primeIndex - index of the prime sequence (counting from 0)
     *
     * @return prime number on index primeIndex
     */
    const int& operator[](const size_t primeIndex) const noexcept(false)
    {
        // std::invalid_argument fwd
        return getPrimeRef(primeIndex);
    }
};

#endif
