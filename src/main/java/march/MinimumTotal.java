package march;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LvSheng
 * @date 2020/1/27
 **/
public class MinimumTotal {
	
	public int minimumTotal(List<List<Integer>> triangle) {
		for (int i = triangle.size() - 1; i > 0; i--) {
			List<Integer> list = triangle.get(i);
			List<Integer> up   = triangle.get(i - 1);
			for (int j = 0; j < up.size(); j++) {
				up.set(j, up.get(j) + Math.min(list.get(j), list.get(j + 1)));
			}
		}
		
		return triangle.get(0).get(0);
	}
	
	// 超时
	public int minimumTotal1(List<List<Integer>> triangle) {
		return dfs(triangle, 0, 0);
	}
	
	private int dfs(List<List<Integer>> triangle, int pos, int level) {
		if (level == triangle.size() - 1) {
			return triangle.get(level).get(pos);
		}
		
		int left  = dfs(triangle, pos, level + 1);
		int right = dfs(triangle, pos + 1, level + 1);
		return triangle.get(level).get(pos) + Math.min(left, right);
	}
}
