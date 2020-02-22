package backtrack;


/**
 * @author LvSheng
 * @date 2020/2/21
 **/
public class PathSum2 {
	
	public int pathSum(TreeNode root, int sum) {
		if (root == null) return 0;
		
		int[] array = new int[1000];
		return traversal(root, sum, array, 0);
	}
	
	private int traversal(TreeNode root, int sum, int[] array, int level) {
		if (root == null) return 0;
		
		array[level] = root.val;
		
		int tmp = 0;
		int cnt = 0;
		for (int i = level; i >= 0; i--) {
			tmp += array[i];
			if (tmp == sum) cnt++;
		}
		return cnt +
				traversal(root.left, sum, array, level + 1) +
				traversal(root.right, sum, array, level + 1);
	}
	
	public static void main(String[] args) {
		PathSum2 ps    = new PathSum2();
		TreeNode root  = new TreeNode(3);
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(3);
		root.left = node1;
		node1.left = node2;
		System.out.println(ps.pathSum(root, 6));
	}
}