package tree;

/**
 * https://leetcode.com/problems/invert-binary-tree/
 *
 * @author LvSheng
 * @date 2024/2/25
 **/
public class InvertTree {
	
	public TreeNode invertTree(TreeNode root) {
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
}
