package tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.cn/problems/jump-game-ii/description/?envType=study-plan-v2&envId=top-interview-150
 *
 * @author 吕胜 lvheng1
 * @date 2024/1/10
 **/
public class Jump {
	
	/**
	 * bfs解法，内存超了
	 *
	 * @param nums
	 * @return
	 */
	public int jump(int[] nums) {
		if (nums.length == 1) return 0;
		Deque<Short> deque   = new ArrayDeque();
		int          target  = nums.length - 1;
		int          index   = 0;
		boolean[]    visited = new boolean[nums.length];
		deque.add((short) 0);
		visited[0] = true;
		int level = 0;
		while (!deque.isEmpty()) {
			int size = deque.size();
			level++;
			for (int j = 0; j < size; j++) {
				index = deque.poll();
				
				for (int i = nums[index]; i >= 1; i--) {
					int newPos = index + i;
					if (newPos >= target) return level;
					if (!visited[newPos]) {
						deque.add((short) newPos);
						visited[newPos] = true;
					}
				}
			}
		}
		
		return level;
		
	}
	
	public static void main(String[] args) {
		Jump test = new Jump();
		System.out.println(test.jump(new int[]{2, 3, 1, 1, 4}));
		System.out.println(test.jump(new int[]{2, 3, 0, 1, 4}));
	}
}
