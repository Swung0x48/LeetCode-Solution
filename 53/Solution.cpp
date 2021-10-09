class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int result = nums[0];
        int local = 0;

        for (auto i: nums) {
            local = std::max(i, i + local);
            result = std::max(result, local);
        }

        return result;
    }
};