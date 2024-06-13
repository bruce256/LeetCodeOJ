package dp;

/**
 * @author lvsheng
 *         project LeetCodeOJ
 *         date 2016年2月20日
 *         time 下午5:49:59
 */
public class MinimumPathSum {

	public static void main(String[] args) {
		int[][] a = {{1,2},{1,1}};
		System.out.print(minPathSum(a));
	}

	public static int minPathSum(int[][] grid) {
		if (grid.length == 0 || grid[0].length == 0)
			return 0;

		// initiate
		int[][] dp = new int[grid.length][grid[0].length];
		dp[0][0] = grid[0][0];
		int rows = dp.length;
		int cols = dp[0].length;
		for (int i = 1; i < rows; i++) {
			dp[i][0] += (dp[i - 1][0] + grid[i][0]);
		}
		
		for (int i = 1; i < cols; i++) {
			dp[0][i] += (dp[0][i - 1] + grid[0][i]);
		}

		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < dp[i].length; j++) {
				int min = Math.min(dp[i - 1][j], dp[i][j - 1]);
				dp[i][j] = grid[i][j] + min;
			}
		}
		
		return dp[rows -1][cols -1];
	}

}
