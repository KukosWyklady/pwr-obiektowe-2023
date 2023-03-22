#include <primesGenerator.hpp>

#include <chrono>
#include <iostream>
#include <cassert>

void testPrimesGenerator() noexcept(true);

static void testPrimesGeneratorException(const int n, const std::vector<size_t>& primeIndexes) noexcept(true)
{
    try
    {
        const PrimesGenerator primesGenerator(n);
        for (const size_t& primeIndex : primeIndexes)
        {
            const int prime = primesGenerator[primeIndex];
            (void)prime;
        }

        assert(false && "Exception should be raised");
    }
    catch (const std::invalid_argument& e)
    {
        (void)e;
    }
}

static void testPrimesGeneratorNormalCase(const int n, const std::vector<size_t>& primeIndexes, const std::vector<int> expectedPrimes) noexcept(true)
{
    const PrimesGenerator primesGenerator(n);
    for (size_t i = 0; i < primeIndexes.size(); ++i)
        assert(primesGenerator[primeIndexes[i]] == expectedPrimes[i]);
}

static void testPrimesGeneratorPerformance(const int n, const std::vector<size_t>& primeIndexes) noexcept(true)
{
    const auto startTime = std::chrono::high_resolution_clock::now();

    const PrimesGenerator primesGenerator(n);
    for (const size_t& primeIndex : primeIndexes)
    {
        const int prime = primesGenerator[primeIndex];
        (void)prime;
    }

    const auto finishTime = std::chrono::high_resolution_clock::now();

    std::cout << "PrimesGenerator(" << n << ") took: " << std::chrono::duration_cast<std::chrono::milliseconds>(finishTime - startTime).count() << "ms" << std::endl;
}

void testPrimesGenerator() noexcept(true)
{
    testPrimesGeneratorException(-100, std::vector<size_t>{});
    testPrimesGeneratorException(0, std::vector<size_t>{});
    testPrimesGeneratorException(1, std::vector<size_t>{});
    testPrimesGeneratorException(2, std::vector<size_t>{0, static_cast<size_t>(-1), 1, 2, 100, static_cast<size_t>(-100)});
    testPrimesGeneratorException(100, std::vector<size_t>{0, static_cast<size_t>(-1), 1, 2, 100, static_cast<size_t>(-100)});
    testPrimesGeneratorException(1000, std::vector<size_t>{0, static_cast<size_t>(-1), 1, 2, 100, static_cast<size_t>(-100)});

    testPrimesGeneratorNormalCase(2, std::vector<size_t>{0}, std::vector<int>{2});
    testPrimesGeneratorNormalCase(100, std::vector<size_t>{0, 3, 7, 10}, std::vector<int>{2, 7, 19, 31});

    testPrimesGeneratorPerformance(10 * 1000, std::vector<size_t>{0, 100, 1000});
    testPrimesGeneratorPerformance(1 * 1000 * 1000, std::vector<size_t>{0, 100, 1000});
    testPrimesGeneratorPerformance(1 * 1000 * 1000, std::vector<size_t>{0, 100, 1000, 78497});
    testPrimesGeneratorPerformance(1 * 1000 * 1000 * 1000, std::vector<size_t>{0, 100, 1000});
    testPrimesGeneratorPerformance(1 * 1000 * 1000 * 1000, std::vector<size_t>{0, 100, 1000, 100000});
}
