package march;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * https://leetcode.cn/problems/lfu-cache/description/
 *
 * @auther: LvSheng
 * @date: 2024/6/25
 * @description:
 */
public class LFUCache {
	
	int capacity, time;
	Map<Integer, LfuNode> map;
	TreeSet<LfuNode>      treeSet;
	
	public LFUCache(int capacity) {
		this.time     = 0;
		this.capacity = capacity;
		this.map      = new HashMap<>(capacity);
		this.treeSet  = new TreeSet<>();
	}
	
	public int get(int key) {
		LfuNode lfuNode = map.get(key);
		if (lfuNode == null) {
			return -1;
		}
		
		
		treeSet.remove(lfuNode);
		// 必须在删除之后才能对原对象进行操作，否则会导致删除失败
		lfuNode.time  = ++time;
		lfuNode.count = lfuNode.count + 1;
		
		treeSet.add(lfuNode);
		return lfuNode.value;
	}
	
	public void put(int key, int value) {
		LfuNode lfuNode = map.get(key);
		if (lfuNode == null) {
			lfuNode = new LfuNode(key, value, ++time);
			
			if (map.size() >= capacity) {
				LfuNode first = treeSet.pollFirst();
				map.remove(first.key);
			}
			
			treeSet.add(lfuNode);
			map.put(key, lfuNode);
		} else {
			// 删除旧值加入新值才能触发重新排序
			treeSet.remove(lfuNode);
			
			lfuNode.value = value;
			lfuNode.time  = ++time;
			lfuNode.count = lfuNode.count + 1;
			treeSet.add(lfuNode);
		}
	}
	
	public static void main(String[] args) {
		
		LFUCache test = new LFUCache(2);
		test.put(2, 1);
		test.put(1, 1);
		test.put(2, 3);
		test.put(4, 1);
		System.out.println(test.get(1));
		System.out.println(test.get(2));
		
	}
	
	private static void test1() {
		LFUCache test = new LFUCache(2);
		test.put(1, 1);
		test.put(2, 2);
		System.out.println(test.get(1));
		test.put(3, 3);
		System.out.println(test.get(2));
		System.out.println(test.get(3));
		test.put(4, 4);
		System.out.println(test.get(1));
		System.out.println(test.get(3));
		System.out.println(test.get(4));
	}
}

class LfuNode implements Comparable<LfuNode> {
	
	int key, value;
	int time;
	int count = 1;
	
	public LfuNode() {
	}
	
	public LfuNode(int key, int value, int time) {
		this.key   = key;
		this.value = value;
		this.time  = time;
	}
	
	@Override
	public int compareTo(LfuNode o) {
		if (this.count < o.count) {
			return -1;
		} else if (this.count > o.count) {
			return 1;
		} else {
			if (this.time < o.count) {
				return -1;
			} else if (this.time > o.time) {
				return 1;
			} else {
				return 0;
			}
		}
	}
}
