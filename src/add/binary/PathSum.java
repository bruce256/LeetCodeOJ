package add.binary;


/**
 * @author lvsheng
 * project LeetCodeOJ
 * date 2016年2月22日
 * time 上午10:00:09
 */
public class PathSum {
	static Boolean ok = false;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(1);
		TreeNode t1 = new TreeNode(2);
		System.out.println(hasPathSum(treeNode, 1));
		System.out.println(hasPathSum(null, 0));
		treeNode.left = t1;
		System.out.println(hasPathSum(treeNode, 1));

	}

	
	public static boolean hasPathSum(TreeNode root, int sum) {
		if(root == null) return false;
		ok = false;
        dfs(root, sum, 0);
        return ok;
    }
	
	public static void dfs(TreeNode root, int sum, int s) {
		if(ok == true) return;
		if(root.left == null && root.right == null) {
			if (s + root.val == sum) {
				ok = true;
			}
			return;
		}
		
		if(root.left != null) dfs(root.left, sum, s + root.val);
		if(root.right != null) dfs(root.right, sum, s + root.val);
	}
}
