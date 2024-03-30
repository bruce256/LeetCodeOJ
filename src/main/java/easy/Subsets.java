package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author LvSheng
 * @date 2024/3/26
 **/
public class Subsets {
	
	List<List<Integer>> result;
	
	public List<List<Integer>> subsets(int[] nums) {
		result = new ArrayList<>();
		dfs(0, nums, new ArrayList<>());
		return result;
	}
	
	private void dfs(int level, int[] nums, List<Integer> list) {
		if (level == nums.length) {
			List<Integer> dest = new ArrayList<>(list.size());
			dest.addAll(list);
			result.add(dest);
			return;
		}
		
		list.add(nums[level]);
		dfs(level + 1, nums, list);
		
		list.remove(list.size() - 1);
		dfs(level + 1, nums, list);
	}
	
	public static void main(String[] args) {
		Subsets test = new Subsets();
		System.out.println(test.subsets(new int[]{1, 2, 3}));
	}
}
