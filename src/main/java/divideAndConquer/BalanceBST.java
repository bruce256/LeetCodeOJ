package divideAndConquer;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/balance-a-binary-search-tree/description/
 *
 * @author LvSheng
 * @date 2024/4/21
 **/
public class BalanceBST {
	
	public static void main(String[] args) {
		TreeNode   root     = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4))));
		BalanceBST test     = new BalanceBST();
		TreeNode   treeNode = test.balanceBST(root);
		System.out.println(treeNode);
	}
	
	public TreeNode balanceBST(TreeNode root) {
		List<TreeNode> list = new ArrayList<>();
		dfs(root, list);
		for (TreeNode treeNode : list) {
			treeNode.left  = null;
			treeNode.right = null;
		}
		return divideAndConquer(list, 0, list.size() - 1);
	}
	
	private void dfs(TreeNode root, List<TreeNode> list) {
		if (root == null) {
			return;
		}
		
		dfs(root.left, list);
		list.add(root);
		dfs(root.right, list);
	}
	
	private TreeNode divideAndConquer(List<TreeNode> list, int left, int right) {
		if (left > right) {
			return null;
		}
		if (left == right) {
			return list.get(left);
		}
		
		int      middle = (left + right) / 2;
		TreeNode root   = list.get(middle);
		root.left  = divideAndConquer(list, left, middle - 1);
		root.right = divideAndConquer(list, middle + 1, right);
		return root;
	}
	
}
