package add.binary;


/**
 * @auther lvsheng
 * @date 2016年2月24日
 * @time 下午4:08:59
 * @project LeetCodeOJ
 * 
 */
public class MaximumDepthofBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxDepth(TreeNode root) {
        return height(root);
    }
	
	private int height(TreeNode root){
		if(root == null) return 0;
		return Math.max(height(root.left), height(root.right)) + 1;
	}
}
