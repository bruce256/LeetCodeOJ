package linkedlist;

/**
 * https://leetcode.cn/problems/reverse-linked-list-ii/description/
 *
 * @author LvSheng
 * @date 2024/3/12
 **/
public class ReverseBetween {
	
	public ListNode reverseBetween(ListNode head, int left, int right) {
		if (left == right) {
			return head;
		}
		
		ListNode pre = new ListNode(0, head);
		ListNode h = pre;
		
		for (int i = 1; i < left; i++) {
			pre = pre.next;
		}
		
		ListNode tail = pre.next;
		ListNode cur  = tail.next;
		ListNode next = null;
		for (int i = 0; i < (right - left ); i++) {
			next     = cur.next;
			cur.next = pre.next;
			pre.next = cur;
			
			// 指向下一个反转的节点
			cur      = next;
		}
		tail.next = next;
		return h.next;
	}
	
	public static void main(String[] args) {
		
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		
		ReverseBetween test = new ReverseBetween();
		test.reverseBetween(l1, 2, 4);
		ListNode head = new ListNode(3, new ListNode(5));
		test.reverseBetween(head, 1,2);
	}
}
