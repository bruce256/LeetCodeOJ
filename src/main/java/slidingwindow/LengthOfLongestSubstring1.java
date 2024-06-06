package slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
 * 参考网上的模板
 */
public class LengthOfLongestSubstring1 {
	
	public static void main(String[] args) {
		LengthOfLongestSubstring test = new LengthOfLongestSubstring();
		System.out.println(test.lengthOfLongestSubstring("dvdf"));
		System.out.println(test.lengthOfLongestSubstring("au"));
		System.out.println(test.lengthOfLongestSubstring("pwwkew"));
		System.out.println(test.lengthOfLongestSubstring("abcabcbb"));
		System.out.println(test.lengthOfLongestSubstring("bbbbb"));
	}
	
	public int lengthOfLongestSubstring(String s) {
		if (s.length() <= 1) return s.length();
		
		int left   = 0;
		int right  = 1;
		int result = 1;
		
		Set<Character> set = new HashSet<>(128);
		
		set.add(s.charAt(left));
		while (right <= s.length()) {
			// 条件成立则右指针右移，窗口扩张
			if (!set.contains(s.charAt(right))) {
				set.add(s.charAt(right));
				right++;
				result = Math.max(result, right - left);
			} else {
				// 条件不成立则左指针右移，窗口收缩
				set.remove(s.charAt(left));
				left++;
			}
		}
		
		return result;
	}
}
