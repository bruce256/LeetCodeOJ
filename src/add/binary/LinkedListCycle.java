package add.binary;

/**
 * @author lvsheng
 *         project LeetCodeOJ
 *         date 2016年2月18日
 *         time 下午8:04:13
 */
public class LinkedListCycle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean hasCycle(ListNode head) {
		if (head == null)
			return false;
		ListNode p1 = head, p2 = head;
		while (p1 != null && p2 != null) {
			p1 = p1.next;
			if (p2.next != null)
				p2 = p2.next.next;
			else {
				return false;
			}
			if (p1 == p2 && p1 != null)
				return true;
		}
		return false;
	}

}
