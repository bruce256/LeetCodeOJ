package dp;

/**
 * https://leetcode.com/problems/minimum-falling-path-sum/description/
 *
 * @author LvSheng
 * @date 2024/2/3
 **/
public class MinFallingPathSum {
	
	public int minFallingPathSum(int[][] matrix) {
		int     rowNum = matrix.length;
		int[][] dp     = new int[rowNum][rowNum];
		for (int i = 0; i < rowNum; i++) {
			dp[0][i] = matrix[0][i];
		}
		
		for (int i = 1; i < rowNum; i++) {
			for (int j = 0; j < rowNum; j++) {
				if (j == 0) {
					dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + matrix[i][j];
				} else if (j == rowNum - 1) {
					dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + matrix[i][j];
				} else {
					dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i - 1][j + 1]) + matrix[i][j];
				}
			}
		}
		
		int min = dp[rowNum - 1][0];
		for (int i = 1; i < rowNum; i++) {
			if (dp[rowNum - 1][i] < min) min = dp[rowNum - 1][i];
		}
		return min;
	}
	
	public static void main(String[] args) {
		MinFallingPathSum test  = new MinFallingPathSum();
		int[][]           array = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
		System.out.println(test.minFallingPathSum(array));
	}
}
