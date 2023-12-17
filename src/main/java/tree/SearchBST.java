package tree;

/**
 * https://leetcode.cn/problems/search-in-a-binary-search-tree/description/?envType=study-plan-v2&envId=leetcode-75
 *
 * @author 吕胜 lvheng1
 * @date 2023/12/17
 **/
public class SearchBST {
	
	
	public TreeNode searchBST1(TreeNode root, int val) {
		while (root != null) {
			if (val == root.val) return root;
			if (val > root.val) {
				root = root.right;
			} else {
				root = root.left;
			}
		}
		
		return null;
	}
	
	public TreeNode searchBST(TreeNode root, int val) {
		if (root == null) return null;
		if (root.val == val) return root;
		
		if (val > root.val) return searchBST(root.right, val);
		else return searchBST(root.left, val);
	}
	
	
}
