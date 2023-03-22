#include <primes.hpp>

#include <string>
#include <cmath>

int Primes::gDiv(const int n) noexcept(false)
{
    if (n <= 1)
        throw std::invalid_argument(std::string("parameter n should be > 1, got ") + std::to_string(n));

    /*
     * the loop can end at sqrt point, because it means that the n number is a prime number
     * Example:
     *   18 = 2 * 9 or 3 * 6 (mirror is here) 6 * 3 or 9 * 2
     *   The mirror is in the middle of x * y equation -> sqrt(n)
     *   If there is no divider in <2;sqrt(n)> the number is a primer number
     */
    const int maxDivider = static_cast<int>(std::ceil(std::sqrt(static_cast<double>(n))));
    for (int divider = 2; divider <= maxDivider; ++divider)
        if (n % divider == 0)
            return n / divider;

    return 1; // primer number
}


bool Primes::isPrime(const int n) noexcept(true)
{
    try
    {
        return gDiv(n) == 1;
    }
    // The prime theory is well-defined (no exception fwd needed),
    // any number can be checked, negative values, 0 and 1 are not prime
    catch (const std::invalid_argument& e)
    {
        (void)e;

        return false;
    }
}

std::vector<int> Primes::erastotenesSieve(int n) noexcept(false)
{
    if (n < 2)
        throw std::invalid_argument("n should be at least 2");

    std::vector<bool> primesMap(static_cast<size_t>(n) + 1UL, true);
    primesMap[0] = false;
    primesMap[1] = false;

    // Erastotenes's Sieve algorithm: https://cp-algorithms.com/algebra/sieve-of-eratosthenes.html#asymptotic-analysis
    for (size_t i = 2; i <= static_cast<size_t>(std::ceil(std::sqrt(static_cast<double>(n)))); ++i)
            if (primesMap[i])
                for (size_t j = i * i; j <= static_cast<size_t>(n); j += i)
                    primesMap[j] = false;

    // Produce list of primes from primesMap
    std::vector<int> primes;
    for (size_t i = 0; i <= static_cast<size_t>(n); ++i)
        if (primesMap[i])
            primes.push_back(static_cast<int>(i));

    return primes;
}
