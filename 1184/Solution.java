class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int ret1 = 0, ret2 = 0;
        for (int i = start; i != destination; i = ++i % distance.length)
        {
            ret1 += distance[i];
            distance[i] = 0;
        }
        
        for (int i = 0; i < distance.length; i ++)
        {
            ret2 += distance[i];
        }
        
        return ret1 < ret2 ? ret1 : ret2;
    }
}