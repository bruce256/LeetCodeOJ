package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/description/
 *
 * @author 吕胜 lvheng1
 * @date 2023/11/16
 **/
public class IsValidBST {
	
	public boolean isValidBST(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		dfs(root, list);
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i - 1) >= list.get(i)) return false;
		}
		return true;
	}
	
	private void dfs(TreeNode root, List<Integer> list) {
		if (root == null) return;
		dfs(root.left, list);
		list.add(root.val);
		dfs(root.right, list);
	}
}
