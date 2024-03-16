package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LvSheng
 * @date 2023/10/18
 **/
public class FindSubstring {
	
	List<Integer> result;
	StringBuilder sb;
	
	public List<Integer> findSubstring(String s, String[] words) {
		result = new ArrayList<>();
		sb     = new StringBuilder();
		int depth = 0;
		return null;
	}
	
	private void dfs(String s, String[] words, int depth) {
		for (int i = 0; i < words.length; i++) {
			sb.append(words[i]);
			dfs(s, words, depth + 1);
			
		}
	}
}
