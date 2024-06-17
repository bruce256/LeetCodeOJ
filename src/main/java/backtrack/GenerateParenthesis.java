package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/generate-parentheses/description/
 *
 * @auther: LvSheng
 * @date: 2024/6/17
 * @description:
 */
public class GenerateParenthesis {
	
	public List<String> generateParenthesis(int n) {
		List<String>  result = new ArrayList<>();
		StringBuilder sb     = new StringBuilder();
		backtrack(result, 0, 0, sb, n);
		return result;
	}
	
	/**
	 * 每次递归分两个方向，左子树加 (, 右子树加 ), 画出递归解答树即可
	 *
	 * @param result
	 * @param left
	 * @param right
	 * @param cur
	 * @param max
	 */
	private void backtrack(List<String> result, int left, int right, StringBuilder cur, int max) {
		if (cur.length() == 2 * max) {
			result.add(cur.toString());
			return;
		}
		
		if (left < max) {
			cur.append('(');
			backtrack(result, left + 1, right, cur, max);
			cur.deleteCharAt(cur.length() - 1);
		}
		
		if (right < left) {
			cur.append(')');
			backtrack(result, left, right + 1, cur, max);
			cur.deleteCharAt(cur.length() - 1);
		}
	}
	
	public static void main(String[] args) {
		GenerateParenthesis test = new GenerateParenthesis();
		System.out.println(test.generateParenthesis(3));
	}
}
