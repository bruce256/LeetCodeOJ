package tree;


import apple.laf.JRSUIUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @auther lvsheng
 * @date 2016年2月24日
 * @time 下午5:25:15
 * @project LeetCodeOJ
 */
public class LowestCommonAncestorofaBinaryTree {
	
	static boolean  a = false;
	static boolean  b = false;
	static TreeNode ancestor;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode                          n1   = new TreeNode(3, new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))), new TreeNode(1, new TreeNode(0), new TreeNode(8)));
		LowestCommonAncestorofaBinaryTree test = new LowestCommonAncestorofaBinaryTree();
		test.lowestCommonAncestor(n1, n1, n1.left);
		test.lowestCommonAncestor(n1, n1.left, n1.right);
	}
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		Map<TreeNode, TreeNode> parentMap = new HashMap<>();
		dfs(root, parentMap);
		parentMap.put(root, null);
		
		Set<TreeNode> set    = new HashSet<>();
		TreeNode      parent = null;
		while (p != null) {
			set.add(p);
			
			parent = parentMap.get(p);
			p      = parent;
		}
		
		while (!set.contains(q)) {
			parent = parentMap.get(q);
			q      = parent;
		}
		
		return q;
	}
	
	private void dfs(TreeNode root, Map<TreeNode, TreeNode> parentMap) {
		if (root == null) {
			return;
		}
		
		if (root.left != null) {
			parentMap.put(root.left, root);
			dfs(root.left, parentMap);
		}
		
		if (root.right != null) {
			parentMap.put(root.right, root);
			dfs(root.right, parentMap);
		}
	}
}
