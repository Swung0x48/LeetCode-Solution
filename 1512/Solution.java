class Solution {
    private static int CombinationofTwo(int n)
    {
        return n * (n - 1) / 2;
    }
    
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ret = 0;
        for (int num: nums)
        {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> i: map.entrySet())
        {
            if (i.getValue() >= 2) ret += CombinationofTwo(i.getValue());
        }

        return ret;
    }
}