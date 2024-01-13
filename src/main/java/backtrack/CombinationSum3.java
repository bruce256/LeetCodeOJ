package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/combination-sum-iii/description/
 *
 * @author 吕胜 lvheng1
 * @date 2024/1/13
 **/
public class CombinationSum3 {
	
	public static void main(String[] args) {
		CombinationSum3 test = new CombinationSum3();
		System.out.println(test.combinationSum3(3, 7));
		System.out.println(test.combinationSum3(3, 9));
	}
	
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> result = new ArrayList<>();
		dfs(k, n, 0, new ArrayList<>(), result);
		return result;
	}
	
	private void dfs(int k, int n, int level, List<Integer> list, List<List<Integer>> result) {
		if (level == k) {
			Integer sum = list.stream().reduce((x, y) -> (x + y)).get();
			if (sum == n) {
				List<Integer> copy = new ArrayList<>();
				copy.addAll(list);
				result.add(copy);
			}
			return;
		}
		
		for (int i = 1; i <= 9; i++) {
			if (!list.contains(i)) {
				if (list.size() > 0 && i < list.get(list.size() - 1)) {
					continue;
				}
				list.add(i);
				dfs(k, n, level + 1, list, result);
				list.remove(list.size() - 1);
			}
		}
	}
}
