package linkedlist;


/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list/description/
 *
 * @author 吕胜 lvheng1
 * @date 2024/1/11
 **/
public class DeleteDuplicates {
	
	public static void main(String[] args) {
		DeleteDuplicates test = new DeleteDuplicates();
		ListNode         h1   = new ListNode(1);
		ListNode         h2   = new ListNode(1);
		ListNode         h3   = new ListNode(2);
		h1.next = h2;
		h2.next = h3;
		ListNode listNode = test.deleteDuplicates(h1);
		System.out.println(listNode);
	}
	
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) return head;
		
		ListNode start = head;
		ListNode end   = head.next;
		while (end != null) {
			if (start.val == end.val) {
				end = end.next;
			} else if (start.next == end) {
				start = end;
				end   = end.next;
			} else {
				start.next = end;
				start      = end;
				end        = start.next;
			}
		}
		
		if (end == null && start.next != null) {
			start.next = null;
		}
		return head;
	}
}

class ListNode {
	
	int      val;
	ListNode next;
	
	ListNode() {
	}
	
	ListNode(int val) {
		this.val = val;
	}
	
	ListNode(int val, ListNode next) {
		this.val  = val;
		this.next = next;
	}
}
