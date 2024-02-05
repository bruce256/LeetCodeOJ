package march;


import java.util.HashMap;
import java.util.LinkedList;
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
	LinkedList<Integer> list;
	// 用于检查是否存在及 O(1) 获取元素
	Map<Integer, Item>  map;
	
	int capacity;
	
	public LRUCache(int capacity) {
		list = new LinkedList<>();
		map  = new HashMap<>(capacity);
		
		this.capacity = capacity;
	}
	
	public int get(int key) {
		Item item = map.get(key);
		if (item == null) {
			return -1;
		}
		
		list.remove((Integer) key);
		list.add(key);
		
		return item.getValue();
	}
	
	public void put(int key, int value) {
		
		// 若数据已经存在, 则更新结果
		Item query = map.get(key);
		if (query != null) {
			Item item = new Item(key, value);
			map.put(key, item);
			list.remove((Integer) key);
			list.add(key);
			return;
		}
		
		// 若数据不存在
		Item item = new Item(key, value);
		if (list.size() < capacity) {
			list.add(key);
			map.put(key, item);
		} else {
			Integer first = list.removeFirst();
			map.remove(first);
			
			list.add(key);
			map.put(key, item);
		}
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
		this.key   = key;
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