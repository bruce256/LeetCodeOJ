package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/isomorphic-strings/description/
 *
 * @author LvSheng
 * @date 2023/10/16
 **/
public class IsIsomorphic {
	
	public static void main(String[] args) {
		IsIsomorphic isIsomorphic = new IsIsomorphic();
		System.out.println(isIsomorphic.isIsomorphic("badc", "baba"));
		System.out.println(isIsomorphic.isIsomorphic("egg", "add"));
		System.out.println(isIsomorphic.isIsomorphic("foo", "bar"));
		System.out.println(isIsomorphic.isIsomorphic("paper", "title"));
		System.out.println(isIsomorphic.isIsomorphic("a", "e"));
	}
	
	public boolean isIsomorphic(String s, String t) {
		Map<Character, Character> map = new HashMap<>();
		map.put(s.charAt(0), t.charAt(0));
		
		int length = s.length();
		for (int i = 1; i < length; i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				if (t.charAt(i) != map.get(c)) {
					return false;
				}
			} else if (!map.containsKey(c)) {
				if (map.containsValue(t.charAt(i))) {
					return false;
				}
				map.put(c, t.charAt(i));
			}
		}
		return true;
	}
}
