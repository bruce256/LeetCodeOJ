package easy;

/**
 * https://leetcode.cn/problems/reverse-words-in-a-string/description/
 *
 */
public class ReverseWords {
	
	public String reverseWords(String s) {
		String[]      array = s.split("\\s+");
		StringBuilder sb    = new StringBuilder();
		for (int i = array.length - 1; i >= 0; i--) {
			if(array[i].length() == 0) continue;
			if (sb.length() == 0) sb.append(array[i]);
			else sb.append(" ").append(array[i]);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		ReverseWords test = new ReverseWords();
		System.out.println(test.reverseWords("  hello world  "));
	}
}
