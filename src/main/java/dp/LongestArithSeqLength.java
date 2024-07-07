package dp;

/**
 * https://leetcode.cn/problems/longest-arithmetic-subsequence/description/
 *
 * @auther: LvSheng
 * @date: 2024/7/7
 * @description:
 */
public class LongestArithSeqLength {
	
	public int longestArithSeqLength(int[] nums) {
		int   length = nums.length;
		int[] dp     = new int[length];
		int[] diff   = new int[length + 1];
		
		for (int i = 0; i < length; i++) dp[i] = 1;
		
		for (int i = 1; i < length; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (diff[j] == 0) {
					max     = 2;
					diff[i] = nums[i] - nums[j];
				} else if (nums[i] - nums[j] == diff[j] && dp[j] + 1 > max) {
					max     = dp[j] + 1;
					diff[i] = diff[j];
				}
			}
			dp[i] = max;
		}
		
		int max = 0;
		for (int i : dp) {
			if (i > max) max = i;
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		LongestArithSeqLength test = new LongestArithSeqLength();
		System.out.println(test.longestArithSeqLength(new int[]{3, 6, 9, 12}));
		System.out.println(test.longestArithSeqLength(new int[]{9,4,7,2,10}));
	}
}
