package tree;

/**
 * https://leetcode.cn/problems/maximum-depth-of-n-ary-tree/
 *
 * @author LvSheng
 * @date 2024/4/14
 **/
public class MaxDepth {
	
	public int maxDepth(Node root) {
		if (root == null) {
			return 0;
		}
		
		if (root.children == null || root.children.size() == 0) {
			return 1;
		}
		int max = 0;
		for (Node child : root.children) {
			max = Math.max(max, maxDepth(child));
		}
		
		return max + 1;
	}
}
