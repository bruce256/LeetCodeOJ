package add.binary;


/**
 * @author lvsheng
 * project LeetCodeOJ
 * date 2016年2月23日
 * time 下午6:22:52
 */
public class ValidateBinarySearchTree {
	boolean ok = true;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isValidBST(TreeNode root) {
        ok = true;
        dfs(root);
        return ok;
    }
	
	private void dfs(TreeNode root) {
		if(root == null || !ok) return;
		dfs(root.left);
		dfs(root.right);
		
		if(root.left != null) ok = root.left.val < root.val;
		if(root.right != null) ok = root.right.val > root.val;
	}

}
