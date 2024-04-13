package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/minimum-window-substring/
 *
 * @author LvSheng
 * @date 2020/1/29
 **/
public class MinWindow {
	
	public String minWindow(String s, String t) {
		if (t.length() > s.length()) return "";
		
		int    left   = 0;
		int    right  = t.length();
		String result = "";
		
		Map<Character, Integer> source = new HashMap<>();
		Map<Character, Integer> target = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			target.compute(t.charAt(i), (k, v) -> v == null ? 1 : ++v);
			source.compute(s.charAt(i), (k, v) -> v == null ? 1 : ++v);
		}
		
		while (left != s.length()) {
			String tmp = s.substring(left, right);
			if (contains(source, target)) {
				if ("".equals(result)) result = tmp;
				else if (result.length() > tmp.length()) result = tmp;
				
				source.compute(s.charAt(left), (k, v) -> --v);
				left++;
			} else if (right < s.length()) {
				source.compute(s.charAt(right), (k, v) -> v == null ? 1 : ++v);
				right++;
			} else {
				source.compute(s.charAt(left), (k, v) -> --v);
				left++;
			}
		}
		
		return result;
	}
	
	private boolean contains(Map<Character, Integer> source, Map<Character, Integer> target) {
		for (Map.Entry<Character, Integer> entry : target.entrySet()) {
			if (source.get(entry.getKey()) == null
					|| source.get(entry.getKey()) < entry.getValue()) return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		MinWindow mw = new MinWindow();
		//System.out.println(mw.minWindow("ADOBECODEBANC", "ABC"));
		System.out.println(mw.minWindow("zzb", "zzb"));
	}
}
