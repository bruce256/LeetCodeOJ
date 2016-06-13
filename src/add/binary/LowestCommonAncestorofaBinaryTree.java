package add.binary;

/**
 * @auther lvsheng
 * @date 2016年2月24日
 * @time 下午5:25:15
 * @project LeetCodeOJ
 * 
 */
public class LowestCommonAncestorofaBinaryTree {

	static boolean		a	= false;
	static boolean	b = false;
	static TreeNode	ancestor;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		n1.left = n2;
		n2.left = n3;
		n2.right = n4;

		System.out.print(lowestCommonAncestor(n1, n3, n4).val);
	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		a = false;
		b = false;
		ancestor = null;
		dfs(root, p, q);
		return ancestor;
	}

	private static void dfs(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || ancestor != null)
			return;
		dfs(root.left, p, q);
		dfs(root.right, p, q);

		if (root == p)
			a = true;
		else if (root == q)
			b = true;

		if (a && b)
			ancestor = root;
	}
}
