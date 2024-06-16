package slidingwindow;

import javafx.util.Pair;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/sliding-window-maximum/description/
 *
 * @auther: LvSheng
 * @date: 2024/6/16
 * @description:
 */
public class MaxSlidingWindow {
	
	public int[] maxSlidingWindow(int[] nums, int k) {
		int[] result = new int[nums.length - k + 1];
		PriorityQueue<Pair<Integer, Integer>> priorityQueue = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>() {
			@Override
			public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
				if (o1.getKey() > o2.getKey()) return -1;
				else if (o1.getKey() < o2.getKey()) return 1;
				else return 0;
			}
		});
		
		
		for (int i = 0; i < k; i++) {
			priorityQueue.add(new Pair<>(nums[i], i));
		}
		
		Pair<Integer, Integer> top = priorityQueue.peek();
		result[0] = top.getKey();
		int left = 1;
		
		for (int right = k; right < nums.length; right++) {
			priorityQueue.add(new Pair<>(nums[right], right));
			
			while (priorityQueue.peek().getValue() < left) {
				priorityQueue.poll();
			}
			top          = priorityQueue.peek();
			result[left] = top.getKey();
			left++;
		}
		return result;
	}
	
	public static void main(String[] args) {
		MaxSlidingWindow test = new MaxSlidingWindow();
		test.maxSlidingWindow(new int[]{1, -1}, 1);
		test.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
	}
}
