package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/symmetric-tree/description/
 *
 * @author LvSheng
 * @date 2024/2/11
 **/
public class IsSymmetric {
	
	public boolean isSymmetric(TreeNode root) {
		Queue<TreeNode> leftQueue  = new LinkedList<>();
		Queue<TreeNode> rightQueue = new LinkedList<>();
		leftQueue.add(root);
		rightQueue.add(root);
		
		while (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
			TreeNode left  = leftQueue.poll();
			TreeNode right = rightQueue.poll();
			
			if (left == null && right == null) {
				continue;
			}
			
			if (left == null || right == null) {
				return false;
			}
			
			if (left.val != right.val) {
				return false;
			}
			
			leftQueue.add(left.left);
			leftQueue.add(left.right);
			
			rightQueue.add(right.right);
			rightQueue.add(right.left);
		}
		
		if (leftQueue.isEmpty() && rightQueue.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		Integer i = 10;
		IsSymmetric test = new IsSymmetric();
		test.isSymmetric(new TreeNode(3));
	}
}
