package march;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/merge-sorted-array/
 *
 * @author LvSheng
 * @date 2020/1/28
 **/
public class Merge {
	
	/**
	 * 逆向双指针
	 *
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int pos = m + n - 1;
		m--;
		n--;
		while (n >= 0 && m >= 0) {
			if (nums1[m] < nums2[n]) {
				nums1[pos--] = nums2[n--];
			} else {
				nums1[pos--] = nums1[m--];
			}
		}
		if (n >= 0) {
			System.arraycopy(nums2, 0, nums1, 0, n + 1);
		}
	}
	
	public void merge1(int[] nums1, int m, int[] nums2, int n) {
		System.arraycopy(nums2, 0, nums1, m, n);
		Arrays.sort(nums1);
	}
	
	public static void main(String[] args) {
		Merge merge = new Merge();
		merge.merge(new int[1], 0, new int[]{1}, 1);
	}
}
