package march;

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
		if(root == null) return ;
		
		postRecursive(root.left, list);
		postRecursive(root.right, list);
		
		list.add(root.val);
	}
	
}
