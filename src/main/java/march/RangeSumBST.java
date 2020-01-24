package march;


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

class TreeNode {
	
	int      val;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int x) {
		val = x;
	}
	
	Integer in;
	
	public int getVal() {
		return val;
	}
	
	public TreeNode setVal(int val) {
		this.val = val;
		return this;
	}
	
	public TreeNode getLeft() {
		return left;
	}
	
	public TreeNode setLeft(TreeNode left) {
		this.left = left;
		return this;
	}
	
	public TreeNode getRight() {
		return right;
	}
	
	public TreeNode setRight(TreeNode right) {
		this.right = right;
		return this;
	}
}
