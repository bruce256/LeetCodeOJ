package march;

/**
 * @author LvSheng
 * @date 2020/2/5
 **/
public class MaxSubArray {
	
	public int maxSubArray(int[] nums) {
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		int max = nums[0];
		
		for (int i = 1; i < nums.length; i++) {
			if (dp[i - 1] <= 0) dp[i] = nums[i];
			else {
				dp[i] = dp[i - 1] + nums[i];
			}
			max = Math.max(max, dp[i]);
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		MaxSubArray msa = new MaxSubArray();
		System.out.println(msa.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
	}
}
