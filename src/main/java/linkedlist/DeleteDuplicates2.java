package linkedlist;

/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/
 *
 * @author LvSheng
 * @date 2024/2/8
 **/
public class DeleteDuplicates2 {
	
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return head;
		}
		
		ListNode dummy = new ListNode(0, head);
		ListNode pre   = dummy;
		ListNode left  = head;
		ListNode right = head.next;
		
		while (right != null) {
			while (right != null && left.val == right.val) {
				right = right.next;
			}
			
			if (left.next != right) {
				pre.next = right;
				left     = right;
				if (right != null) {
					right = right.next;
				}
			} else {
				pre   = left;
				left  = right;
				right = right.next;
			}
		}
		
		return dummy.next;
	}
}
