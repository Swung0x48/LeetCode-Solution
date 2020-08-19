class Solution {
    public int[] sortByBits(int[] arr) {
        List<Integer> list = Arrays.stream(arr).boxed().sorted().collect(Collectors.toList());
        list.sort((lhs, rhs) -> {
            if (lhs.equals(rhs)) return 0;

            char[] lhsBin = Integer.toBinaryString(lhs).toCharArray();
            char[] rhsBin = Integer.toBinaryString(rhs).toCharArray();

            int lhsCnt = 0, rhsCnt = 0;
            for (char i : lhsBin)
            {
                if (i == '1') lhsCnt++;
            }
            for (char i : rhsBin)
            {
                if (i == '1') rhsCnt++;
            }

            if (lhsCnt == rhsCnt) return lhs.compareTo(rhs);
            else return lhsCnt < rhsCnt ? -1 : 1;
        });

        return list.stream().mapToInt(Integer::valueOf).toArray();

    }
}