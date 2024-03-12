package march;

/**
 * Created by Administrator on 2016/6/15.
 */
public class RotateList {
	public static void main(String[] args) {
		ListNode h = new ListNode(1);
		h.next = null;
		rotateRight(h, 1);
	}

	public static ListNode rotateRight(ListNode head, int k) {
		if (head == null) return null;

		ListNode h = new ListNode(0);
		h.next = head;
		ListNode p1 = h, p2 = h, p = h;

		int len = 0;
		while (p.next != null) {
			p = p.next;
			len++;
		}
		k %= len;
		if (k == 0) return head;

		for (int i = 0; i < k; i++) p2 = p2.next;
		while (p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}

		h.next = p1.next;
		p2.next = head;
		p1.next = null;
		return h.next;
	}
}

class ListNode {
	int      val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
