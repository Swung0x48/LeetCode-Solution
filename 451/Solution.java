import java.util.*;

class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char i: s.toCharArray())
        {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        Queue<Character> heap = new PriorityQueue<Character>(
                (n1, n2) -> map.get(n2) - map.get(n1)
        );

//        heap.addAll(map.keySet());
        for (char i: map.keySet())
        {
            heap.offer(i);
        }

        StringBuilder ret = new StringBuilder();
//        for (Character ch: heap)
//        {
//            int freq = map.get(ch);
//            for (int i = 0; i < freq; i ++)
//            {
//                ret.append(ch);
//            }
//        }

        while (!heap.isEmpty())
        {
            Character ch = heap.poll();
            int freq = map.get(ch);
            for (int i = 0; i < freq; i ++)
            {
                ret.append(ch);
            }
        }
        return ret.toString();
    }
}