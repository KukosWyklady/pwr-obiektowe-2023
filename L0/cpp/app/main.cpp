#include <primes.hpp>
#include <valueConverter.hpp>

#include <iostream>


int main(int argc, const char* const argv[])
{
    for (size_t i = 1; i < static_cast<size_t>(argc); ++i)
    {
        try
        {
            const int argNumber = ValueConverter::stringToVal<int>(std::string(argv[i]));
            const int gDiv = Primes::gDiv(argNumber);

            std::cout << std::to_string(argNumber) << " --> " << std::to_string(gDiv) << std::endl;
        }
        catch (const std::invalid_argument &e)
        {
            std::cerr << "Error: " << e.what() << std::endl;
        }
    }

    return 0;
}
