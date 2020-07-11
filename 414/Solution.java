import java.util.Arrays;
class Solution {
    public int thirdMax(int[] nums) {
        if (nums.length == 1) return nums[0];
        else if (nums.length == 2) return Math.max(nums[0], nums[1]);
        else
        {
            Arrays.sort(nums);
            int third = nums[nums.length - 1], count = 1;
            for(int i = nums.length - 1; i >= 0; i --)
            {
                if (count == 3) return third;
                if (third > nums[i])
                {
                    count ++;
                    third = nums[i];
                }
            }
            return count == 3 ? third : nums[nums.length - 1];
        }
    }
}