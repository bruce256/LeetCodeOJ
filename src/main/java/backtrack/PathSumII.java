package backtrack;


import java.util.ArrayList;
import java.util.List;


/**
 * @author lvsheng
 * project LeetCodeOJ
 * date 2016年2月25日
 * time 下午2:09:37
 */
public class PathSumII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(-2);
		TreeNode n3 = new TreeNode(-3);
		TreeNode n4 = new TreeNode(1);
		TreeNode n5 = new TreeNode(3);
		TreeNode n6 = new TreeNode(-2);
		TreeNode n7 = new TreeNode(-1);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n4.left = n7;
		System.out.print(pathSum(n1, 2));
	}

	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root != null) dfs(root, sum, 0, new ArrayList<Integer>(), result);
		return result;
    }
	
	private static void dfs(TreeNode root, int sum, int s, ArrayList<Integer> path, List<List<Integer>> result) {
		if(root.left == null && root.right == null) {
			if(s + root.val == sum) {
				path.add(root.val);
				result.add((List<Integer>) path.clone());
				path.remove(path.size() - 1);
			}
			return;
		}
		
		path.add(root.val);
		if(root.left != null) dfs(root.left, sum, s + root.val, path, result);
		if(root.right != null) dfs(root.right, sum, s + root.val, path, result);
		path.remove(path.size() - 1);
	}
}
