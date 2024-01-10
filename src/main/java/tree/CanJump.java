package tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.cn/problems/jump-game/description/
 *
 * @author LvSheng
 * @date 2023/10/15
 **/
public class CanJump {
	
	public static void main(String[] args) {
		CanJump canJump = new CanJump();
		System.out.println(canJump.canJump(new int[]{2, 5, 0, 0}));
		System.out.println(canJump.canJump(new int[]{8, 2, 4, 4, 4, 9, 5, 2, 5, 8, 8, 0, 8, 6, 9, 1, 1, 6, 3, 5, 1, 2, 6, 6, 0, 4, 8, 6, 0, 3, 2, 8, 7, 6, 5, 1, 7, 0, 3, 4, 8, 3, 5, 9, 0, 4, 0, 1, 0, 5, 9, 2, 0, 7, 0, 2, 1, 0, 8, 2, 5, 1, 2, 3, 9, 7, 4, 7, 0, 0, 1, 8, 5, 6, 7, 5, 1, 9, 9, 3, 5, 0, 7, 5}));
		System.out.println(canJump.canJump(new int[]{3, 2, 1, 0, 4}));
		System.out.println(canJump.canJump(new int[]{1}));
		System.out.println(canJump.canJump(new int[]{2, 3, 1, 1, 4}));
		System.out.println(canJump.canJump(new int[]{0}));
	}
	
	/**
	 * bfs版本，内存超了
	 *
	 * @param nums
	 * @return
	 */
	public boolean bfs(int[] nums) {
		if (nums.length == 1) return true;
		Deque<Integer> deque   = new ArrayDeque();
		int            target  = nums.length - 1;
		int            index   = 0;
		boolean[]      visited = new boolean[nums.length];
		deque.add(0);
		visited[0] = true;
		
		while (!deque.isEmpty()) {
			index = deque.poll();
			for (int i = nums[index]; i >= 1; i--) {
				int e = index + i;
				if (e >= target) {
					return true;
				}
				if (!visited[e]) {
					deque.add(e);
					visited[e] = true;
				}
			}
			
		}
		
		return false;
	}
	
	boolean flag = false;
	
	public boolean canJump(int[] nums) {
		flag = false;
		dfs(nums, 0, nums.length - 1);
		return flag;
	}
	
	/**
	 * dfs解法超时
	 *
	 * @param nums
	 * @param currentIdx
	 * @param target
	 */
	private void dfs(int[] nums, int currentIdx, int target) {
		if (flag) return;
		if (currentIdx >= target) {
			flag = true;
			return;
		}
		if (currentIdx + nums[currentIdx] >= target) {
			flag = true;
			return;
		}
		
		for (int i = nums[currentIdx]; i >= 1; i--) {
			dfs(nums, currentIdx + i, target);
		}
	}
}
