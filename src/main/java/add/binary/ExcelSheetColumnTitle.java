package add.binary;

/**
 * @author lvsheng
 *         project LeetCodeOJ
 *         date 2016年2月17日
 *         time 下午2:18:45
 */
public class ExcelSheetColumnTitle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(convertToTitle(1));
		System.out.println(convertToTitle(28));
		System.out.println(convertToTitle(26));
		System.out.println(convertToTitle(53));
	}

	public static String convertToTitle(int n) {
		StringBuilder sb = new StringBuilder();
		while (n != 0) {
			int m = n % 26;
			n /= 26;
			if (m == 0) {
				n--;
				sb.insert(0, (char) ('Z'));
			} else
				sb.insert(0, (char) ('A' + m - 1));
		}
		return sb.toString();
	}
}
