package add.binary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lvsheng
 *         project LeetCodeOJ
 *         date 2016年2月18日
 *         time 下午2:30:30
 */
public class FourSum {

	static List<List<Integer>>	ll	= new ArrayList<List<Integer>>();

	public static void main(String[] args) {
		int[] a = { 1, 0, -1, 0, -2, 2 };
		int[] b = { -493, -482, -482, -456, -427, -405, -392, -385, -351, -269, -259, -251, -235, -235, -202, -201, -194, -189, -187, -186,
				-180, -177, -175, -156, -150, -147, -140, -122, -112, -112, -105, -98, -49, -38, -35, -34, -18, 20, 52, 53, 57, 76, 124,
				126, 128, 132, 142, 147, 157, 180, 207, 227, 274, 296, 311, 334, 336, 337, 339, 349, 354, 363, 372, 378, 383, 413, 431,
				471, 474, 481, 492 };
		int[] c = { -497, -494, -484, -477, -453, -453, -444, -442, -428, -420, -401, -393, -392, -381, -357, -357, -327, -323, -306, -285,
				-284, -263, -262, -254, -243, -234, -208, -170, -166, -162, -158, -136, -133, -130, -119, -114, -101, -100, -86, -66, -65,
				-6, 1, 3, 4, 11, 69, 77, 78, 107, 108, 108, 121, 123, 136, 137, 151, 153, 155, 166, 170, 175, 179, 211, 230, 251, 255, 266,
				288, 306, 308, 310, 314, 321, 322, 331, 333, 334, 347, 349, 356, 357, 360, 361, 361, 367, 375, 378, 387, 387, 408, 414,
				421, 435, 439, 440, 441, 470, 492 };
		Arrays.sort(a);
		Arrays.sort(b);
		Arrays.sort(c);
		fourSum(a, 0);
		System.out.println(ll);
		fourSum(b, 6189);
		System.out.println(ll);

		fourSum(c, 1682);
		System.out.println(ll);

		int s = 0;
		for (int i : c) {
			s += i;
		}
		System.out.println(s);
	}

	public static List<List<Integer>> fourSum(int[] nums, int target) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		ll.clear();
		int s = 0;
		for (int i : nums) {
			s += i;
		}
		if (s < target) {
			return ll;
		}
		dfs(nums, target, 0, 0, list);
		return ll;
	}

	private static void dfs(int[] nums, int target, int level, int idx, ArrayList<Integer> list) {
		if (nums.length - idx < 4 - level)
			return;
		if (idx < nums.length && (4 - level) * nums[idx] > target - sum(list))
			return;
		if (level == 3 && idx < nums.length) {
			int s = sum(list);
			int t4 = target - s;
			if (nums[idx] > t4 && Arrays.binarySearch(nums, t4) >= 0)
				return;
		}
		if (level == 4) {
			int s = sum(list);
			if (s == target)
				ll.add((ArrayList<Integer>) list.clone());
			return;
		}

		for (int i = idx; i < nums.length; i++) {
			//if ((nums[i] * 3) + nums[nums.length - 1] < target) continue;
			list.add(nums[i]);
			dfs(nums, target, level + 1, i + 1, list);
			list.remove(new Integer(nums[i]));
		}
	}

	private static int sum(List<Integer> list) {
		int s = 0;
		for (Integer i : list) {
			s += i;
		}
		return s;
	}
}
