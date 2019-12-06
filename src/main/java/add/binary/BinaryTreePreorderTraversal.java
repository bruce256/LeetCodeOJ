package add.binary;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * @author lvsheng
 * project LeetCodeOJ
 * date 2016年2月22日
 * time 下午2:30:02
 */
public class BinaryTreePreorderTraversal {
	
	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
			while (cur != null) {
				list.add(cur.val);
				if(cur.right != null) stack.add(cur.right);
				cur = cur.left;
			}
			if(!stack.isEmpty()) cur = stack.pop();
		}
        return list;
    }

}
