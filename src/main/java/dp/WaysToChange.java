package dp;

/**
 * https://leetcode.cn/problems/coin-lcci/
 *
 * @auther: LvSheng
 * @date: 2024/7/13
 * @description:
 */
public class WaysToChange {
	
	public static void main(String[] args) {
		WaysToChange test = new WaysToChange();
		System.out.println(test.waysToChange(10));
	}
	public int waysToChange(int n) {
		int   mod = 1000000007;
		int[] dp  = new int[n + 1];
		dp[1] = 1;
		dp[0] = 1;
		for (int i = 2; i <= n; i++) {
			if (i - 1 >= 0) dp[i] = (dp[i] + dp[i - 1]) % mod;
			if (i - 5 >= 0) dp[i] = (dp[i] + dp[i - 5]) % mod;
			if (i - 10 >= 0) dp[i] = (dp[i] + dp[i - 10]) % mod;
			if (i - 25 >= 0) dp[i] = (dp[i] + dp[i - 25]) % mod;
		}
		return dp[n];
	}
	
}
