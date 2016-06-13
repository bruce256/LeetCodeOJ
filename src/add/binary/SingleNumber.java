package add.binary;

/**
 * @author lvsheng
 *         project LeetCodeOJ
 *         date 2016年2月16日
 *         time 下午1:46:35
 */
public class SingleNumber {

	public int singleNumber(int[] nums) {
		int a = nums[0];
		for (int i = 1; i < nums.length; i++) {
			a ^= nums[i];
		}
		return a;
	}
}
