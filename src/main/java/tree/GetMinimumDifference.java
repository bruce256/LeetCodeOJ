package tree;

/**
 * @author LvSheng
 * @date 2021/10/18
 **/
public class GetMinimumDifference {
    private Integer min;
    private Integer pre;

    public int getMinimumDifference(TreeNode root) {
        min = Integer.MAX_VALUE;
        pre = null;
        dfs(root);

        return min;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre == null) {
            pre = root.val;
        } else if (Math.abs(root.val - pre) < min) {
            min = Math.abs(root.val - pre);
        }
        pre = root.val;
        dfs(root.right);
    }
}
