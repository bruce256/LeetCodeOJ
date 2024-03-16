package tree;



/**
 * @author lvsheng
 * project LeetCodeOJ
 * date 2016年2月23日
 * time 下午3:57:13
 */
public class BalancedBinaryTree {
	static boolean ok = true;
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		n1.left = n2;
		System.out.println(isBalanced(n1));
	}

	public static boolean isBalanced(TreeNode root) {
        ok = true;
        dfs(root);
        return ok;
    }
	
	public static int dfs(TreeNode root) {
		if(root == null || !ok) return 0;
		int ha = dfs(root.left);
		int hb = dfs(root.right);
		
		if(Math.abs(ha - hb) > 1) ok = false;
		return Math.max(ha, hb) + 1;
	}
}
