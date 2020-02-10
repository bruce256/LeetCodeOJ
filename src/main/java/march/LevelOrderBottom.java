package march;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LvSheng
 * @date 2020/2/7
 **/
public class LevelOrderBottom {
	
	List<List<Integer>> result;
	
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		result = new ArrayList<>();
		dfs(root, 0);
		return result;
	}
	
	private void dfs(TreeNode root, int level) {
		if (root == null) return;
		if (result.size() <= level) result.add(new ArrayList<>());
		
		dfs(root.left, level + 1);
		dfs(root.right, level + 1);
		
		result.get(result.size() - level - 1).add(root.val);
	}
}
