package easy;

import java.util.Arrays;

/**
 * @author 吕胜 lvheng1
 * @date 2023/11/11
 **/
public class LongestConsecutive {
	
	public int longestConsecutive(int[] nums) {
		if (nums.length == 0) return 0;
		
		int max = 1;
		Arrays.sort(nums);
		
		int current = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1] + 1) {
				current++;
			} else if (nums[i] == nums[i - 1]) {
			} else {
				max     = Math.max(max, current);
				current = 1;
			}
		}
		max = Math.max(max, current);
		
		return max;
	}
	
	public static void main(String[] args) {
		LongestConsecutive longestConsecutive = new LongestConsecutive();
		System.out.println(longestConsecutive.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
		System.out.println(longestConsecutive.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
		System.out.println(longestConsecutive.longestConsecutive(new int[]{100}));
	}
}
