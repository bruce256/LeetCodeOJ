package heap;

import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/kth-largest-element-in-a-stream/description/
 *
 * @author 吕胜 lvheng1
 * @date 2024/1/14
 **/
public class KthLargest {
	
	PriorityQueue<Integer> priorityQueue;
	int                    size;
	
	public KthLargest(int k, int[] nums) {
		priorityQueue = new PriorityQueue<>(k);
		size          = k;
		for (int num : nums) {
			add(num);
		}
	}
	
	public int add(int val) {
		priorityQueue.offer(val);
		if (priorityQueue.size() > size) {
			priorityQueue.poll();
		}
		return priorityQueue.peek();
	}
	
	public static void main(String[] args) {
		KthLargest test = new KthLargest(3, new int[]{4, 5, 8, 2});
		System.out.println(test.add(3));
		System.out.println(test.add(5));
		System.out.println(test.add(10));
		System.out.println(test.add(9));
		System.out.println(test.add(4));
	}
}
