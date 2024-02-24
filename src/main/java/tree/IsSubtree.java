package tree;

/**
 * https://leetcode.com/problems/subtree-of-another-tree/description/
 *
 * @author LvSheng
 * @date 2024/2/24
 **/
public class IsSubtree {
	
	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
		if (root == null) return false;
		if (dfsCompare(root, subRoot)) return true;
		
		return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
	}
	
	public boolean dfsCompare(TreeNode root, TreeNode subRoot) {
		if (root == null && subRoot == null) {
			return true;
		} else if ((root == null && subRoot != null) || (root != null && subRoot == null)) {
			return false;
		} else if (root.val != subRoot.val) {
			return false;
		}
		
		return dfsCompare(root.left, subRoot.left) && dfsCompare(root.right, subRoot.right);
	}
	
}
