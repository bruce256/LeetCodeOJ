package backtrack;

/**
 * https://leetcode.cn/problems/coin-change/description/
 * 记忆化搜索
 *
 * @auther: LvSheng
 * @date: 2024/7/14
 * @description:
 */
public class CoinChange {
	
	public static void main(String[] args) {
		CoinChange test = new CoinChange();
		System.out.println(test.coinChange(new int[]{1, 2, 5}, 11));
		System.out.println(test.coinChange(new int[]{2}, 3));
		System.out.println(test.coinChange(new int[]{1}, 0));
	}
	
	public int coinChange(int[] coins, int amount) {
		int[] memory = new int[amount + 1];
		memory[0] = 0;
		
		int ways = dfs(coins, amount, memory);
		return ways == Integer.MAX_VALUE ? -1 : ways;
	}
	
	private int dfs(int[] coins, int amount, int[] memory) {
		if (memory[amount] != 0 || amount == 0) {
			return memory[amount];
		}
		
		int min = Integer.MAX_VALUE;
		for (int coin : coins) {
			if (amount - coin >= 0) {
				min = Math.min(min, dfs(coins, amount - coin, memory));
			}
		}
		
		if (min == Integer.MAX_VALUE) {
			memory[amount] = Integer.MAX_VALUE;
			return Integer.MAX_VALUE;
		} else {
			memory[amount] = min + 1;
			return min + 1;
		}
	}
}
