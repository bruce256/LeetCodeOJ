package tree;


/**
 * https://leetcode.cn/problems/merge-two-binary-trees/description/
 *
 * @author LvSheng
 * @date 2020/2/22
 **/
public class MergeTrees {
	
	public TreeNode mergeTrees0(TreeNode t1, TreeNode t2) {
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
		if ((t1 != null && t1.right != null) || (t2 != null && t2.right != null)) {
			t3.right = new TreeNode(0);
			dfs(t1 == null ? null : t1.right, t2 == null ? null : t2.right, t3.right);
		}
	}
	
	public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
		if (root1 == null) return root2;
		if (root2 == null) return root1;
		
		TreeNode t3 = new TreeNode(root1.val + root2.val);
		t3.left  = mergeTrees(root1.left, root2.left);
		t3.right = mergeTrees0(root1.right, root2.right);
		return t3;
	}
	
}
