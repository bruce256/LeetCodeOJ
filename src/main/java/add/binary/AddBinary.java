package add.binary;

/**
 * @auther lvsheng
 * @date 2016年2月15日
 * @time 上午11:37:23
 * @project LeetCodeOJ
 * 
 */
public class AddBinary {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(addBinary("101", "101"));

	}

	public static String addBinary(String a, String b) {
		a = new StringBuilder(a).reverse().toString();
		b = new StringBuilder(b).reverse().toString();
		int la = a.length();
		int lb = b.length();
		int max = la > lb ? la : lb;
		StringBuilder r = new StringBuilder();
		int carry = 0;
		for (int i = 0; i < max; i++) {
			int t = 0;
			if (i < la && i < lb) {
				t = a.charAt(i) - '0' + b.charAt(i) - '0' + carry;
			} else if (i < la) {
				t = a.charAt(i) + carry - '0';
			} else if (i < lb) {
				t = b.charAt(i) + carry - '0';
			}
			switch (t) {
				case 0:
					r.append("0");
					carry = 0;
					break;
				case 1:
					r.append("1");
					carry = 0;
					break;
				case 2:
					r.append("0");
					carry = 1;
					break;
				case 3:
					r.append("1");
					carry = 1;
					break;

				default:
					break;
			}
		}
		if (carry == 1)
			r.append("1");
		return r.reverse().toString();
	}
}
