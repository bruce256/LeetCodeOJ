package march;

/**
 * @author LvSheng
 * @date 2020/1/27
 **/
public class MaxProfit {
	
	public int maxProfit(int[] prices) {
		int result = 0;
		for (int i = 0; i < prices.length; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				if (prices[j] - prices[i] > result) {
					result = prices[j] - prices[i];
				}
			}
		}
		return result;
	}
	
	public int maxProfit1(int[] prices) {
		int result = 0;
		int min    = Integer.MAX_VALUE;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < min) {
				min = prices[i];
			}
			if (prices[i] - min > result) {
				result = prices[i] - min;
			}
		}
		
		return result;
	}
}
