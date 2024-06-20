package linkedlist;

/**
 * https://leetcode.cn/problems/add-two-numbers/description/
 *
 * @auther: LvSheng
 * @date: 2024/6/20
 * @description:
 */
public class AddTwoNumbers {
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode();
		ListNode pre   = dummy;
		int      carry = 0;
		while (l1 != null || l2 != null || carry > 0) {
			int x    = l1 != null ? l1.val : 0;
			int y    = l2 != null ? l2.val : 0;
			int temp = (x + y + carry) % 10;
			carry = (x + y + carry) / 10;
			ListNode listNode = new ListNode(temp);
			pre.next = listNode;
			pre      = listNode;
			
			if (l1 != null) l1 = l1.next;
			if (l2 != null) l2 = l2.next;
		}
		
		return dummy.next;
	}
}
