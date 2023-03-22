#include <primes.hpp>

#include <cassert>

void testPrimes() noexcept(true);

static void testGDivException(const int n) noexcept(true)
{
    try
    {
        const int val = Primes::gDiv(n);
        (void)val;

        assert(false && "Exception should be raised");
    }
    catch (const std::invalid_argument& e)
    {
        (void)e;
    }
}

static void testGDiv() noexcept(true)
{
    testGDivException(-100);
    testGDivException(-1);
    testGDivException(0);
    testGDivException(1);

    assert(Primes::gDiv(2) == 1);
    assert(Primes::gDiv(17) == 1);
    assert(Primes::gDiv(1234567891) == 1);
    assert(Primes::gDiv(1234567892) == 617283946);
}

static void testIsPrime() noexcept(true)
{
    assert(Primes::isPrime(0) == false);
    assert(Primes::isPrime(1) == false);
    assert(Primes::isPrime(-1) == false);
    assert(Primes::isPrime(-100) == false);
    assert(Primes::isPrime(2) == true);
    assert(Primes::isPrime(1234567891) == true);
    assert(Primes::isPrime(1234567892) == false);
}

void testPrimes() noexcept(true)
{
    testGDiv();
    testIsPrime();
}
