package divideAndConquer;

/**
 * https://leetcode.cn/problems/convert-sorted-list-to-binary-search-tree/description/
 *
 * @author LvSheng
 * @date 2024/4/5
 **/
public class SortedListToBST {
	
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}
		return dfs(head, null);
	}
	
	private TreeNode dfs(ListNode head, ListNode tail) {
		if (head == tail) {
			return new TreeNode(head.val);
		}
		
		ListNode slow = head;
		ListNode fast = head;
		ListNode pre  = null;
		while (fast != tail && fast.next != tail) {
			fast = fast.next.next;
			pre  = slow;
			slow = slow.next;
		}
		
		TreeNode root = new TreeNode(slow.val);
		if (pre != null) {
			root.left = dfs(head, pre);
		}
		if (slow.next != null) {
			root.right = dfs(slow.next, tail);
		}
		return root;
	}
	
	public static void main(String[] args) {
		SortedListToBST test     = new SortedListToBST();
		TreeNode        treeNode = test.sortedListToBST(new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))))));
		treeNode = test.sortedListToBST(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));
		System.out.println(treeNode);
	}
}

class TreeNode {
	
	int      val;
	TreeNode left;
	TreeNode right;
	
	TreeNode() {
	}
	
	TreeNode(int val) {
		this.val = val;
	}
	
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val   = val;
		this.left  = left;
		this.right = right;
	}
}

