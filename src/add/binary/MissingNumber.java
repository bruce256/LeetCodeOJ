package add.binary;

/**
 * @author lvsheng
 *         project LeetCodeOJ
 *         date 2016年2月17日
 *         time 下午6:53:00
 */
public class MissingNumber {

	public static void main(String[] args) {
		int[] a = { 0, 1, 3 };
		System.out.println(missingNumber(a));
		System.out.println(missingNumber2(a));
	}

	public static int missingNumber(int[] nums) {
		long sum = nums.length * (nums.length + 1) / 2;
		for (int i = 0; i < nums.length; i++) {
			sum -= nums[i];
		}
		return (int) sum;
	}

	public static int missingNumber2(int[] nums) {
		int r = 0;
		for (int i = 0; i < nums.length; i++) {
			r ^= (nums[i] ^ i);
		}
		return r ^ nums.length;
	}
}
