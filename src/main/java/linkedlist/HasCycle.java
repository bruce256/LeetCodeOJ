package linkedlist;

import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.cn/problems/linked-list-cycle/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * @author 吕胜 lvheng1
 * @date 2024/3/17
 **/
public class HasCycle {
	
	public boolean hasCycle(ListNode head) {
		HashMap<ListNode, Integer> inDegree = new HashMap<>();
		while (head != null) {
			Integer value = inDegree.get(head);
			if (value == null) {
				inDegree.put(head, 1);
			} else {
				return true;
			}
			head = head.next;
		}
		return false;
	}
	
	// 快慢指针
	public boolean hasCycle1(ListNode head) {
		if (head == null) {
			return false;
		}
		ListNode fast = head.next;
		ListNode slow = head;
		
		while (fast != null && fast.next != null) {
			if (fast == slow) {
				return true;
			}
			
			fast = fast.next.next;
			slow = slow.next;
		}
		return false;
		
	}
	
	public ListNode detectCycle(ListNode head) {
		HashMap<ListNode, Integer> inDegree = new HashMap<>();
		while (head != null) {
			Integer value = inDegree.get(head);
			if (value == null) {
				inDegree.put(head, 1);
			} else {
				return head;
			}
			head = head.next;
		}
		return null;
	}
}
