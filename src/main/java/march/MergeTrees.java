package march;

/**
 * @author LvSheng
 * @date 2020/2/22
 **/
public class MergeTrees {
	
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null) return null;
		
		TreeNode t3 = new TreeNode(0);
		dfs(t1, t2, t3);
		return t3;
	}
	
	private void dfs(TreeNode t1, TreeNode t2, TreeNode t3) {
		if (t1 == null && t2 == null) return;
		
		if (t1 != null && t2 != null) {
			t3.val = t1.val + t2.val;
		} else if (t1 == null && t2 != null) {
			t3.val = t2.val;
		} else if (t1 != null && t2 == null) {
			t3.val = t1.val;
		}
		
		if ((t1 != null && t1.left != null) || (t2 != null && t2.left != null)) {
			t3.left = new TreeNode(0);
			dfs(t1 == null ? null : t1.left, t2 == null ? null : t2.left, t3.left);
		}
		if ((t1 != null && t1.right != null) || (t2 != null && t2.right != null)	) {
			t3.right = new TreeNode(0);
			dfs(t1 == null ? null : t1.right, t2 == null ? null : t2.right, t3.right);
		}
	}
}
