#ifndef VALUE_CONVERTER_HPP
#define VALUE_CONVERTER_HPP

#include <string>
#include <sstream>
#include <stdexcept>

/**
 * @class ValueConverter
 *
 * @brief ValueConverter class is a static class used to convert string to primitive types like int, unsigned int, long, double ...
 */
class ValueConverter
{
public:
    // class is full static so delete constructor
    ValueConverter() = delete;

    ~ValueConverter() = delete;
    ValueConverter(const ValueConverter&) = delete;
    ValueConverter(ValueConverter&&) = delete;
    ValueConverter& operator=(const ValueConverter&) = delete;
    ValueConverter& operator=(ValueConverter&&) = delete;

    /**
     * @brief Function is converting the string to the value of type T
     *        If the conversion cannot be done, the std::invaliud_argument is raised
     *
     * @tparam T - type of value to be converted from string
     * @param str - string with value to convert
     * @return converted value from string of type T
     */
    template<typename T>
    static T stringToVal(const std::string& str) noexcept(false)
    {
        char c;
        T val;
        std::stringstream ss(str);

        ss >> val;
        if (ss.fail() || ss.get(c))
            throw std::invalid_argument(std::string("Cannot convert ") + str + std::string(" to value"));

        return val;
    }
};

#endif
