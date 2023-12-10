package easy;

/**
 * https://leetcode.com/problems/increasing-triplet-subsequence/submissions/
 *
 * @author 吕胜 lvheng1
 * @date 2023/12/10
 **/
public class IncreasingTriplet {
	
	public boolean increasingTriplet(int[] nums) {
		int length = nums.length;
		if (length < 3) return false;
		
		int[] leftMin  = new int[length];
		int[] rightMax = new int[length];
		
		leftMin[0] = nums[0];
		for (int i = 1; i < length; i++) {
			leftMin[i] = Math.min(leftMin[i - 1], nums[i]);
		}
		
		rightMax[length - 1] = nums[length - 1];
		for (int i = length - 2; i >= 0; i--) {
			rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
		}
		
		for (int i = 1; i < length - 1; i++) {
			if (nums[i] > leftMin[i - 1] && nums[i] < rightMax[i + 1]) return true;
		}
		return false;
	}
	
	public boolean increasingTriplet2(int[] nums) {
		if (nums.length < 3) return false;
		
		for (int i = 0; i < nums.length; i++)
			for (int j = i + 1; j < nums.length; j++)
				for (int k = j + 1; k < nums.length; k++)
					if (nums[k] > nums[j] && nums[j] > nums[i]) {
						return true;
					}
		return false;
		
	}
	
	public static void main(String[] args) {
		IncreasingTriplet test = new IncreasingTriplet();
		System.out.print(test.increasingTriplet(new int[]{1, 5, 0, 4, 1, 3}));
		System.out.print(test.increasingTriplet(new int[]{5, 1, 6}));
	}
}
