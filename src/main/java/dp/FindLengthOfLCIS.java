package dp;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/longest-continuous-increasing-subsequence/description/
 *
 * @author LvSheng
 * @date 2020/2/4
 **/
public class FindLengthOfLCIS {
	
	public int findLengthOfLCIS(int[] nums) {
		if (nums.length == 0) return 0;
		
		int max = 0;
		int left = 0;
		for (int right = 0; right < nums.length; right++) {
			// 非递增的时候更新窗口左边的值
			if (right > 0 && nums[right] <= nums[right - 1]) {
				left = right;
			}
			// 及时更新最大值
			max = Math.max(max, right - left + 1);
		}
		return max;
	}
}
