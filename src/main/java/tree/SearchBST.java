package tree;

/**
 * https://leetcode.cn/problems/search-in-a-binary-search-tree/description/?envType=study-plan-v2&envId=leetcode-75
 *
 * @author 吕胜 lvheng1
 * @date 2023/12/17
 **/
public class SearchBST {
	
	TreeNode result = null;
	
	public TreeNode searchBST(TreeNode root, int val) {
		result = null;
		dfs(root, val);
		return result;
	}
	
	public void dfs(TreeNode root, int target) {
		if (root == null) return;
		
		dfs(root.left, target);
		if (root.val == target) result = root;
		dfs(root.right, target);
	}
}
