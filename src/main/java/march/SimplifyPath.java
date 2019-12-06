package march;

import java.util.Stack;

/**
 * Created by Administrator on 2016/6/22.
 */
public class SimplifyPath {
	public static void main(String[] args) {
		SimplifyPath sp = new SimplifyPath();
		System.out.println(sp.simplifyPath("/a/./b/../../c/"));
		System.out.println(sp.simplifyPath("/home/"));
		System.out.println(sp.simplifyPath("/../"));
		System.out.println(sp.simplifyPath("/home//foo/"));
	}

	public String simplifyPath(String path) {
		String slash = "/";
		if (path == null) return slash;
		Stack<String> stack = new Stack<String>();
		StringBuilder sb    = new StringBuilder();
		String[]      arr   = path.split(slash);
		for (String s : arr) {
			if ("".equals(s) || ".".equals(s)) continue;
			else if ("..".equals(s)) {
				if (!stack.isEmpty()) stack.pop();
			} else stack.push(s);
		}

		while (!stack.isEmpty()) sb.insert(0, slash + stack.pop());
		return sb.length() == 0 ? slash : sb.toString();
	}
}
