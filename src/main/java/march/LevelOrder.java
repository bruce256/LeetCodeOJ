package march;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LvSheng
 * @date 2020/2/11
 **/
public class LevelOrder {
	
	public List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> result = new ArrayList<>();
		dfs(root, result, 0);
		return result;
	}
	
	private void dfs(Node root, List<List<Integer>> result, int level) {
		if (root == null) return;
		
		if (level >= result.size()) result.add(new ArrayList<>());
		result.get(level).add(root.val);
		
		if (root.children == null || root.children.isEmpty()) return;
		
		for (int i = 0; i < root.children.size(); i++) {
			dfs(root.children.get(i), result, level + 1);
		}
	}
}


class Node {
	
	public int        val;
	public List<Node> children;
	
	public Node() {
	}
	
	public Node(int _val) {
		val = _val;
	}
	
	public Node(int _val, List<Node> _children) {
		val = _val;
		children = _children;
	}
};