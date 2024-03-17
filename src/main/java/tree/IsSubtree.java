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
	
	public boolean isSubtree1(TreeNode root, TreeNode subRoot) {
		StringBuilder s1 = new StringBuilder();
		StringBuilder s2 = new StringBuilder();
		dfsString(root, s1);
		dfsString(subRoot, s2);
		return s1.toString().contains(s2.toString());
	}
	
	public void dfsString(TreeNode root, StringBuilder sb) {
		if (root == null) {
			return;
		}
		sb.append(root.val + "");
		
		dfsString(root.left, sb);
		dfsString(root.right, sb);
	}
}
