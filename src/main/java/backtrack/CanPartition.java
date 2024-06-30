package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/partition-equal-subset-sum/
 * 回溯法超时
 *
 * @auther: LvSheng
 * @date: 2024/6/30
 * @description:
 */
public class CanPartition {
	
	public boolean canPartition(int[] nums) {
		if (nums.length <= 1) {
			return false;
		}
		
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		if (sum % 2 != 0) {
			return false;
		}
		
		int target = sum / 2;
		
		return dfs(nums, new ArrayList<>(), target, 0);
	}
	
	private boolean dfs(int[] nums, List<Integer> result, int target, int level) {
		int sum = result.stream().mapToInt(e -> e.intValue()).sum();
		if (sum == target) {
			return true;
		}
		if (sum > target || level >= nums.length) {
			return false;
		}
		
		for(int i=level; i<nums.length; i++) {
			result.add(nums[i]);
			if (dfs(nums, result, target, i + 1)) {
				return true;
			}
			result.remove(result.size() - 1);
		}
		return false;
	}
	
	public static void main(String[] args) {
		CanPartition test = new CanPartition();
		System.out.println(test.canPartition(new int[]{1, 2, 5}));
		System.out.println(test.canPartition(new int[]{1, 5, 11, 5}));
	}
}
