package tree;


import java.util.ArrayList;
import java.util.List;

/**
 * @author LvSheng
 * @date 2020/2/11
 **/
public class Preorder {
	
	public List<Integer> preorder(Node root) {
		List<Integer> list = new ArrayList<>();
		dfs(root, list);
		return list;
	}
	
	private void dfs(Node root, List<Integer> list) {
		if (root == null) return;
		
		list.add(root.val);
		
		if (root.children == null || root.children.isEmpty()) return;
		
		for (int i = 0; i < root.children.size(); i++) {
			dfsPost(root.children.get(i), list);
		}
	}
	
	public List<Integer> postorder(Node root) {
		List<Integer> list = new ArrayList<>();
		dfsPost(root, list);
		return list;
	}
	
	private void dfsPost(Node root, List<Integer> list) {
		if (root == null) return;
		
		if (root.children != null && !root.children.isEmpty()) {
			for (int i = 0; i < root.children.size(); i++) {
				dfs(root.children.get(i), list);
			}
		}
		
		list.add(root.val);
	}
	
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		postRecursive(root, list);
		return list;
	}
	
	private void postRecursive(TreeNode root, List<Integer> list) {
		if (root == null) return;
		
		postRecursive(root.left, list);
		postRecursive(root.right, list);
		
		list.add(root.val);
	}
	
	
	int mp = 0;
	
	public int maxDepth(Node root) {
		mp = 0;
		if (root == null) return 0;
		recursive(root, 1);
		return mp;
	}
	
	private void recursive(Node root, int level) {
		
		if (root == null) {
			return;
		}
		
		mp = Math.max(mp, level);
		
		if (root == null || root.children.isEmpty()) return;
		
		for (int i = 0; i < root.children.size(); i++) recursive(root.children.get(i), level + 1);
	}
}

class Node {
	
	public int              val;
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
