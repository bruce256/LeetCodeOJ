package dp;

/**
 * https://leetcode.com/problems/maximum-length-of-repeated-subarray/description/
 *
 * @author LvSheng
 * @date 2024/4/6
 **/
public class FindLength {
	
	public int findLength(int[] nums1, int[] nums2) {
		int[][] dp  = new int[nums1.length + 1][nums2.length + 1];
		int     max = 0;
		for (int r = nums1.length - 1; r >= 0; r--) {
			for (int c = nums2.length - 1; c >= 0; c--) {
				if (nums1[r] == nums2[c]) {
					dp[r][c] = dp[r + 1][c + 1] + 1;
				} else {
					dp[r][c] = 0;
				}
				
				max = Math.max(max, dp[r][c]);
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		FindLength test = new FindLength();
		System.out.println(test.findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
	}
}
