package backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @auther: LvSheng
 * @date: 2024/6/22
 * @description:
 */
public class WordBreak {
	
	public boolean wordBreak(String s, List<String> wordDict) {
		Set<String> set = new HashSet<>(wordDict.size());
		set.addAll(wordDict);
		Set<String> memo = new HashSet<>();
		return backtrack(s, set, memo, 0);
	}
	
	private boolean backtrack(String s, Set<String> set, Set<String> memo, int start) {
		if (start == s.length()) {
			return true;
		}
		
		boolean ok = false;
		for (int i = start + 1; i <= s.length(); i++) {
			String substring = s.substring(start, i);
			if (memo.contains(substring)) continue;
			memo.add(substring);
			if (set.contains(substring)) {
				if (backtrack(s, set, memo, i)) {
					ok = true;
					break;
				}
			}
		}
		return ok;
	}
	
	public static void main(String[] args) {
		WordBreak         test     = new WordBreak();
		ArrayList<String> wordDict = new ArrayList<>();
		/*wordDict.add("leet");
		wordDict.add("code");
		System.out.println(test.wordBreak("leetcode", wordDict));*/
		
		wordDict.add("apple");
		wordDict.add("pen");
		System.out.println(test.wordBreak("leetcode", wordDict));
	}
}
