package dp;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * @author LvSheng
 * @date 2020/2/4
 **/
public class FindLengthOfLCIS {
	
	public int findLengthOfLCIS(int[] nums) {
		if (nums.length == 0) return 0;
		
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);
		int anchor = 0;
		int result = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[i - 1]) {
				dp[i] = dp[i - 1] + 1;
				result = Math.max(result, i - anchor + 1);
			} else anchor = i;
			
		}
		
		return result;
	}
}
