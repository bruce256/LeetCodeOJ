package easy;

/**
 * https://leetcode.cn/problems/add-strings/
 *
 * @auther: LvSheng
 * @date: 2024/6/19
 * @description:
 */
public class AddStrings {
	
	public String addStrings(String num1, String num2) {
		int i = num1.length() - 1;
		int j = num2.length() - 1;
		
		StringBuilder sb  = new StringBuilder();
		int           jin = 0;
		while (i >= 0 && j >= 0) {
			int x = num1.charAt(i) - '0';
			int y = num2.charAt(j) - '0';
			sb.append((x + y + jin) % 10);
			jin = (x + y + jin) / 10;
			i--;
			j--;
		}
		
		if (i >= 0) {
			while (i >= 0) {
				int x = num1.charAt(i) - '0';
				sb.append((x + jin) % 10);
				jin = (x + jin) / 10;
				i--;
			}
			if(jin > 0) sb.append(jin);
		} else {
			while (j >= 0) {
				int x = num2.charAt(j) - '0';
				sb.append((x + jin) % 10);
				jin = (x + jin) / 10;
				j--;
			}
			if(jin > 0) sb.append(jin);
		}
		return sb.reverse().toString();
	}
	
	public static void main(String[] args) {
		AddStrings test = new AddStrings();
		System.out.println(test.addStrings("11", "123"));
		System.out.println(test.addStrings("77", "456"));
		System.out.println(test.addStrings("0", "0"));
	}
}
