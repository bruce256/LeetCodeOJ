package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/maximum-level-sum-of-a-binary-tree/?envType=study-plan-v2&envId=leetcode-75
 *
 * @author 吕胜 lvheng1
 * @date 2023/12/17
 **/
public class MaxLevelSum {
	
	public int maxLevelSum(TreeNode root) {
		int max    = Integer.MIN_VALUE;
		int level  = 1;
		int result = 0;
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			int sum  = 0;
			for (int i = 0; i < size; i++) {
				TreeNode poll = queue.poll();
				sum += poll.val;
				if (poll.left != null) queue.add(poll.left);
				if (poll.right != null) queue.add(poll.right);
			}
			if (sum > max) {
				max    = sum;
				result = level;
			}
			level++;
		}
		return result;
	}
}
