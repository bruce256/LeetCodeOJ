package dp;

/**
 * https://leetcode.cn/problems/longest-common-subsequence/description/
 *
 * @author LvSheng
 * @date 2024/3/22
 **/
public class LongestCommonSubsequence {
	
	public int longestCommonSubsequence(String text1, String text2) {
		int m = text1.length();
		int n = text2.length();
		
		int dp[][] = new int[m + 1][n + 1];
		
		for (int r = 1; r <= m; r++) {
			for (int c = 1; c <= n; c++) {
				if (text1.charAt(r - 1) == text2.charAt(c - 1)) {
					dp[r][c] = dp[r - 1][c - 1] + 1;
				} else {
					dp[r][c] = Math.max(dp[r - 1][c], dp[r][c - 1]);
				}
			}
		}
		return dp[m][n];
	}
}
