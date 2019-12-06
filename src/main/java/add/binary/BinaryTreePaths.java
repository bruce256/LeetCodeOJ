package add.binary;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lvsheng
 *         project LeetCodeOJ
 *         date 2016年2月20日
 *         time 下午3:43:21
 */
public class BinaryTreePaths {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		n1.left = n2;
		n1.right = n3;
		

		System.out.println(binaryTreePaths(n1));
		n2.left = n4;
		System.out.println(binaryTreePaths(n1));
		n2.right = n5;
		System.out.println(binaryTreePaths(n1));
	}

	public static List<String> binaryTreePaths(TreeNode root) {
		List<String> l = new ArrayList<String>();
		dfs(root, new StringBuilder(), l);
		return l;
	}

	private static void dfs(TreeNode root, StringBuilder sb, List<String> l) {
		if(root == null) return;
		int len = sb.length();
		if (root.left == null && root.right == null) {
			l.add(sb.append(root.val).toString());
			sb.delete(len, sb.length());
			return;
		}

		sb.append(root.val).append("->");
		dfs(root.left, sb, l);
		dfs(root.right, sb, l);
		sb.delete(len, sb.length());
	}
}
