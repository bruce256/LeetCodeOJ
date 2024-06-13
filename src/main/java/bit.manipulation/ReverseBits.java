package bit.manipulation;

/**
 * @author lvsheng
 *         project LeetCodeOJ
 *         date 2016骞�鏈�0鏃�
 *         time 涓嬪崍2:08:08
 */
public class ReverseBits {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(reverseBits(43261596));
		System.out.println(reverseBits(1));
	}

	public static int reverseBits(int n) {
		long rev = 0;
		for (int i = 0; i < 32; i++) {
			int mod = (n >> i) & 1;
			rev = (rev << 1) + mod;
		}
		return (int) rev;
	}

}
