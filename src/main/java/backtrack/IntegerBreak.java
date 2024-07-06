package backtrack;

/**
 * https://leetcode.cn/problems/integer-break/description/
 * 记忆化搜索
 *
 * @auther: LvSheng
 * @date: 2024/7/6
 * @description:
 */
public class IntegerBreak {
	
	public int integerBreak(int n) {
		int[] memory = new int[n + 1];
		memory[1] = 1;
		memory[2] = 1;
		return dfs(n, memory);
	}
	
	private int dfs(int n, int[] memo) {
		if (memo[n] != 0) {
			return memo[n];
		}
		
		int max = 0;
		for (int i = 1; i < n; i++) {
			int right = Math.max(dfs(n - i, memo), n - i);
			int cur   = i * right;
			if (cur > max) {
				max = cur;
			}
		}
		
		memo[n] = max;
		return max;
	}
	
	public static void main(String[] args) {
		IntegerBreak test = new IntegerBreak();
		System.out.println(test.integerBreak(10));
	}
}
