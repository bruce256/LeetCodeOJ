package tree;



/**
 * @author lvsheng
 * project LeetCodeOJ
 * date 2016年2月19日
 * time 下午4:18:31
 */
public class SumRoottoLeafNumbers {

	static int sum = 0;
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(9);
		TreeNode n2 = new TreeNode(1);
		n1.left = n2;

		System.out.println(sumNumbers(n1));
	}

	public static int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        sum = 0;
        dfs(root, 0);
        return sum;
    }
	
	private static void dfs(TreeNode root, int parent) {
		if(root.left == null && root.right == null) {
			sum += (parent * 10 + root.val);
			return;
		}
		parent = parent * 10 + root.val;
		if(root.left != null)	dfs(root.left, parent);
		if(root.right != null)	dfs(root.right, parent);
	}
}
