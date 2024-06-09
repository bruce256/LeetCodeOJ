package slidingwindow;

/**
 * https://leetcode.cn/problems/minimum-size-subarray-sum/description/
 *
 * @author LvSheng
 * @date 2024/4/13
 **/
public class MinSubArrayLen {
	
	public int minSubArrayLen1(int target, int[] nums) {
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
	
	public int minSubArrayLen(int target, int[] nums) {
		int left = 0, right = 0, minLen = Integer.MAX_VALUE;
		int sum  = 0;
		while (right < nums.length) {
			if (sum < target) {
				sum += nums[right];
				right++;
			} else {
				minLen = Math.min(minLen, right - left);
				sum -= nums[left];
				left++;
			}
		}
		return minLen == Integer.MAX_VALUE ? 0 : minLen;
	}
	
	public static void main(String[] args) {
		MinSubArrayLen test = new MinSubArrayLen();
		System.out.println(test.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
	}
}
