package nowcoder;

import java.util.Scanner;

/**
 * @author LvSheng
 * @date 2020/2/23
 **/
public class LegalIp {
	
	public static void main(String[] args) {
		LegalIp legalIp = new LegalIp();
		Scanner cin     = new Scanner(System.in);
		while (cin.hasNext()) {
			String line = cin.nextLine();
			if (legalIp.isLegal(line)) System.out.println("YES");
			else System.out.println("NO");
		}
	}
	
	public boolean isLegal(String ip) {
		for (int i = 0; i < ip.length(); i++) {
			if (!isDigitOrDot(ip.charAt(i))) return false;
		}
		
		String[] array = ip.split("\\.");
		if (array.length != 4) return false;
		for (int i = 0; i < array.length; i++) {
			int cur = Integer.parseInt(array[i]);
			if (cur > 255) return false;
		}
		
		return true;
	}
	
	private boolean isDigitOrDot(char c) {
		return (c >= '0' && c <= '9') || c == '.';
	}
}
