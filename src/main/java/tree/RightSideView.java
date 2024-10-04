package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/binary-tree-right-side-view/description/
 *
 * @author LvSheng
 * @date 2024/4/13
 **/
public class RightSideView {
	
	/**
	 * bfs求解
	 *
	 * @param root
	 * @return
	 */
	public List<Integer> rightSideView1(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int      length = queue.size();
			TreeNode last   = new TreeNode();
			for (int i = 0; i < length; i++) {
				last = queue.poll();
				if (last.left != null) queue.add(last.left);
				if (last.right != null) queue.add(last.right);
			}
			list.add(last.val);
		}
		return list;
	}
	
	/**
	 * 深搜求解
	 *
	 * @param root
	 * @return
	 */
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		dfs(root, 0, result);
		return result;
	}
	
	private void dfs(TreeNode root, int depth, List<Integer> result) {
		if (root == null) {
			return;
		}
		
		if (depth >= result.size()) {
			result.add(root.val);
		}
		
		dfs(root.right, depth + 1, result);
		dfs(root.left, depth + 1, result);
	}
}
