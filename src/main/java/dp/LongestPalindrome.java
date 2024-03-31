package dp;

import javax.print.attribute.standard.ReferenceUriSchemesSupported;

/**
 * https://leetcode.cn/problems/longest-palindromic-substring/description/
 *
 * @author LvSheng
 * @date 2024/3/30
 **/
public class LongestPalindrome {
	
	public static void main(String[] args) {
		LongestPalindrome test = new LongestPalindrome();
		System.out.println(test.longestPalindrome1("aacabdkacaa"));
		System.out.println(test.longestPalindrome1("bbbb"));
		System.out.println(test.longestPalindrome1("babad"));
		System.out.println(test.longestPalindrome1("cbbd"));
	}
	
	/**
	 * dp算法
	 *
	 * @param s
	 * @return
	 */
	public String longestPalindrome(String s) {
		int     length = s.length();
		int[][] dp     = new int[length][length];
		
		for (int i = 0; i < length; i++) {
			dp[i][i] = 1;
		}
		
		int left = 0, maxLen = 1;
		for (int len = 2; len <= length; len++) {
			for (int i = 0; i + len <= length; i++) {
				if (s.charAt(i) == s.charAt(i + len - 1)) {
					if (len == 2) {
						dp[i][i + len - 1] = 2;
					} else if (dp[i + 1][i + len - 2] > 0) {
						dp[i][i + len - 1] = 2 + dp[i + 1][i + len - 2];
					}
					
					if (dp[i][i + len - 1] > maxLen) {
						maxLen = dp[i][i + len - 1];
						left   = i;
					}
				}
				
			}
		}
		
		return s.substring(left, left + maxLen);
	}
	
	/**
	 * 中心扩展算法
	 *
	 * @param s
	 * @return
	 */
	public String longestPalindrome1(String s) {
		int left = 0;
		int max  = 1;
		
		for (int i = 0; i < s.length(); i++) {
			MaxWindow maxWindow = calcMax(s, i - 1, i + 1);
			if (maxWindow.max > max) {
				max  = maxWindow.max;
				left = maxWindow.left;
			}
			
			if ((i + 1 < s.length()) && s.charAt(i) == s.charAt(i + 1)) {
				maxWindow = calcMax(s, i - 1, i + 2);
				if (maxWindow.max > max) {
					max  = maxWindow.max;
					left = maxWindow.left;
				}
			}
		}
		return s.substring(left, left + max);
	}
	
	private MaxWindow calcMax(String s, int left, int right) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		MaxWindow result = new MaxWindow();
		result.left = left + 1;
		result.max  = right - left - 1;
		return result;
	}
}

class MaxWindow {
	
	public int left;
	public int max;
}