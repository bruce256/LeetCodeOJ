package add.binary;

/**
 * @auther lvsheng
 * @date 2016年2月15日
 * @time 下午2:04:07
 * @project LeetCodeOJ
 * 
 */
public class MajorityElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = { 1, 2, 5, 1, 1, 1 };
		int[] b = { 6, 5, 5 };
		System.out.println(majorityElement(a));
		System.out.println(majorityElement(b));
	}

	public static int majorityElement(int[] nums) {
		int m = -1, cnt = 0;
		for (int i = 0; i < nums.length; i++) {
			if (cnt == 0) {
				cnt++;
				m = nums[i];
			} else if (nums[i] == m)
				cnt++;
			else {
				cnt--;
			}
		}
		return m;
	}
}
