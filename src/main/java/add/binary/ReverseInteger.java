package add.binary;

/**
 * @author lvsheng
 *         project LeetCodeOJ
 *         date 2016年2月16日
 *         time 上午10:42:34
 */
public class ReverseInteger {

	public static void main(String[] args) {
		System.out.println(reverse(123));
		System.out.println(reverse(-4123));
		System.out.println(reverse(0));
		System.out.println(reverse(1534236469));
		System.out.println(reverse(-2147483648));
	}

	public static int reverse(int x) {
		Long r = 0L;
		while (x != 0) {
			r = r * 10 + x % 10;
			x /= 10;
		}
		if (r.longValue() >= Integer.MAX_VALUE || r.longValue() <= Integer.MIN_VALUE)
			r = 0L;
		return r.intValue();
	}
}
