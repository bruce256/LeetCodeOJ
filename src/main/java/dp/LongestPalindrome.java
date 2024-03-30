package dp;

/**
 * https://leetcode.cn/problems/longest-palindromic-substring/description/
 *
 * @author LvSheng
 * @date 2024/3/30
 **/
public class LongestPalindrome {
	
	public static void main(String[] args) {
		LongestPalindrome test = new LongestPalindrome();
		System.out.println(test.longestPalindrome("aacabdkacaa"));
		System.out.println(test.longestPalindrome("bbbb"));
		System.out.println(test.longestPalindrome("babad"));
		System.out.println(test.longestPalindrome("cbbd"));
	}
	
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
}
