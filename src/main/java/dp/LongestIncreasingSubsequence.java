package dp;

/**
 * @author lvsheng
 *         project LeetCodeOJ
 *         date 2016年2月16日
 *         time 下午7:16:13
 */
public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] a = { 10, 9, 2, 5, 3, 7, 101, 18 };
		System.out.println(lengthOfLIS(a));
	}

	public static int lengthOfLIS(int[] nums) {
		if(nums.length == 0) return 0;
		int[] f = new int[nums.length];
		for (int i = 0; i < f.length; i++) {
			f[i] = 1;
		}
		int max = 1;
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j] && f[j] + 1 > f[i]) {
					f[i] = f[j] + 1;
					if (f[i] > max)
						max = f[i];
				}
			}
		}

		return max;
	}
}
