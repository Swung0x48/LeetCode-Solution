class Solution {
public:
    string convert(string s, int numRows) {
        if (numRows == 1)
            return s;

        vector<int> steps;
        steps.reserve(numRows);
        int step = 2 * numRows - 2;
        for (int i = 0; i < numRows - 1; ++i) {
            steps.emplace_back(step - i * 2);
        }
        steps.emplace_back(step);

        stringstream ss;
        for (int j = 0; j < steps.size(); ++j) {
            int seq = 0;
            for (int i = j; i < s.length(); i += flip_step(++seq, step, steps[j])) {
                ss << s[i];
            }
        }
        return ss.str();
    }

private:
    static int flip_step(int seq, int full_steps, int steps) {
        if (full_steps == steps){
            return steps;
        }
        bool flip = (seq % 2);
        return (flip ? steps : (full_steps - steps));
    }
};