package heap;

import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/description/
 *
 * @author LvSheng
 * @date 2024/3/19
 **/
public class FindKthLargest {
	
	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Integer::compareTo);
		for (int i = 0; i < nums.length; i++) {
			if (i < k) {
				priorityQueue.add(nums[i]);
			} else if(nums[i] > priorityQueue.peek()){
				priorityQueue.poll();
				priorityQueue.add(nums[i]);
			}
		}
		
		return priorityQueue.peek();
	}
	
	public static void main(String[] args) {
		FindKthLargest test = new FindKthLargest();
		test.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
	}
	
}
