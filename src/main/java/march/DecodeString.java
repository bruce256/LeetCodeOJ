package march;


import java.util.Stack;

/**
 * @author LvSheng
 * @date 2020/1/22
 **/
public class DecodeString {
	
	public String decodeString(String s) {
		Stack<String>  stringStack  = new Stack<>();
		Stack<Integer> integerStack = new Stack<>();
		StringBuilder  result       = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= '0' && c <= '9') {
				if (i > 0) {
					// 解析大数字
					char left = s.charAt(i - 1);
					if (left >= '0' && left <= '9') {
						int tmpNum = integerStack.pop();
						tmpNum = (tmpNum * 10 + (c - '0'));
						integerStack.push(tmpNum);
					} else {
						integerStack.push(c - '0');
					}
				} else {
					integerStack.push(c - '0');
				}
			} else if (c == '[') {
			
			} else if (isChar(c)) {
				if (!integerStack.empty()) {
					if ((i > 0 && isChar(s.charAt(i - 1)))
							// 只有左括号数和字符串栈的数量一样，才是字符串连接
							|| integerStack.size() == stringStack.size()) {
						String tmp = stringStack.pop();
						stringStack.push(tmp + new Character(c).toString());
					} else {
						stringStack.push(new Character(c).toString());
					}
				} else {
					result.append(c);
				}
			} else if (c == ']') {
				int           num    = integerStack.pop();
				String        tmpStr = stringStack.pop();
				StringBuilder sb     = new StringBuilder();
				for (int j = 0; j < num; j++) {
					sb.append(tmpStr);
				}
				
				// 嵌套括号
				if (!integerStack.empty()) {
					// 只有左括号数和字符串栈的数量一样，才是字符串连接
					if (!stringStack.empty() && stringStack.size() == integerStack.size()) {
						stringStack.push(stringStack.pop() + sb.toString());
					} else {
						stringStack.push(sb.toString());
					}
				} else {
					result.append(sb.toString());
				}
			}
			
		}
		return result.toString();
	}
	
	private boolean isChar(char c) {
		return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
	}
	
	
	private String dfs(String s, int pos, boolean[] visited) {
		int num = 0;
		while (s.charAt(pos) != '[') {
			num = num * 10 + (s.charAt(pos) - '0');
			visited[pos] = true;
			pos++;
		}
		visited[pos] = true;
		pos++;
		
		StringBuilder sb = new StringBuilder();
		while(!visited[pos]) {
			char c = s.charAt(pos);
			visited[pos] = true;
			if (c >= '0' && c <= '9') {
				sb.append(dfs(s, pos, visited)).toString();
			} else if (isChar(c)) {
				sb.append(c);
			} else if (c == ']') {
				break;
			}
			pos++;
		}
		
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < num; i++) {
			result.append(sb.toString());
		}
		return result.toString();
	}
	
	public String decodeString2(String s) {
		char          c;
		StringBuilder sb      = new StringBuilder();
		boolean[]     visited = new boolean[s.length()];
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if (c <= '9' && c >= '0') {
				sb.append(dfs(s, i, visited));
				for (int j = 0; j < visited.length; j++) {
					if (visited[j]) {
						i = j;
					}
				}
			} else {
				sb.append(c);
			}
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		DecodeString ds = new DecodeString();
		//System.out.println(ds.decodeString("3[a]2[bc]"));
//		System.out.println(ds.decodeString("2[2[y]pq4[2[jk]e1[f]]]ef"));
//		System.out.println(ds.decodeString("3[a]2[b4[F]c]"));
//		System.out.println(ds.decodeString("3[a10[c]]"));
//		System.out.println(ds.decodeString("2[abc]3[cd]ef"));
		
		
//		System.out.println(ds.decodeString2("3[a]2[bc]"));
//		System.out.println(ds.decodeString2("2[2[y]pq4[2[jk]e1[f]]]ef"));
//		System.out.println(ds.decodeString2("3[a]2[b4[F]c]"));
		System.out.println(ds.decodeString2("3[a10[c]]"));
		System.out.println(ds.decodeString2("2[abc]3[cd]ef"));
		
		
	}
}
