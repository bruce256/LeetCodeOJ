package dp;

import java.util.stream.Stream;

/**
 * https://leetcode.cn/problems/edit-distance/description/
 *
 * @author 吕胜 lvheng1
 * @date 2024/3/16
 **/
public class MinDistance {
	
	public int minDistance(String word1, String word2) {
		int     m  = word1.length();
		int     n  = word2.length();
		int[][] dp = new int[m + 1][n + 1];
		
		for (int i = 0; i <= n; i++) dp[0][i] = i;
		for (int i = 0; i <= m; i++) dp[i][0] = i;
		
		for (int i = 1; i <= m; i++)
			for (int j = 1; j <= n; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[i][j] = Stream.of(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1] - 1).min(Integer::compareTo).get() + 1;
				} else {
					dp[i][j] = Stream.of(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]).min(Integer::compareTo).get() + 1;
				}
			}
		return dp[m][n];
	}
	
	public static void main(String[] args) {
		MinDistance test = new MinDistance();
		System.out.println(test.minDistance("horse", "ros"));
		System.out.println(test.minDistance("intention", "execution"));
	}
}
