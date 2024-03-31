package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/permutations/
 *
 * @author LvSheng
 * @date 2024/3/31
 **/
public class Permute {
	
	List<List<Integer>> result;
	
	public List<List<Integer>> permute(int[] nums) {
		result = new ArrayList<>();
		backtrack(new ArrayList<>(), nums, 0, new boolean[nums.length]);
		return result;
	}
	
	private void backtrack(List<Integer> list, int[] nums, int level, boolean[] used) {
		if (level == nums.length) {
			result.add(new ArrayList<>(list));
			return;
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (!used[i]) {
				list.add(nums[i]);
				used[i] = true;
				backtrack(list, nums, level + 1, used);
				list.remove(list.size() - 1);
				used[i] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		Permute permute = new Permute();
		System.out.println(permute.permute(new int[]{1, 2, 3}));
	}
}
