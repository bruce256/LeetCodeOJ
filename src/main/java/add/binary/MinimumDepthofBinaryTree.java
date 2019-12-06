package add.binary;


/**
 * @auther lvsheng
 * @date 2016年2月24日
 * @time 下午4:16:45
 * @project LeetCodeOJ
 * 
 */
public class MinimumDepthofBinaryTree {

	public int minDepth(TreeNode root) {
		if(root == null) return 0;
        return height(root);
    }
	
	private int height(TreeNode root){
		if(root.left == null && root.right == null) return 1;
		else if(root.left == null) return height(root.right) + 1;
		else if(root.right == null) return height(root.left) + 1;
		return Math.min(height(root.left), height(root.right)) + 1;
	}
}
