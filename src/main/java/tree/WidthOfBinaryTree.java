package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 吕胜 lvheng1
 * @date 2024/1/7
 **/
public class WidthOfBinaryTree {
	
	public int widthOfBinaryTree(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		dfs(root, 0, list);
		Integer max = Collections.max(list);
		return max;
	}
	
	private void dfs(TreeNode root, int level, List<Integer> list) {
		if (level > list.size()) list.add(0);
		list.set(level, list.get(level) + 1);
		
		if (root.left != null) dfs(root.left, level + 1, list);
		if (root.right != null) dfs(root.right, level + 1, list);
		
	}
}
