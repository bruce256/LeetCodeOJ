package slidingwindow;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/permutation-in-string/
 * 固定窗口时间算法
 */
public class CheckInclusion {
	
	public boolean checkInclusion(String s1, String s2) {
		int len1 = s1.length();
		int len2 = s2.length();
		if (len1 > len2) return false;
		
		int[] window1 = new int[26];
		int[] window2 = new int[26];
		
		for (int i = 0; i < len1; i++) {
			window1[s1.charAt(i) - 'a']++;
			window2[s2.charAt(i) - 'a']++;
		}
		
		if (Arrays.equals(window1, window2)) return true;
		
		for (int i = len1; i < len2; i++) {
			window2[s2.charAt(i) - 'a']++;
			window2[s2.charAt(i - len1) - 'a']--;
			if (Arrays.equals(window1, window2)) return true;
		}
		return false;
	}
}
