package divideAndConquer;

/**
 * https://leetcode.cn/problems/sort-list/
 *
 * @author LvSheng
 * @date 2024/4/20
 **/
public class SortList {
	
	public static void main(String[] args) {
		ListNode head     = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
		SortList sortList = new SortList();
		ListNode listNode = sortList.sortList(head);
		System.out.println(listNode);
	}
	
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode tail = head;
		while (tail.next != null) {
			tail = tail.next;
		}
		return divideAndConquer(head, tail);
	}
	
	private ListNode divideAndConquer(ListNode head, ListNode tail) {
		if (head == tail) {
			// 使它成为一个链表，否则无法合并
			head.next = null;
			return head;
		}
		
		ListNode fast = head.next, slow = head;
		while (fast != tail && fast.next != tail) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		ListNode middle = slow.next;
		ListNode left  = divideAndConquer(head, slow);
		ListNode right = divideAndConquer(middle, tail);
		return mergeTwoLists(left, right);
	}
	
	private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		
		if (l2 == null) {
			return l1;
		}
		
		if (l1.val > l2.val) {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		} else {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		}
	}
}
