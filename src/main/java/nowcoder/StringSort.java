package nowcoder;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author LvSheng
 * @date 2020/2/20
 **/
public class StringSort {
	
	int delta = 'a' - 'A';
	
	public String sort(String input) {
		Map<Character, String>            map    = new HashMap<>();
		LinkedHashMap<Integer, Character> posMap = new LinkedHashMap<>();
		
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (isHigher(c)) {
				map.compute(c, (key, value) -> {
					if (value == null) value = "";
					value = value + c;
					return value;
				});
			} else if (isLower(c)) {
				map.compute((char) (c - delta), (key, value) -> {
					if (value == null) value = "";
					value = value + c;
					return value;
				});
			} else {
				posMap.put(i, c);
			}
		}
		
		StringBuffer sb = new StringBuffer(input.length());
		
		for (char c = 'A'; c <= 'Z'; c++) {
			if (map.get(c) != null) sb.append(map.get(c));
		}
		
		posMap.entrySet().stream().forEach(e -> {
			sb.insert(e.getKey().intValue(), e.getValue());
		});
		
		return sb.toString();
	}
	
	private boolean isLower(char c) {
		return (c >= 'a' && c <= 'z');
	}
	
	private boolean isHigher(char c) {
		return (c >= 'A' && c <= 'Z');
	}
	
	public static void main(String[] args) {
		StringSort stringSort = new StringSort();
		Scanner    cin        = new Scanner(System.in);
		while (cin.hasNext()) {
			String line = cin.nextLine();
			System.out.println(stringSort.sort(line));
		}
	}
}
