package linkedlist;

/**
 * https://leetcode.cn/problems/middle-of-the-linked-list/
 *
 * @author LvSheng
 * @date 2024/2/9
 **/
public class MiddleNode {
	
	public ListNode middleNode(ListNode head) {
		if (head == null || head.next == null) return head;
		
		ListNode fast = head.next;
		ListNode slow = head;
		
		while (fast != null) {
			if (fast.next != null && fast.next.next != null) {
				fast = fast.next.next;
				slow = slow.next;
			} else if (fast.next != null && fast.next.next == null) {
				slow = slow.next;
				break;
			} else if (fast.next == null) {
				slow = slow.next;
				break;
			}
		}
		
		return slow;
	}
}
