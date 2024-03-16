package linkedlist;


/**
 * @author lvsheng
 *         project LeetCodeOJ
 *         date 2016年2月20日
 *         time 下午5:12:21
 */
public class SwapNodesinPairs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode h  = new ListNode(1);
		ListNode h2 = new ListNode(2);
		ListNode h3 = new ListNode(3);
		ListNode h4 = new ListNode(4);
		h.next = h2;
		h2.next = h3;
		h3.next = h4;
		System.out.print(swapPairs(h));
	}

	public static ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode h = new ListNode(0);
		h.next = head;
		ListNode pre = h, p1 = head, p2 = head.next;
		while (p1 != null && p2 != null) {
			// swap
			pre.next = p2;
			p1.next = p2.next;
			p2.next = p1;

			// 指针后移
			pre = p1;
			p1 = p1.next;
			if (p1 != null)
				p2 = p1.next;
		}
		return h.next;
	}

}
