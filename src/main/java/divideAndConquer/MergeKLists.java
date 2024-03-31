package divideAndConquer;

/**
 * https://leetcode.cn/problems/merge-k-sorted-lists/description/
 *
 * @author LvSheng
 * @date 2024/3/31
 **/
public class MergeKLists {
	
	public static void main(String[] args) {
		MergeKLists test = new MergeKLists();
		// [[1,4,5],[1,3,4],[2,6]]
		ListNode listNode = test.mergeKLists(new ListNode[]{new ListNode(1, new ListNode(4, new ListNode(5))),
				new ListNode(1, new ListNode(3, new ListNode(4))),
				new ListNode(2, new ListNode(6))});
		System.out.println(listNode);
	}
	
	public ListNode mergeKLists(ListNode[] lists) {
		return divide(lists, 0, lists.length - 1);
	}
	
	public ListNode divide(ListNode[] lists, int left, int right) {
		if (left == right) {
			return lists[left];
		}
		if (left > right) {
			return null;
		}
		
		int      mid = (left + right) / 2;
		ListNode l   = divide(lists, left, mid);
		ListNode r   = divide(lists, mid + 1, right);
		return mergeTwoLists(l, r);
	}
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
