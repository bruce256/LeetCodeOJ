package add.binary;

/**
 * @author lvsheng
 *         project LeetCodeOJ
 *         date 2016年2月25日
 *         time 下午5:59:03
 */
public class FindtheDuplicateNumber {

	public int findDuplicate(int[] nums) {
		int n = nums.length - 1;
		int sum = n * (n + 1) / 2;
		for (int i = 0; i < nums.length; i++) {
			sum -= nums[i];
		}
		return -sum;
	}
}
