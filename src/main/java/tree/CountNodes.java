package tree;

/**
 * @author LvSheng
 * @date 2021/10/17
 **/
public class CountNodes {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
}
