package add.binary;


/**
 * https://leetcode.cn/problems/minimum-size-subarray-sum/description/
 *
 * @author lvsheng
 *         project LeetCodeOJ
 *         date 2016年2月25日
 *         time 下午7:44:12
 */
public class MinimumSizeSubarraySum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = {2, 3, 1, 2, 4, 3};
		int[] b = {1, 4, 4};
		//System.out.println(minSubArrayLen(7, a));
		System.out.println(minSubArrayLen2(4, b));
	}

	public static int minSubArrayLen(int s, int[] nums) {
		int len = nums.length;
		if (len == 0 || s == 0) return 0;
		int[] add = new int[len];
		add[0] = nums[0];
		for (int i = 1; i < len; i++) {
			add[i] += (add[i - 1] + nums[i]);
		}

		int l = Integer.MAX_VALUE;
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if (add[j] - add[i] >= s && j - i < l) {
					l = j - i;
				}
			}
		}
		if (l == Integer.MAX_VALUE) return 0;
		else return l;
	}

	public static int minSubArrayLen2(int s, int[] nums) {
		int len = Integer.MAX_VALUE;
		if (len == 0 || s == 0) return 0;
		int left = 0, right = 0, sum = 0;
		for (; right < nums.length; right++) {
			sum += nums[right];
			while (sum >= s && left <= right) {
				len = Math.min(len, right - left + 1);
				sum -= nums[left++];
			}
		}

		return len == Integer.MAX_VALUE ? 0 : len;
	}

}
