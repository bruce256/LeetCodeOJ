package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * @author LvSheng
 * @date 2021/10/17
 **/
public class LargestValues {
	
	public List<Integer> largestValues(TreeNode root) {
		if (root == null) {
			return Collections.emptyList();
		}
		List<Integer>   result = new ArrayList<>();
		Queue<TreeNode> nodes  = new LinkedList<>();
		nodes.add(root);
		while (!nodes.isEmpty()) {
			int length = nodes.size();
			int max    = Integer.MIN_VALUE;
			for (int i = 0; i < length; i++) {
				TreeNode top = nodes.poll();
				if (top.val > max) {
					max = top.val;
				}
				if (top.left != null) {
					nodes.add(top.left);
				}
				if (top.right != null) {
					nodes.add(top.right);
				}
			}
			result.add(max);
		}
		return result;
	}
}


class TreeNode {
	
	int      val;
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