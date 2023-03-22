#ifndef PRIMES_HPP
#define PRIMES_HPP

#include <stdexcept>
#include <vector>

/**
 * @class Primes
 *
 * @brief Primes class is a static class constains only static methods relative with primes numbers
 *        such a isPrime or gDiv
 */
class Primes
{
public:
    // class is full static so delete constructor
    Primes() = delete;

    ~Primes() = delete;
    Primes(const Primes&) = delete;
    Primes(Primes&&) = delete;
    Primes& operator=(const Primes&) = delete;
    Primes& operator=(Primes&&) = delete;

    /**
     * @brief Calculates the greatest divider (n itself excluded) for n
     *        Example: gDiv(4) = 2
     *                 gDiv(2) = 1
     *                 gDiv(41) = 1
     *                 gDiv(0) = N/A (std::invalid_argument exception)
     *                 gDiv(1) = N/A (std::invalid_argument exception)
     *                 gDiv(-1) = N/A (std::invalid_argument exception)
     *
     * @param n - any number, but for numbers <= 1 the exception will be raised
     *
     * @return The greatest divider (n itself excluded) for n
     */
    static int gDiv(int n) noexcept(false);

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
    static bool isPrime(int n) noexcept(true);

    /**
     * @brief Function using Erastotenes's Sieve creating ArrayList with primes <= n and >= 2
     *        For numbers < 2 the std::invalid_argument is raised
     *
     *        Example: erastotenesSieve(2) -> {2}
     *                 erastotenesSieve(10) -> {2, 3, 5, 7}
     *                 erastotenesSieve(11) -> {2, 3, 5, 7, 11}
     * @param n - end of the range to find primes
     *
     * @return ArrayList with primes from range <2;n> both included
     */
    static std::vector<int> erastotenesSieve(int n) noexcept(false);
};

#endif
