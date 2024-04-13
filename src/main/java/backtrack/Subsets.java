package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/subsets/description/
 *
 * @author lvsheng
 * project LeetCodeOJ
 * date 2016年2月16日
 * time 下午8:44:06
 */
public class Subsets {
	
	public static void main(String[] args) {
		Subsets test = new Subsets();
		int[]   a    = {1, 2, 3};
		System.out.println(test.subsets1(a));
		System.out.println(test.subsets(a));
	}
	
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> ll = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		dfs(nums, new ArrayList<Integer>(), 0, ll);
		return ll;
	}
	
	private void dfs(int[] nums, ArrayList<Integer> l, int i, List<List<Integer>> ll) {
		if (i == nums.length) {
			ll.add((List<Integer>) l.clone());
			return;
		}
		dfs(nums, l, i + 1, ll);
		
		l.add(nums[i]);
		dfs(nums, l, i + 1, ll);
		l.remove(l.size() - 1);
	}
	
	// 掩码的方法求解
	public List<List<Integer>> subsets1(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int mask = 0; mask < (1 << nums.length); mask++) {
			ArrayList<Integer> list = new ArrayList<>();
			for (int j = 0; j < nums.length; j++) {
				if ((mask & (1 << j)) > 0) {
					list.add(nums[j]);
				}
			}
			result.add(list);
		}
		return result;
	}
	
}
