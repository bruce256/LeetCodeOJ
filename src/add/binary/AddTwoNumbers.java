package add.binary;

/**
 * @author lvsheng
 *         project LeetCodeOJ
 *         date 2016年2月18日
 *         time 下午7:31:18
 */
public class AddTwoNumbers {

	public static void main(String[] args) {
		addTwoNumbers(new ListNode(5), new ListNode(5));
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		ListNode head = new ListNode(0);
		ListNode pre = head;
		int carry = 0;
		while (l1 != null || l2 != null || carry != 0) {
			int sum = 0;
			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}
			sum += carry;
			carry = sum / 10;

			ListNode cur = new ListNode(sum % 10);
			pre.next = cur;
			pre = cur;
		}
		return head.next;
	}
}

class ListNode {

	int			val;
	ListNode	next;

	ListNode(int x) {
		val = x;
	}
}