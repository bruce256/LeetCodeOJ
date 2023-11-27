package tree;

/**
 * https://leetcode.cn/problems/same-tree/description/?envType=study-plan-v2&envId=top-interview-150
 *
 * @author 吕胜 lvheng1
 * @date 2023/11/27
 **/
public class IsSameTree {
	
	private boolean result;
	
	public boolean isSameTree(TreeNode p, TreeNode q) {
		result = true;
		dfs(p, q);
		return result;
	}
	
	private void dfs(TreeNode p, TreeNode q) {
		if (p == null && q == null) return;
		if ((p == null || q == null) || p.val != q.val) {
			result = false;
			return;
		}
		
		dfs(p.left, q.left);
		dfs(p.right, q.right);
	}
}
