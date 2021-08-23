class Solution {
public:
    string longestPalindrome(string s) {
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); ++i) {
            int l1 = i, r1 = i;
            bool valid1 = expandAroundCenter(s, l1, r1);
            int l2 = i, r2 = i + 1;
            bool valid2 = expandAroundCenter(s, l2, r2);
            if (valid1 && r1 - l1 > right - left) {
                left = l1;
                right = r1;
            }

            if (valid2 && r2 - l2 > right - left) {
                left = l2;
                right = r2;
            }
        }
        return s.substr(left, right - left + 1);
    }

private:
    bool expandAroundCenter(const string& str, int& left, int& right) {
        if (left != right && str[left] != str[right])
            return false;

        while (left - 1 >= 0 && right + 1 <= str.length() - 1 && str[left - 1] == str[right + 1]) {
            --left;
            ++right;
        }
        return true;
    }
};