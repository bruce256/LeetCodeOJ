package march;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author LvSheng
 * @date 2020/1/29
 **/
public class LargestValues {
	
	public List<Integer> largestValues(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		dfs(root, list, 0);
		return list;
	}
	
	private void dfs(TreeNode root, List<Integer> list, int level) {
		if (root == null) {
			return;
		}
		
		if (list.size() <= level) {
			list.add(level, root.val);
		} else if (list.get(level) < root.val) {
			list.set(level, root.val);
		}
		
		dfs(root.left, list, level + 1);
		dfs(root.right, list, level + 1);
	}
	
	public List<Integer> largestValues1(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null) return list;
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			int max  = Integer.MIN_VALUE;
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (node.val > max) max = node.val;
				if (node.left != null) queue.add(node.left);
				if (node.right != null) queue.add(node.right);
			}
			list.add(max);
		}
		return list;
	}
}

class TreeNode {
	int           val;
	TreeNode left;
	TreeNode right;
	
	TreeNode() {
	}
	
	TreeNode(int val) {
		this.val = val;
	}
	
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val   = val;
		this.left  = left;
		this.right = right;
	}
}
