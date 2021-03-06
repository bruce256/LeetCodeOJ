package march;

/**
 * @author LvSheng
 * @date 2020/1/27
 **/
public class MergeTwoLists {
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode l3   = head;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				l3.next = l1;
				l1 = l1.next;
			} else {
				l3.next = l2;
				l2 = l2.next;
			}
			l3 = l3.next;
			l3.next = null;
		}
		if (l1 != null) l3.next = l1;
		if (l2 != null) l3.next = l2;
		
		return head.next;
	}
}
