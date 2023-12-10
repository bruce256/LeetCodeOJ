package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 吕胜 lvheng1
 * @date 2023/11/29
 **/
public class AverageOfLevels {
	
	public List<Double> averageOfLevels(TreeNode root) {
		List<Double>    result = new ArrayList<>();
		Queue<TreeNode> queue  = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			double size    = queue.size();
			long sum = 0;
			for (int i = 0; i < size; i++) {
				TreeNode treeNode = queue.poll();
				if (treeNode.left != null) queue.add(treeNode.left);
				if (treeNode.right != null) queue.add(treeNode.right);
				sum += treeNode.val;
			}
			result.add(sum / size);
		}
		return result;
	}
}
