package linkedlist;

/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/
 *
 * @author LvSheng
 * @date 2024/2/8
 **/
public class DeleteDuplicates2 {
	
	public ListNode deleteDuplicates(ListNode head) {
		ListNode dummy = new ListNode(0, head);
		ListNode left  = dummy;
		ListNode right = dummy.next;
		while (right != null) {
			while (right.next != null && left.next.val == right.next.val) {
				right = right.next;
			}
			
			left.next = right.next;
		}
		return null;
	}
}
