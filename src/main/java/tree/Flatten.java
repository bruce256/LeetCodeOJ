package tree;

/**
 * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/?envType=study-plan-v2&envId=top-100-liked
 *
 * @author LvSheng
 * @date 2024/2/5
 **/
public class Flatten {
	
	TreeNode pre;
	
	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}
		pre = null;
		dfs(root);
	}
	
	public void dfs(TreeNode root) {
		TreeNode right = root.right;
		TreeNode left  = root.left;
		root.right = left;
		root.left  = null;
		
		if (pre != null) {
			pre.right = root;
		}
		pre = root;
		
		if (left != null) {
			dfs(left);
		}
		if (right != null) {
			dfs(right);
		}
	}
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		t1.left  = t2;
		t1.right = t3;
		
		Flatten test = new Flatten();
		test.flatten(t1);
		System.out.println(t1.right);
	}
}
