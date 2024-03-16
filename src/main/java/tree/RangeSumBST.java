package tree;


/**
 * @author LvSheng
 * @date 2020/1/24
 **/
public class RangeSumBST {
	
	public int sum;
	
	public int rangeSumBST(TreeNode root, int L, int R) {
		sum = 0;
		dfs(root, L, R);
		return sum;
	}
	
	private void dfs(TreeNode root, int L, int R) {
		if (root == null) {
			return;
		} else if (root.val >= L && root.val <= R) {
			sum += root.val;
			
			dfs(root.left, L, R);
			dfs(root.right, L, R);
		} else if (root.val < L) {
			dfs(root.right, L, R);
		} else if (root.val > R) {
			dfs(root.left, L, R);
		}
	}
}
