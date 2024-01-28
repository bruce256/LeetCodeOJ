package tree;


/**
 * https://leetcode.com/problems/sum-of-left-leaves/
 *
 * @author LvSheng
 * @date 2024/1/28
 **/
public class SumOfLeftLeaves {
	
	private int sum;
	
	public int sumOfLeftLeaves(TreeNode root) {
		sum = 0;
		dfs(root, false);
		return sum;
	}
	
	private void dfs(TreeNode root, boolean isLeft) {
		if (root == null) return;
		
		dfs(root.left, true);
		if (isLeft && root.left == null && root.right == null) {
			sum += root.val;
		}
		dfs(root.right, false);
	}
}
