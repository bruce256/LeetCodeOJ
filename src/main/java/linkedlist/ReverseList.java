package linkedlist;

/**
 * @author LvSheng
 * @date 2020/1/28
 **/
public class ReverseList {
	
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) return head;
		
		ListNode p1 = head.next;
		ListNode p2 = p1.next;
		head.next = null;
		while (p2 != null) {
			p1.next = head;
			head    = p1;
			
			p1 = p2;
			p2 = p2.next;
		}
		
		p1.next = head;
		return p1;
	}
	
	
	public ListNode reverseList2(ListNode head) {
		ListNode pre = null;
		ListNode cur = head;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
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
		
		ReverseList reverseList = new ReverseList();
		reverseList.reverseList2(l1);
	}
}
