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
