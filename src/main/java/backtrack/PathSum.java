package backtrack;


/**
 * @author LvSheng
 * @date 2020/2/21
 **/
public class PathSum {
	
	private int total = 0;
	
	public int pathSum(TreeNode root, int sum) {
		if (root == null) return 0;
		
		total = 0;
		traversal(root, sum);
		return total;
	}
	
	private void traversal(TreeNode root, int sum) {
		if (root == null) return;
		
		dfs(root, sum, 0);
		
		traversal(root.left, sum);
		traversal(root.right, sum);
	}
	
	private void dfs(TreeNode root, int sum, int current) {
		if (root == null) {
			return;
		}
		
		if (current + root.val == sum) total++;
		
		dfs(root.left, sum, current + root.val);
		dfs(root.right, sum, current + root.val);
	}
	
	public static void main(String[] args) {
		PathSum  ps    = new PathSum();
		TreeNode root  = new TreeNode(3);
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(3);
		root.left = node1;
		node1.left = node2;
		System.out.println(ps.pathSum(root, 6));
	}
}

class TreeNode {
	
	int      val;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int x) {
		val = x;
	}
}
