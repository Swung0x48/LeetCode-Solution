import java.util.*;

class MapUtil {
    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue( Map<K, V> map ){
        ValueComparator<K,V> bvc =  new ValueComparator<K,V>(map);
        TreeMap<K,V> sorted_map = new TreeMap<K,V>(bvc);
        sorted_map.putAll(map);
        return sorted_map;
    }

}

class ValueComparator<K, V extends Comparable<? super V>> implements Comparator<K> {
    Map<K, V> base;
    public ValueComparator(Map<K, V> base) {
        this.base = base;
    }

    public int compare(K a, K b) {
        int result = (base.get(a).compareTo(base.get(b)));
        if (result == 0) result=1;
        // returning 0 would merge keys
        return result;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i: nums)
        {
            try
            {
                map.put(i, map.get(i) + 1);
            }
            catch (NullPointerException e)
            {
                map.put(i, 1);
            }
        }
        MapUtil.sortByValue(map);

        List<Integer> ret = new ArrayList<Integer>();
        Integer[] arr = map.keySet().toArray(new Integer[0]);
        for (int i = 0; i != k; i ++)
        {
            ret.add(arr[i]);
        }

        return ret.stream().mapToInt(item -> item).toArray();
    }
}