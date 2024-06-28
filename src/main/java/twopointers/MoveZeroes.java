package twopointers;

/**
 * https://leetcode.cn/problems/move-zeroes/
 *
 * @auther: LvSheng
 * @date: 2024/6/28
 * @description:
 */
public class MoveZeroes {
	
	public void moveZeroes(int[] nums) {
		int insertPtr = 0;
		int cur       = 0;
		while (cur < nums.length) {
			if (nums[cur] != 0) {
				nums[insertPtr] = nums[cur];
				insertPtr++;
			}
			cur++;
		}
		while (insertPtr < nums.length) {
			nums[insertPtr++] = 0;
		}
	}
}
