package add.binary;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;


/**
 * @author lvsheng
 * project LeetCodeOJ
 * date 2016年2月25日
 * time 上午11:22:01
 */
public class EvaluateReversePolishNotation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] a = {"0","3","/"};
		System.out.println(evalRPN(a));
		String[] b = {"3","-4","+"};
		System.out.println(evalRPN(b));
	}
	
	public static int evalRPN(String[] tokens) {
		if(tokens.length == 0) return 0;
		if(tokens.length == 1) return Integer.parseInt(tokens[0]);
		Set<Character> set = new HashSet<Character>();
		set.add('+');
		set.add('-');
		set.add('*');
		set.add('/');
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < tokens.length; i++) {
			if(tokens[i].length() == 1 && set.contains(tokens[i].charAt(0))) {
				int b = stack.pop();
				int a = stack.pop();
				switch (tokens[i].charAt(0)) {
					case '+':
						stack.add(a + b);
						break;
					case '-':
						stack.add(a - b);
						break;
					case '*':
						stack.add(a * b);
						break;
					case '/':
						stack.add(a / b);
						break;

					default:
						break;
				}
			}else  stack.add(Integer.parseInt(tokens[i]));
		} 
        return stack.peek();
    }
}
