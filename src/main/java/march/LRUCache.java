package march;


import java.util.LinkedList;
import java.util.TreeMap;

/**
 * project  : LeetCodeOJ
 * package  : march
 * author   : lvsheng
 * date     : 16/9/6 下午2:20
 */
public class LRUCache {
	
	LinkedList<Item> list = new LinkedList<>();
	int              capacity;
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
	}
	
	public int get(int key) {
		if (list.size() == 0) return -1;
		int i = 0;
		for (; i < list.size(); i++) {
			if (list.get(i).getKey() == key) break;
		}
		if (i < list.size()) {
			Item item = list.get(i);
			list.remove(i);
			list.add(item);
			return item.getValue();
		}
		return -1;
	}
	
	public void set(int key, int value) {
		int i = 0;
		for (; i < list.size(); i++) {
			if (list.get(i).getKey() == key) break;
		}
		if (i < list.size()) {
			list.remove(i);
			list.add(new Item(key, value));
			return;
		}
		
		if (list.size() < capacity) {
			list.add(new Item(key, value));
		} else {
			list.removeFirst();
			list.add(new Item(key, value));
		}
	}
	
	public LinkedList<Item> getList() {
		return list;
	}
	
	public static void main(String[] args) {
		int[]    arr = {4, 3, 4, 2, 3, 1, 4, 2};
		LRUCache lru = new LRUCache(3);
		for (int i : arr) {
			lru.set(i, i);
//			System.out.println(JSONArray.toJSONString(lru.getList()));
		}
		LRUCache lru2 = new LRUCache(2);
		lru2.set(2, 1);
		lru2.set(1, 1);
		System.out.println(lru2.get(2));
		lru2.set(4, 1);
		System.out.println(lru2.get(1));
		System.out.println(lru2.get(2));
		
		TreeMap<Integer, Integer> tm = new TreeMap<>();
		tm.pollFirstEntry();
	}
}

class Item {
	
	private int key;
	private int value;
	
	public Item() {
	}
	
	public Item(int key, int value) {
		this.key = key;
		this.value = value;
	}
	
	
	public int getKey() {
		return key;
	}
	
	public Item setKey(int key) {
		this.key = key;
		return this;
	}
	
	public int getValue() {
		return value;
	}
	
	public Item setValue(int value) {
		this.value = value;
		return this;
	}
}