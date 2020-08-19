class Solution {
    public String restoreString(String s, int[] indices) {
        char[] chars = s.toCharArray();
        Map<Integer, Character> map = new TreeMap<>();
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < indices.length; i++)
        {
            map.put(indices[i], chars[i]);
        }
        for (Map.Entry<Integer, Character> i: map.entrySet())
        {
            ret.append(i.getValue());
        }
        return ret.toString();
    }
}