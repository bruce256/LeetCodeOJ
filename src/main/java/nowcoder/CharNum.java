package nowcoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author LvSheng
 * @date 2020/2/19
 **/
public class CharNum {
	
	public static void main(String[] args) {
		Scanner cin    = new Scanner(System.in);
		String  string = cin.nextLine();
		String  target = cin.nextLine();
		
		String                  str = string.toLowerCase();
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			map.compute(str.charAt(i), (key, value) -> {
				if (value == null) value = 1;
				else ++value;
				return value;
			});
		}
		target = target.toLowerCase();
		Integer cnt = map.get(target.charAt(0));
		if(cnt == null) cnt = 0;
		System.out.println(cnt);
	}
}
