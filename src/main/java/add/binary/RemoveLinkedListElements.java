package add.binary;

/**
 * @author lvsheng
 *         project LeetCodeOJ
 *         date 2016年2月20日
 *         time 下午3:08:00
 */
public class RemoveLinkedListElements {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode h = new ListNode(1);
		ListNode h1 = new ListNode(1);
		h.next = h1;
		System.out.print(removeElements(h, 1));
	}

	public static ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return null;
		}

		ListNode h = new ListNode(0);
		h.next = head; // 仅作为标志作用的头指针
		ListNode pre = h;

		while (head != null) {
			if (head.val == val) {
				pre.next = head.next;
			} else {
				pre = pre.next;
			}
			head = head.next;

		}
		return h.next;
	}
}
