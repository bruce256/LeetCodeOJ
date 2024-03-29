package tree;

/**
 * https://leetcode.com/problems/balanced-binary-tree/description/
 *
 * @author LvSheng
 * @date 2024/2/13
 **/
public class IsBalanced {
	
	public boolean isBalanced(TreeNode root) {
		if (root == null) return true;
		
		return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
	}
	
	private int height(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		return Math.max(height(root.left), height(root.right)) + 1;
	}
}
