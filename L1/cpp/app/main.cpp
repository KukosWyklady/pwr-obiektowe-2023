#include <primes.hpp>
#include <valueConverter.hpp>
#include <primesGenerator.hpp>

#include <iostream>

int main(int argc, const char* const argv[])
{
    if (argc < 3)
    {
        std::cerr << "Program requires at least 2 args to work properlym, got " << (argc - 1) << std::endl;
        return 0;
    }

    try
    {
        const int endOfRange = ValueConverter::stringToVal<int>(std::string(argv[1]));
        const PrimesGenerator primesGenerator(endOfRange);

        for (size_t i = 2; i < static_cast<size_t>(argc); ++i)
        {
            try
            {
                const size_t primeIndex = ValueConverter::stringToVal<size_t>(std::string(argv[i]));
                const int prime = primesGenerator[primeIndex];

                std::cout << std::to_string(primeIndex) << " --> " << std::to_string(prime) << std::endl;
            }
            catch (const std::invalid_argument &e)
            {
                std::cerr << "Error: " << e.what() << std::endl;
            }
        }
    }
    catch (const std::invalid_argument& e)
    {
        std::cerr << "Error: " << e.what() << std::endl;
    }

    return 0;
}
