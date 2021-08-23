class Solution {
public:
    int lengthOfLongestSubstring(std::string s) {
        int result = 0, cur_length = 0, cur_begin = 0;
        std::array<int, 130> last_appearance{};
        std::memset(last_appearance.data(),
                    -1,
                    last_appearance.size() * sizeof(last_appearance[0]));
        for (int i = 0; i < s.length(); ++i) {
            if (last_appearance[s[i]] < cur_begin) {
                last_appearance[s[i]] = i;
                ++cur_length;
            } else {
                result = std::max(result, cur_length);
                cur_length = i - last_appearance[s[i]];
                cur_begin = last_appearance[s[i]] + 1;
                last_appearance[s[i]] = i;
            }
        }
        return std::max(result, cur_length);
    }
};
