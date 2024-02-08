package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author lvsheng
 *         project LeetCodeOJ
 *         date 2016年2月16日
 *         time 下午8:44:06
 */
public class Subsets {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3 };
		System.out.println(subsets(a));
	}

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> ll = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		dfs(nums, new ArrayList<Integer>(), 0, ll);
		return ll;
	}

	private static void dfs(int[] nums, ArrayList<Integer> l, int i, List<List<Integer>> ll) {
		if (i == nums.length) {
			ll.add((List<Integer>) l.clone());
			return;
		}
		l.add(nums[i]);
		dfs(nums, l, i + 1, ll);
		l.remove(l.size() - 1);
		dfs(nums, l, i + 1, ll);
	}
}
