package march;

import java.io.PipedReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LvSheng
 * @date 2020/2/7
 **/
public class FindBottomLeftValue {
	
	public int findBottomLeftValue(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int bl = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode tn = queue.poll();
				if (i == 0) {
					bl = tn.val;
				}
				if (tn.left != null) queue.add(tn.left);
				if (tn.right != null) queue.add(tn.right);
			}
		}
		
		return bl;
	}
	
	int maxLevel = 0;
	int bl;
	
	public int findBottomLeftValue1(TreeNode root) {
		bl = root.val;
		maxLevel = 0;
		dfs(root, 1);
		return bl;
	}
	
	private void dfs(TreeNode root, int level) {
		if (root == null) return;
		
		if (level > maxLevel && (root.left != null || root.right != null)) {
			maxLevel = level;
			if (root.left != null) bl = root.left.val;
			else bl = root.right.val;
		}
		
		dfs(root.left, level + 1);
		dfs(root.right, level + 1);
	}
}
