package tree;

/**
 * @author lvsheng
 *         project LeetCodeOJ
 *         date 2016年2月16日
 *         time 下午2:46:37
 */
public class KthSmallestElementinaBST {
	Integer r = null;
	Integer idx = 0;

	public int kthSmallest(TreeNode root, int k) {
		idx = 0;
		travel(root, k);
		return r.intValue();
	}
	
	void travel(TreeNode root, int k ) {
		if(root == null && r != null) return;
		if(root.left != null)  travel(root.left, k);;
		if(++idx == k) r = root.val;
		if(root.right != null) travel(root.right, k);
	}
}