#include <valueConverter.hpp>

#include <cassert>
#include <cmath>

void testValueConverter() noexcept(true);

static void testValueConverterNormalCase() noexcept(true)
{
    assert(ValueConverter::stringToVal<int>("0") == 0);
    assert(ValueConverter::stringToVal<int>("123") == 123);
    assert(ValueConverter::stringToVal<int>("-123") == -123);
    assert(ValueConverter::stringToVal<int>("12345678") == 12345678);

    assert(ValueConverter::stringToVal<unsigned long>("0") == 0UL);
    assert(ValueConverter::stringToVal<unsigned long>("123") == 123UL);
    assert(ValueConverter::stringToVal<unsigned long>("-123") == static_cast<unsigned long>(-123));
    assert(ValueConverter::stringToVal<unsigned long>("12345678") == 12345678UL);

    assert(std::fabs(ValueConverter::stringToVal<double>("0") - 0.0) < 0.00001);
    assert(std::fabs(ValueConverter::stringToVal<double>("0.11") - 0.11) < 0.00001);
    assert(std::fabs(ValueConverter::stringToVal<double>("-3.14") - -3.14) < 0.00001);
    assert(std::fabs(ValueConverter::stringToVal<double>("123456.789") - 123456.789) < 0.00001);
}

template <typename T>
static void testValueConverterExceptions(const std::string& str) noexcept(true)
{
    try
    {
        const T val = ValueConverter::stringToVal<T>(str);
        (void)val;
        assert(false && "Exception should be raised");
    }
    catch (const std::invalid_argument& e)
    {
        (void)e;
    }
}

void testValueConverter() noexcept(true)
{
    testValueConverterNormalCase();

    testValueConverterExceptions<unsigned int>(std::string("ala"));
    testValueConverterExceptions<unsigned int>(std::string("a1"));
    testValueConverterExceptions<unsigned int>(std::string("1a1"));
    testValueConverterExceptions<unsigned int>(std::string("1a"));

    testValueConverterExceptions<long>(std::string("ala"));
    testValueConverterExceptions<long>(std::string("a1"));
    testValueConverterExceptions<long>(std::string("1a1"));
    testValueConverterExceptions<long>(std::string("1a"));

    testValueConverterExceptions<double>(std::string("ala"));
    testValueConverterExceptions<double>(std::string("a1.0"));
    testValueConverterExceptions<double>(std::string("1.a1"));
    testValueConverterExceptions<double>(std::string("1.1a"));
}
