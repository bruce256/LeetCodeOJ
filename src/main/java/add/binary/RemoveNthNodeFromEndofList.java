package add.binary;

/**
 * @author lvsheng
 *         project LeetCodeOJ
 *         date 2016年2月20日
 *         time 下午2:28:05
 */
public class RemoveNthNodeFromEndofList {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(n == 0) return head;
		
		ListNode p1 = head, p2 = head;
		ListNode h = new ListNode(0);
		h.next = head;	//仅作为标志作用的头指针
		ListNode pre = h;
		
		for (int i = 0; i < n; i++) {
			p2 = p2.next;
		}
		
		while(p2 !=null) {
			pre = p1;
			p1 = p1.next;
			p2 = p2.next;
		}
		
		pre.next = p1.next;  // remove
		
		return h.next;
	}
}
