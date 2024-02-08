package linkedlist;

/**
 * https://leetcode.cn/problems/SLwz0R/
 *
 * @author LvSheng
 * @date 2024/2/8
 **/
public class RemoveNthFromEnd {
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0, head);
		
		int      num = getLength(head);
		ListNode ptr;
		
		int pos = num - n;
		
		ptr = dummy;
		for (int i = 0; i < pos; i++) {
			ptr = ptr.next;
		}
		
		// remove
		ptr.next = ptr.next.next;
		return dummy.next;
	}
	
	private int getLength(ListNode head) {
		int      num = 0;
		ListNode ptr = head;
		while (ptr != null) {
			num++;
			ptr = ptr.next;
		}
		return num;
	}
}
