package divideAndConquer;

/**
 * https://leetcode.cn/problems/maximum-binary-tree/
 *
 * @author LvSheng
 * @date 2024/4/21
 **/
public class ConstructMaximumBinaryTree {
	
	public static void main(String[] args) {
		ConstructMaximumBinaryTree test     = new ConstructMaximumBinaryTree();
		TreeNode                   treeNode = test.constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
		System.out.println(treeNode);
	}
	
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		return divideAndConquer(nums, 0, nums.length - 1);
	}
	
	private TreeNode divideAndConquer(int[] nums, int left, int right) {
		if (left > right) {
			return null;
		}
		if (left == right) {
			return new TreeNode(nums[left]);
		}
		
		int maxIdx = left;
		for (int i = left; i <= right; i++) {
			if (nums[i] > nums[maxIdx]) {
				maxIdx = i;
			}
		}
		TreeNode root = new TreeNode(nums[maxIdx]);
		
		root.left  = divideAndConquer(nums, left, maxIdx - 1);
		root.right = divideAndConquer(nums, maxIdx + 1, right);
		return root;
	}
}
