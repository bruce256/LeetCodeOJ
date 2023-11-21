package twopointers;

/**
 * https://leetcode.com/problems/container-with-most-water/description/
 *
 * @author 吕胜 lvheng1
 * @date 2023/11/21
 **/
public class MaxArea {
	
	// 暴力枚举
	public int maxArea(int[] height) {
		int max = 0;
		for (int i = 0; i < height.length; i++) {
			for (int j = i + 1; j < height.length; j++) {
				int h = Math.min(height[i], height[j]);
				max = Math.max(h * (j - i), max);
			}
		}
		return max;
	}
	
	// 双指针
	public int maxArea2(int[] height) {
		int left  = 0;
		int right = height.length - 1;
		int max   = 0;
		while (left < right) {
			max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
			
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}
		return max;
	}
	
}
