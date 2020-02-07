package march;

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
}
