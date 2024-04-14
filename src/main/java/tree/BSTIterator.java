package tree;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/binary-search-tree-iterator/description/
 *
 * @author lvsheng
 * project LeetCodeOJ
 * date 2016年2月16日
 * time 下午7:49:25
 */
public class BSTIterator {
	
	TreeNode        cur   = null;
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
		cur = root;
	}
	
	public boolean hasNext() {
		return !stack.isEmpty() || cur != null;
	}
	
	public int next() {
		while (cur != null) {
			stack.push(cur);
			cur = cur.left;
		}
		TreeNode tmp = stack.pop();
		int      v   = tmp.val;
		if (tmp.right != null) {
			cur = tmp.right;
		}
		return v;
	}
	
}
