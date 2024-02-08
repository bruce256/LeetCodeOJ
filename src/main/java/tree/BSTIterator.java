package tree;

import java.util.Stack;

/**
 * @author lvsheng
 *         project LeetCodeOJ
 *         date 2016年2月16日
 *         time 下午7:49:25
 */
public class BSTIterator {

	Stack<TreeNode> stack = new Stack<TreeNode>();

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(1);
		n1.left = n2;

		BSTIterator i = new BSTIterator(n1);
		while (i.hasNext())
			System.out.println(i.next());
	}

	public BSTIterator(TreeNode root) {
		stack.clear();
		if (root != null)
			stack.push(root);
	}

	public boolean hasNext() {
		return !stack.isEmpty();
	}

	public int next() {
		TreeNode t = stack.pop();
		while (t != null) {
			stack.push(t);
			t = t.left;
		}
		t = stack.pop();
		int v = t.val;
		if (t.right != null)
			stack.push(t.right);
		return v;
	}

}
