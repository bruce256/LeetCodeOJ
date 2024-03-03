package dp;

import java.util.Arrays;

/**
 * @auther lvsheng
 * @date 2016年3月16日
 * @time 下午11:20:44
 * @project LeetCodeOJ
 * 
 */

public class CoinChange {
	public static void main(String[] args) {
		int[] a = { 1, 2, 5 };
		System.out.println(coinChange(a, 11));
		int[] b = { 2 };
		System.out.println(coinChange(b, 3));
	}

	public static int coinChange(int[] coins, int amount) {
		int len = coins.length;
		if (len == 0) return -1;
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		Arrays.sort(coins);

		for (int i = 0; i < len && coins[i] <= amount; i++) dp[coins[i]] = 1;

		for (int i = 1; i <= amount; i++) {
			int min = dp[i];
			if (min == 1) continue;
			for (int j = 0; j < len && coins[j] < i; j++) {
				int c = coins[j];
				int d = dp[i - c];
				if (d != Integer.MAX_VALUE && d < min) min = d + 1;
			}
			dp[i] = min;
		}

		return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
	}
}
