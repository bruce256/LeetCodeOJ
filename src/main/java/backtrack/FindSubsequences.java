package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author LvSheng
 * @date 2020/1/28
 **/
public class FindSubsequences {
	
	public List<List<Integer>> findSubsequences(int[] nums) {
		Set<List<Integer>> set = new HashSet<>();
		dfs(nums, 0, new ArrayList<>(nums.length), set);
		List<List<Integer>> list = new ArrayList<>(set);
		return list;
	}
	
	private void dfs(int[] nums, int pos, List<Integer> list, Set<List<Integer>> result) {
		if (isAscending(list)) {
			result.add(new ArrayList<>(list));
		}
		
		for (int i = pos; i < nums.length; i++) {
			list.add(nums[i]);
			dfs(nums, i + 1, list, result);
			list.remove(list.size() - 1);
		}
	}
	
	private boolean isAscending(List<Integer> list) {
		if (list.size() < 2) return false;
		
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) < list.get(i - 1)) return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		FindSubsequences    sub          = new FindSubsequences();
		List<List<Integer>> subsequences = sub.findSubsequences(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
		System.out.println(subsequences);
	}
}
