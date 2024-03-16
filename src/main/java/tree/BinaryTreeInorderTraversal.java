package tree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author lvsheng
 *         project LeetCodeOJ
 *         date 2016年2月18日
 *         time 上午10:06:35
 */
public class BinaryTreeInorderTraversal {
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(1);
		n1.left = n2;

		System.out.println(inorderTraversal(n1));
	}

	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		in(root, list);
		return list;
	}

	private void inRecursive(TreeNode root, List<Integer> l) {
		if (root == null)
			return;
		if (root.left != null)
			in(root.left, l);
		l.add(root.val);
		if (root.right != null)
			in(root.right, l);
	}

	private static void in(TreeNode root, List<Integer> l) {
		if (root == null)
			return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode        cur   = root;

		while (!stack.isEmpty() || cur != null) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {
				cur = stack.pop();
				l.add(cur.val);
				cur = cur.right;
			}
		}
	}
}
