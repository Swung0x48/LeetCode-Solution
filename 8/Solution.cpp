class Solution {
public:
    int myAtoi(string s) {
        int i = 0;
        while (s[i] == ' ')
            ++i;

        int sign = 1;
        if (s[i] == '-') {
            sign = -1;
            ++i;
        }
        else if (s[i] == '+') {
            ++i;
        }

        long ret = 0;

        while (s[i] == '0')
            ++i;

        for (; i < s.length(); ++i) {
            if (!isdigit(s[i]))
                break;

            ret *= 10;
            ret += (sign * todigit(s[i]));

            if (ret < std::numeric_limits<int>::min())
                return std::numeric_limits<int>::min();

            if (ret > std::numeric_limits<int>::max())
                return std::numeric_limits<int>::max();
        }

        return ret;
    }

    bool isdigit(char c) {
        if (c >= '0' && c <= '9')
            return true;
        return false;
    }

    int todigit(char c) {
        return c - '0';
    }
};