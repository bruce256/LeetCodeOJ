package march;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/lru-cache/description/
 * <p>
 * project  : LeetCodeOJ
 * package  : march
 * author   : lvsheng
 * date     : 16/9/6 下午2:20
 */
public class LRUCache {
	
	// 队首是最久没有使用的
//	LinkedList<Integer>      list;
	// 头指针
	LinkedItem head;
	LinkedItem tail;
	
	// 用于检查是否存在及 O(1) 获取元素
	Map<Integer, LinkedItem> map;
	
	int capacity;
	
	public LRUCache(int capacity) {
		head          = new LinkedItem();
		tail          = new LinkedItem();
		head.next     = tail;
		tail.previous = head;
		
		map = new HashMap<>(capacity);
		
		this.capacity = capacity;
	}
	
	public int get(int key) {
		LinkedItem item = map.get(key);
		if (item == null) {
			return -1;
		}
		
		item.remove();
		tailAdd(item);
		
		return item.getValue();
	}
	
	private void tailAdd(LinkedItem item) {
		tail.previous.next = item;
		item.previous      = tail.previous;
		
		item.next     = tail;
		tail.previous = item;
	}
	
	public void put(int key, int value) {
		
		// 若数据已经存在, 则更新结果
		LinkedItem query = map.get(key);
		if (query != null) {
			LinkedItem item = new LinkedItem(key, value);
			map.put(key, item);
			query.remove();
			tailAdd(item);
			return;
		}
		
		// 若数据不存在
		LinkedItem item = new LinkedItem(key, value);
		if (map.size() < capacity) {
			tailAdd(item);
			map.put(key, item);
		} else {
			Integer first = head.next.getKey();
			map.remove(first);
			removeHead();
			
			tailAdd(item);
			map.put(key, item);
		}
	}
	
	private void removeHead() {
		head.next          = head.next.next;
		head.next.previous = head;
	}
	
	
	public static void main(String[] args) {
		int[]    arr = {4, 3, 4, 2, 3, 1, 4, 2};
		LRUCache lru = new LRUCache(3);
		for (int i : arr) {
			lru.put(i, i);
//			System.out.println(JSONArray.toJSONString(lru.getList()));
		}
		LRUCache lru2 = new LRUCache(2);
		lru2.put(2, 1);
		lru2.put(1, 1);
		System.out.println(lru2.get(2));
		lru2.put(4, 1);
		lru2.put(3, 3);
		System.out.println(lru2.get(1));
		System.out.println(lru2.get(2));
		
		TreeMap<Integer, Integer> tm = new TreeMap<>();
		tm.pollFirstEntry();
	}
}

class LinkedItem {
	
	private int        key;
	private int        value;
	public  LinkedItem previous;
	public  LinkedItem next;
	
	public LinkedItem() {
		previous = null;
		next     = null;
	}
	
	public LinkedItem(int key, int value) {
		this.key   = key;
		this.value = value;
	}
	
	public void remove() {
		this.previous.next = this.next;
		this.next.previous = this.previous;
	}
	
	public int getKey() {
		return key;
	}
	
	public LinkedItem setKey(int key) {
		this.key = key;
		return this;
	}
	
	public int getValue() {
		return value;
	}
	
	public LinkedItem setValue(int value) {
		this.value = value;
		return this;
	}
}