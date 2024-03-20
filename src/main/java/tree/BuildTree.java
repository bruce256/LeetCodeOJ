package tree;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * @author LvSheng
 * @date 2024/3/19
 **/
public class BuildTree {
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0) {
			return null;
		}
		
		TreeNode root   = new TreeNode(preorder[0]);
		int      length = 0;
		for (; length < inorder.length; length++) {
			if (inorder[length] == preorder[0]) {
				break;
			}
		}
		root.left  = buildTree(Arrays.copyOfRange(preorder, 1, 1 + length), Arrays.copyOfRange(inorder, 0, length));
		root.right = buildTree(Arrays.copyOfRange(preorder, 1 + length, preorder.length), Arrays.copyOfRange(inorder, length + 1, inorder.length));
		return root;
	}
	
	public static void main(String[] args) {
		BuildTree test     = new BuildTree();
		TreeNode  treeNode = test.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
		System.out.println(treeNode.val);
	}
}
