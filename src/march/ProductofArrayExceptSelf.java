/**
 * 
 */
package march;

import java.util.Arrays;

/**
 * @auther lvsheng
 * @date 2016年3月3日
 * @time 上午9:25:06
 * @project LeetCodeOJ
 * 
 */

public class ProductofArrayExceptSelf {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4 };
		System.out.print(Arrays.toString((productExceptSelf(a))));
	}

	public static int[] productExceptSelf(int[] nums) {
		int len = nums.length;
		int[] r = new int[len];

		int[] left = new int[len];
		int[] right = new int[len];
		left[0] = nums[0];
		for (int i = 1; i < len; i++) {
			left[i] = left[i - 1] * nums[i];
		}
		right[len - 1] = nums[len - 1];
		for (int i = len - 2; i >= 0; i--) {
			right[i] = right[i + 1] * nums[i];
		}

		r[0] = right[1];
		r[len - 1] = left[len - 2];
		for (int i = 1; i < len - 1; i++) {
			r[i] = left[i - 1] * right[i + 1];
		}
		return r;
	}
}
