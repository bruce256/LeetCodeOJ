package dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.cn/problems/word-break/description/
 *
 * @auther: LvSheng
 * @date: 2024/6/22
 * @description:
 */
public class WordBreak {
	
	public boolean wordBreak(String s, List<String> wordDict) {
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		
		Set<String> set = new HashSet<>();
		for (String word : wordDict) {
			set.add(word);
		}
		
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && set.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		
		return dp[s.length()];
	}
	
	public static void main(String[] args) {
		WordBreak         test     = new WordBreak();
		ArrayList<String> wordDict = new ArrayList<>();
		wordDict.add("leet");
		wordDict.add("code");
		System.out.println(test.wordBreak("leetcode", wordDict));
	}
}
