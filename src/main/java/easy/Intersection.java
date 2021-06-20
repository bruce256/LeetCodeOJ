package easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author LvSheng
 * @date 2020/7/23
 **/
public class Intersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (Arrays.binarySearch(nums1, nums2[i]) != -1) {
                set.add(nums2[i]);
            }
        }

        int[]             res      = new int[set.size()];
        Iterator<Integer> iterator = set.iterator();
        int               idx      = 0;
        while (iterator.hasNext()) {
            res[idx++] = iterator.next();
        }

        return res;
    }

    public static void main(String[] args) {
        int[] a = {4, 9, 5};
        int[] b = {9, 4, 9, 8, 4};
        Intersection s = new Intersection();
        s.intersection(a, b);
    }
}
