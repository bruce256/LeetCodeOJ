import java.util.ArrayList;
import java.util.List;

/**
 * @author LvSheng
 * @date 2022/12/24
 **/
public class RemoveNodes {
	
	/**
	 * 超时
	 *
	 * @param head
	 * @return
	 */
	public ListNode removeNodes(ListNode head) {
		List<Integer> list    = new ArrayList<>();
		ListNode      current = head;
		while (current != null) {
			list.add(current.val);
			current = current.next;
		}
		ListNode HeadPtr = new ListNode();
		HeadPtr.next = head;
		current = head;
		ListNode previous = HeadPtr;
		int      index    = 1;
		while (current != null) {
			boolean hit = false;
			
			for (int i = index; i < list.size(); i++) {
				if (list.get(i) > current.val) {
					previous.next = current.next;
					hit = true;
					break;
				}
			}
			
			index++;
			if (!hit) {
				previous = previous.next;
			}
			current = current.next;
		}
		
		return HeadPtr.next;
	}
	
	public ListNode removeNodes1(ListNode head) {
		List<Integer> list    = new ArrayList<>();
		ListNode      current = head;
		while (current != null) {
			list.add(current.val);
			current = current.next;
		}
		
		List<ListNode> result = new ArrayList<>();
		int index = list.size() - 1;
		int max = list.get(index);
		for (; index >=0; index --) {
			if(list.get(index) >= max) {
				result.add(new ListNode(list.get(index)));
				max = list.get(index);
			}
		}
		
		for (int i = result.size() - 1; i >0 ; i--) {
			result.get(i).next = result.get(i - 1);
		}
		return result.get(result.size() - 1);
	}
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(5);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(13);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(8);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		RemoveNodes removeNodes = new RemoveNodes();
		ListNode    listNode    = removeNodes.removeNodes1(n1);
		System.out.println(listNode);
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
		this.val = val;
		this.next = next;
	}
}
