package add.binary;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


/**
 * @author lvsheng
 * project LeetCodeOJ
 * date 2016年2月19日
 * time 下午2:35:11
 */
public class BinaryTreeRightSideView {

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(1);
		n1.left = n2;

		System.out.println(rightSideView(n1));
	}
	public static List<Integer> rightSideView(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if(root == null) return list;
		Queue<TreeNode> queue = new  ArrayDeque<TreeNode>();
		queue.add(root);
		queue.add(new TreeNode(Integer.MIN_VALUE));
		if(root.left != null) queue.add(root.left);
		if(root.right != null) queue.add(root.right);
		TreeNode pre = queue.poll();
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			if(cur.val == Integer.MIN_VALUE) {
				list.add(pre.val);
				if(!queue.isEmpty()) queue.add(new TreeNode(Integer.MIN_VALUE));
			} else {
				if(cur.left != null) queue.add(cur.left);
				if(cur.right != null) queue.add(cur.right);
				pre = cur;
			}
		}
		return list;
        
    }
}
