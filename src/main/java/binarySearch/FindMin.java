package binarySearch;

/**
 * https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/description/
 *
 * @auther:LvSheng
 * @date:2024/6/14
 */
public class FindMin {
	
	public int findMin(int[] nums) {
		int left  = 0;
		int right = nums.length - 1;
		while (left < right) {
			int mid = (left + right) / 2;
			if (nums[mid] >= nums[left] && nums[mid] <= nums[right]) {
				return nums[left];
			}
			if (nums[mid] >= nums[left]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		
		return nums[left];
	}
	
	public static void main(String[] args) {
		FindMin test = new FindMin();
		System.out.println(test.findMin(new int[]{2, 1}));
		System.out.println(test.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
		System.out.println(test.findMin(new int[]{11, 13, 15, 17}));
		System.out.println(test.findMin(new int[]{3, 4, 5, 1, 2}));
	}
}
