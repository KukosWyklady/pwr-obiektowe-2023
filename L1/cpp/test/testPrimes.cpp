#include <primes.hpp>

#include <cassert>
#include <chrono>
#include <iostream>

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

static void testErastotenesSieveException(const int n) noexcept(true)
{
    try
    {
        const std::vector<int> primes = Primes::erastotenesSieve(n);
        (void)primes;

        assert(false && "Exception should be raised");
    }
    catch (const std::invalid_argument& e)
    {
        (void)e;
    }
}

static void testErastotenesSieveNormalCase(const int n, const std::vector<int> expectedPrimes) noexcept(true)
{
    const std::vector<int> primes = Primes::erastotenesSieve(n);

    assert(primes.size() == expectedPrimes.size());
    assert(primes == expectedPrimes);
}

static void testErastotenesSievePerformance(const int n)  noexcept(true)
{
    const auto startTime = std::chrono::high_resolution_clock::now();

    const std::vector<int> primes = Primes::erastotenesSieve(n);
    (void)primes;

    const auto finishTime = std::chrono::high_resolution_clock::now();

    std::cout << "Primes::erastotenesSieve(" << n << ") took: " << std::chrono::duration_cast<std::chrono::milliseconds>(finishTime - startTime).count() << "ms" << std::endl;
}

static void testErastotenesSieve() noexcept(true)
{
    testErastotenesSieveException(-100);
    testErastotenesSieveException(-1);
    testErastotenesSieveException(0);
    testErastotenesSieveException(1);

    testErastotenesSieveNormalCase(2, std::vector<int>{2});
    testErastotenesSieveNormalCase(7, std::vector<int>{2, 3, 5, 7});
    testErastotenesSieveNormalCase(20, std::vector<int>{2, 3, 5, 7, 11, 13, 17, 19});

    testErastotenesSievePerformance(10 * 1000);
    testErastotenesSievePerformance(1 * 1000 * 1000);
    testErastotenesSievePerformance(1 * 1000 * 1000 * 1000);
}

void testPrimes() noexcept(true)
{
    testGDiv();
    testIsPrime();
    testErastotenesSieve();
}
