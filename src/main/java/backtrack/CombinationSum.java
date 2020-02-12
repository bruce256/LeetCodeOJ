package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author LvSheng
 * @date 2020/2/10
 **/
public class CombinationSum {
	
	List<List<Integer>> result;
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		result = new ArrayList<>();
		Arrays.sort(candidates);
		dfs(candidates, target, 0, new LinkedList<>(), 0);
		return result;
	}
	
	void dfs(int[] candidates, int target, int current, List<Integer> list, int start) {
		if (current > target) return;
		if (current == target) {
			result.add(new ArrayList<>(list));
			return;
		}
		
		for (int i = start; i < candidates.length; i++) {
			list.add(candidates[i]);
			dfs(candidates, target, current + candidates[i], list, i);
			list.remove(list.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		CombinationSum cs = new CombinationSum();
		System.out.println(cs.combinationSum(new int[]{2, 3, 6, 7}, 7));
	}
}
