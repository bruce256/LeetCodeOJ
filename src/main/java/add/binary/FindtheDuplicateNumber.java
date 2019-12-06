package add.binary;

/**
 * @author lvsheng
 *         project LeetCodeOJ
 *         date 2016年2月25日
 *         time 下午5:59:03
 */
public class FindtheDuplicateNumber {

	public int findDuplicate(int[] nums) {
		for (int i = 0; i < nums.length; i++)
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] == nums[j]) return nums[i];
			}
		return 0;
	}
}
