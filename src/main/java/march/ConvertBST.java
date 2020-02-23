package march;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LvSheng
 * @date 2020/2/22
 **/
public class ConvertBST {
	
	int sum = 0;
	
	public TreeNode convertBST(TreeNode root) {
		sum = 0;
		dfs(root, new ArrayList<>());
		return root;
	}
	
	private void dfs(TreeNode root, List<Integer> list) {
		if (root == null) return;
		
		dfs(root.right, list);
		list.add(root.val);
		int sum = list.stream().mapToInt(e -> e).sum();
		root.val = sum;
		dfs(root.left, list);
	}
	
	private void dfs1(TreeNode root) {
		if (root == null) return;
		
		dfs1(root.right);
		sum += root.val;
		root.val = sum;
		dfs1(root.left);
	}
}
