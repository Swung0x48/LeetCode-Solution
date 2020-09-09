public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        List<Integer> list = new ArrayList<>();

        int i = 0, j = 0;
        while (i < m && j < n)
        {
            if (nums1[i] < nums2[j])
            {
                list.add(nums1[i]);
                i++;
            }
            else {
                list.add(nums2[j]);
                j++;
            }
        }

        if (i != m)
        {
            for (; i < m; i++)
            {
                list.add(nums1[i]);
            }
        }
        else {
            for (; j < n; j++)
            {
                list.add(nums2[j]);
            }
        }

        int[] array = list.stream().mapToInt(a->a).toArray();

        System.arraycopy(array, 0, nums1, 0, array.length);
    }
}
