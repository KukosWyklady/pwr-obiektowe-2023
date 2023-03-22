#include <primesGenerator.hpp>
#include <primes.hpp>

const int& PrimesGenerator::getPrimeRef(const size_t primeIndex) const noexcept(false)
{
    if (primeIndex >= primes.size())
        throw std::invalid_argument(std::string("primeIndex is out of range please use <0,") + std::to_string(primes.size()-1) + std::string(">"));

    return primes[primeIndex];
}

PrimesGenerator::PrimesGenerator(const int n) noexcept(false)
: primes{Primes::erastotenesSieve(n)}  // std::invalid_argument fwd
{

}

int PrimesGenerator::getPrime(const size_t primeIndex) const noexcept(false)
{
    // std::invalid_argument fwd
    return getPrimeRef(primeIndex);
}
