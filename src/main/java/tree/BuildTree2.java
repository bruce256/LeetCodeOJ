package tree;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 *
 * @author LvSheng
 * @date 2024/3/20
 **/
public class BuildTree2 {
	
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (postorder.length == 0) {
			return null;
		}
		
		int      rootVal = postorder[postorder.length - 1];
		TreeNode root    = new TreeNode(rootVal);
		int      length  = 0;
		for (; length < inorder.length; length++) {
			if (inorder[length] == rootVal) {
				break;
			}
		}
		root.left  = buildTree(Arrays.copyOfRange(inorder, 0, length), Arrays.copyOfRange(postorder, 0, length));
		root.right = buildTree(Arrays.copyOfRange(inorder, length + 1, inorder.length), Arrays.copyOfRange(postorder, length, postorder.length - 1));
		return root;
		
	}
}
