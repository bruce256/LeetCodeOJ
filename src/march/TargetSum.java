package march;

/**
 * https://leetcode.com/problems/target-sum/
 * <p>
 * 还可以动态规划求解
 *
 * @author lvsheng
 * @date 2019-03-26
 **/
public class TargetSum {
	
	private static int result = 0;
	
	public int findTargetSumWays(int[] nums, int S) {
		result = 0;
		dfs(0, nums, S, 0);
		return result;
	}
	
	public void dfs(int idx, int[] nums, int target, int cur) {
		if (idx == nums.length && cur == target) {
			result++;
			return;
		}
		
		if (idx == nums.length) {
			return;
		}
		dfs(idx + 1, nums, target, cur + nums[idx]);
		dfs(idx + 1, nums, target, cur - nums[idx]);
	}
	
	public static void main(String[] args) {
		TargetSum targetSum = new TargetSum();
		int[]     nums      = {1, 1, 1, 1, 1};
		System.out.println(targetSum.findTargetSumWays(nums, 3));
	}
}
