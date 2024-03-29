import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
 *
 * @author LvSheng
 * @date 2024/3/29
 **/
public class LengthOfLongestSubstring {
	
	public static void main(String[] args) {
		LengthOfLongestSubstring test = new LengthOfLongestSubstring();
		System.out.println(test.lengthOfLongestSubstring("dvdf"));
		System.out.println(test.lengthOfLongestSubstring("au"));
		System.out.println(test.lengthOfLongestSubstring("pwwkew"));
		System.out.println(test.lengthOfLongestSubstring("abcabcbb"));
		System.out.println(test.lengthOfLongestSubstring("bbbbb"));
	}
	
	public int lengthOfLongestSubstring(String s) {
		if (s.length() <= 1) {
			return s.length();
		}
		
		HashMap<Character, Integer> window = new HashMap<>();
		
		int left  = 0;
		int right = 1;
		int max   = 1;
		window.put(s.charAt(left), left);
		while (right < s.length()) {
			char next = s.charAt(right);
			if (window.get(next) != null) {
				max = Math.max(max, window.size());
				
				// 更新窗口
				int idx = window.get(next);
				for (int i = left; i <= idx; i++) {
					window.remove(s.charAt(i));
				}
				left = idx + 1;
			} else {
				// 窗口右移
				window.put(next, right);
				right++;
			}
		}
		max = Math.max(max, window.size());
		return max;
	}
}
