import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == k) return nums;
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i: nums)
        {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }


        Queue<Integer> heap = new PriorityQueue<Integer>(
            (n1, n2) -> map.get(n1) - map.get(n2));
        
        for (int i: map.keySet())
        {
            heap.add(i);
            if (heap.size() > k) heap.poll();
        }
        
        int[] ret = new int[k];
        for (int i = 0; i < k; i ++)
        {
            ret[i] = heap.poll();
        }
        
        return ret;
    }
}