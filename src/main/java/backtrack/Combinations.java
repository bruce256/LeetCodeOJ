package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lvsheng
 *         project LeetCodeOJ
 *         date 2016年2月18日
 *         time 下午1:36:03
 */
public class Combinations {

	static List<List<Integer>>	ll	= new ArrayList<List<Integer>>();

	public static void main(String[] args) {
		System.out.println(combine(5, 2));
		System.out.println(combine(4, 2));
	}

	public static List<List<Integer>> combine(int n, int k) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		ll.clear();
		dfs(n, k, 0, 1, list);
		return ll;
	}

	private static void dfs(int n, int k, int level, int idx, ArrayList<Integer> list) {
		if (level >= k) {
			ll.add((ArrayList<Integer>) list.clone());
			return;
		}
		for (int i = idx; i <= n; i++) {
			list.add(i);
			dfs(n, k, level + 1, i + 1, list);
			list.remove(new Integer(i));
		}
	}
}
