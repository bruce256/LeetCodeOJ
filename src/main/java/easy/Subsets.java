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
		return result;
	}
	
	private void dfs(int level, int[] nums, List<Integer> list) {
		if (level == nums.length) {
			ArrayList<Integer> dest = new ArrayList<>();
			Collections.copy(dest, list);
			result.add(dest);
			return;
		}
		list.add(nums[level]);
		dfs(level + 1, nums, list);
		
	}
}
