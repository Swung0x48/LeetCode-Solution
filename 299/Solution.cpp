class Solution {
public:
    string getHint(string secret, string guess) {
        int secret_table[10] = {0}, guess_table[10] = {0};
        int a = 0, b = 0;
        
        for (auto i: secret) {
            ++secret_table[i - '0'];
        }
        for (auto i: guess) {
            ++guess_table[i - '0'];
        }
        for (int i = 0; i < 10; ++i) {
            b += std::min(secret_table[i], guess_table[i]);
        }
        
        for (size_t i = 0; i < std::min(secret.length(), guess.length()); ++i) {
            if (secret[i] == guess[i])
                ++a;
        }
        
        b -= a;
        
        return std::to_string(a) + "A" + std::to_string(b) + "B";
    }
};