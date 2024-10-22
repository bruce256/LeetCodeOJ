package tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://leetcode.com/problems/invert-binary-tree/
 *
 * @author LvSheng
 * @date 2024/2/25
 **/
public class InvertTree {
	
	public TreeNode invertTree0(TreeNode root) {
		if (root == null) {
			return null;
		}
		
		TreeNode tmp = root.left;
		root.left  = root.right;
		root.right = tmp;
		
		invertTree(root.left);
		invertTree(root.right);
		
		return root;
	}
	
	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		
		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);
		
		while (!queue.isEmpty()) {
			TreeNode top = queue.poll();
			swap(top);
			
			if (top.left != null) {
				queue.add(top.left);
			}
			
			if (top.right != null) {
				queue.add(top.right);
			}
		}
		
		return root;
	}
	
	private void swap(TreeNode root) {
		TreeNode tmp = root.left;
		root.left  = root.right;
		root.right = tmp;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
		InvertTree test = new InvertTree();
		test.invertTree(root);
	}
}
