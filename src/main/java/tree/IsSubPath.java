package tree;


/**
 * dfs， 考察了两个数据结构
 * https://leetcode.cn/problems/linked-list-in-binary-tree/description/
 *
 * @author LvSheng
 * @date 2024/3/3
 **/
public class IsSubPath {
	
	public boolean isSubPath(ListNode head, TreeNode root) {
		if (root == null) {
			return false;
		}
		return dfsCompare(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
	}
	
	boolean dfsCompare(ListNode head, TreeNode root) {
		if (head == null) return true;
		if (root == null) return false;
		
		if (head.val != root.val) return false;
		
		return dfsCompare(head.next, root.left) || dfsCompare(head.next, root.right);
	}
	
	public static void main(String[] args) {
		IsSubPath test = new IsSubPath();
		ListNode  head = new ListNode(4, new ListNode(2, new ListNode(8)));
		TreeNode  root = new TreeNode(1, new TreeNode(4, null, new TreeNode(2)), new TreeNode(4, new TreeNode(2, new TreeNode(6), new TreeNode(8)), null));
		System.out.println(test.isSubPath(head, root));
		
		head = new ListNode(1, new ListNode(4, new ListNode(2, new ListNode(6))));
		System.out.println(test.isSubPath(head, root));
	}
}


class ListNode {
	
	int      val;
	ListNode next;
	
	ListNode() {
	}
	
	ListNode(int val) {
		this.val = val;
	}
	
	ListNode(int val, ListNode next) {
		this.val  = val;
		this.next = next;
	}
}
