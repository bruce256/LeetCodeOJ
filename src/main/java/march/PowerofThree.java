/**
 * 
 */
package march;

/**
 * @auther lvsheng
 * @date 2016年3月2日
 * @time 下午3:40:20
 * @project LeetCodeOJ
 * 
 */

public class PowerofThree {
	public static void main(String[] args) {
		System.out.println(isPowerOfThree(243));

	}
	public static boolean isPowerOfThree(int n) {
		if (n < 0)
			return false;
		double d = Math.log10(n) / Math.log10(3);
		if (d - (int) d != 0)
			return false;
		return true;
	}
}
