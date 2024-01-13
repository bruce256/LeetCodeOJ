import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/remove-comments/description/
 *
 * @author 吕胜 lvheng1
 * @date 2024/1/13
 **/
public class RemoveComments {
	
	public List<String> removeComments(String[] source) {
		List<String>  list         = new ArrayList<>();
		boolean       blockComment = false;
		StringBuilder sb           = new StringBuilder();
		for (String s : source) {
			for (int i = 0; i < s.length(); i++) {
				if (i != s.length() - 1) {
					if (s.charAt(i) == '/' && s.charAt(i + 1) == '/' && !blockComment) {
						break;
					}
					if (s.charAt(i) == '/' && s.charAt(i + 1) == '*' && !blockComment) {
						blockComment = true;
						i++;
						continue;
					}
					if (blockComment && s.charAt(i) == '*' && s.charAt(i + 1) == '/') {
						i++;
						blockComment = false;
						continue;
					}
				}
				
				if (!blockComment) {
					sb.append(s.charAt(i));
				}
			}
			if (!blockComment && sb.length() > 0) {
				list.add(sb.toString());
				sb = new StringBuilder();
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		RemoveComments test = new RemoveComments();
		List<String>   list = test.removeComments(new String[]{"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"});
		for (String s : list) {
			System.out.println(s);
		}
		list = test.removeComments(new String[]{"a/*comment", "line", "more_comment*/b"});
		for (String s : list) {
			System.out.println(s);
		}
	}
}
