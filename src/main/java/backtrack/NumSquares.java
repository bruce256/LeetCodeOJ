package backtrack;

/**
 * @author LvSheng
 * @date 2020/2/6
 **/
public class NumSquares {
	
	int max = Integer.MAX_VALUE;
	
	public int numSquares(int n) {
		max = n;
		dfs(n, 0);
		return max;
	}
	
	private void dfs(int num, int level) {
		if (num == 0) {
			max = Math.min(max, level);
			return;
		}
		
		// 限界剪枝
		if (level > max) return;
		for (int i = 1; num - i * i >= 0; i++) {
			dfs(num - i * i, level + 1);
		}
	}
	
	public static void main(String[] args) {
		NumSquares ns = new NumSquares();
//		System.out.println(ns.numSquares(13));
//		System.out.println(ns.numSquares(9));
		System.out.println(ns.numSquares(313));
	}
}
