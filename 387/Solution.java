import java.util.*;

class Solution {
    public int firstUniqChar(String s) {
        int ret = -1;

        Map<Character, Integer> freqMap = new HashMap<Character, Integer>();
        Map<Character, Integer> indexMap = new HashMap<Character, Integer>();

        char[] charArr = s.toCharArray();
        for (char i: charArr)
        {
            freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
        }

        for (int i = 0; i < charArr.length; i ++)
        {
            indexMap.putIfAbsent(charArr[i], i);
        }

        for (Map.Entry<Character, Integer> i: freqMap.entrySet())
        {
            if (i.getValue() == 1)
            {
                int tmp = indexMap.get(i.getKey());
                if (ret == -1 || ret > tmp)
                {
                    ret = tmp;
                }
            }
        }

        return ret;
    }