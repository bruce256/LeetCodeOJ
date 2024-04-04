package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/coin-change-ii/description/
 *
 * @author LvSheng
 * @date 2024/4/4
 **/
public class Change {
	
	int result;
	
	/**
	 * 深搜会超时
	 *
	 * @param amount
	 * @param coins
	 * @return
	 */
	public int change(int amount, int[] coins) {
		result = 0;
		Arrays.sort(coins);
		dfs(amount, coins, new ArrayList<>());
		return result;
	}
	
	private void dfs(int amount, int[] coins, List<Integer> list) {
		if (amount == 0) {
			result++;
			return;
		}
		if (amount < 0) {
			return;
		}
		
		for (int i = 0; i < coins.length; i++) {
			if (list.isEmpty() || coins[i] >= list.get(list.size() - 1)) {
				list.add(coins[i]);
				dfs(amount - coins[i], coins, list);
				list.remove(list.get(list.size() - 1));
			}
		}
	}
	
	/**
	 * 这样求的是排列数
	 *
	 * @param amount
	 * @param coins
	 * @return
	 */
	public int change1(int amount, int[] coins) {
		int[] dp = new int[amount + 1];
		dp[0] = 1;
		for (int a = 1; a <= amount; a++) {
			for (int coin : coins) {
				if (a - coin >= 0) {
					dp[a] += dp[a - coin];
				}
			}
		}
		return dp[amount];
	}
	
	/**
	 * 这样可以避免求出排列
	 *
	 * @param amount
	 * @param coins
	 * @return
	 */
	public int change2(int amount, int[] coins) {
		int[] dp = new int[amount + 1];
		dp[0] = 1;
		for (int coin : coins) {
			for (int a = coin; a <= amount; a++) {
				if (a - coin >= 0) {
					dp[a] += dp[a - coin];
				}
			}
		}
		return dp[amount];
	}
	
	public static void main(String[] args) {
		Change test = new Change();
//		System.out.println(test.change(500, new int[]{1, 2, 5}));
		System.out.println(test.change2(5, new int[]{1, 2, 5}));
	}
}
