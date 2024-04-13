package add.binary;

/**
 * @author lvsheng
 *         project LeetCodeOJ
 *         date 2016年2月19日
 *         time 上午11:12:18
 */
public class RemoveDuplicatesfromSortedArrayII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = { 1, 1, 1, 2, 2, 3 };
		System.out.println(removeDuplicates(a));
		int[] b = { 1, 1, 1, 1, 3, 3 };
		System.out.println(removeDuplicates(b));
	}

	public static int removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}

		int sum = 1, cnt = 1, pre = nums[0];

		for (int i = 1; i < nums.length; i++) {
			if (pre == nums[i]) {
				cnt++;
				if (cnt <= 2) {
					sum++;
					nums[sum - 1] = nums[i];
				}
			} else {
				pre = nums[i];
				cnt = 1;
				sum++;
				nums[sum - 1] = nums[i];
			}
		}
		return sum;
	}
}
