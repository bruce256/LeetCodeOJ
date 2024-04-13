package slidingwindow;

/**
 * https://leetcode.cn/problems/minimum-size-subarray-sum/description/
 *
 * @author LvSheng
 * @date 2024/4/13
 **/
public class MinSubArrayLen {
	
	public int minSubArrayLen(int target, int[] nums) {
		int left = 0, right = 0, minLen = Integer.MAX_VALUE;
		int sum  = 0;
		while (right < nums.length) {
			sum += nums[right];
			right++;
			while (sum >= target) {
				minLen = Math.min(minLen, right - left);
				sum -= nums[left];
				left++;
			}
		}
		return minLen == Integer.MAX_VALUE ? 0 : minLen;
	}
}
