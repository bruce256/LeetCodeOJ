package linkedlist;

/**
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/
 *
 * @author LvSheng
 * @date 2024/3/31
 **/
public class ReverseKGroup {
	
	public ListNode reverseKGroup(ListNode head, int k) {
		if (k <= 1 || head == null) {
			return head;
		}
		
		ListNode dummy = new ListNode(0, head);
		
		ListNode ptr = dummy;
		while (ptr != null) {
			int      i    = 0;
			ListNode left = ptr;
			for (; i < k && ptr != null; i++) {
				ptr = ptr.next;
			}
			
			if (i == k && ptr != null) {
				ptr = reverse(left, ptr.next);
			} else {
				break;
			}
		}
		
		return dummy.next;
	}
	
	private ListNode reverse(ListNode dummy, ListNode tail) {
		ListNode ptr  = dummy.next.next;
		ListNode head = dummy.next;
		while (ptr != tail) {
			ListNode next = ptr.next;
			ptr.next   = dummy.next;
			dummy.next = ptr;
			
			ptr = next;
		}
		
		head.next = tail;
		return head;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		ReverseKGroup test = new ReverseKGroup();
		ListNode listNode = test.reverseKGroup(head, 3);
		System.out.println(listNode);
		
	}
}
