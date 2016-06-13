/**
 * 
 */
package march;

/**
 * @auther lvsheng
 * @date 2016年3月1日
 * @time 下午7:08:20
 * @project LeetCodeOJ
 * 
 */

public class ExcelSheetColumnNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(titleToNumber("AB"));

	}

	public static int titleToNumber(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int sum = 0;
		for(int i=0; i<s.length(); i++) {
			sum = sum * 26 + (s.charAt(i) - 'A' + 1);
		}
		
		return sum;
	}

}
