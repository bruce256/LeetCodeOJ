package march;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯法求解
 *
 * @author lvsheng
 * @date 2019-03-22
 **/
public class GenerateParentheses {
	
	public static void main(String[] args) {
		GenerateParentheses gp   = new GenerateParentheses();
		List<String>        list = gp.generateParenthesis(3);
		System.out.println(list);
	}
	
	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		recursive(new String(), 0, 0, result, n);
		return result;
	}
	
	public void recursive(String sb, int left, int right, List<String> result, final int n) {
		
		if (right == n) {
			result.add(sb);
			return;
		}
		
		if (left < n) {
			sb += "(";
			recursive(sb, left + 1, right, result, n);
			sb = sb.substring(0, sb.length() - 1);
		}
		
		if (right < left) {
			sb += ")";
			recursive(sb, left, right + 1, result, n);
		}
	}
}
