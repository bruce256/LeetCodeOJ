package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LvSheng
 * @date 2022/12/25
 **/
public class LetterCombinations {
	
	public static char[][] table = {{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
			{'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
	
	public List<String> letterCombinations(String digits) {
		if (digits.length() == 0) return new ArrayList<>();
		
		List<String> result = new ArrayList<>();
		StringBuffer sb     = new StringBuffer();
		backtrack(result, digits, 0, sb);
		return result;
	}
	
	private void backtrack(List<String> result, String digits, int index, StringBuffer sb) {
		if (index == digits.length()) {
			result.add(sb.toString());
			return;
		}
		
		char[] chars = table[digits.charAt(index) - '0'];
		for (char c : chars) {
			sb.append(c);
			backtrack(result, digits, index + 1, sb);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
	
	public static void main(String[] args) {
		LetterCombinations letterCombinations = new LetterCombinations();
		System.out.println(letterCombinations.letterCombinations("23"));
	}
}
