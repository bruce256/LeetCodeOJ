package binarySearch;

/**
 * https://leetcode.cn/problems/search-in-rotated-sorted-array/description/
 * <p>
 * 二分搜索
 */
public class Search {
	
	public int search(int[] nums, int target) {
		int left  = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (target == nums[mid]) {
				return mid;
			}
			// 左侧是有序的
			if (nums[mid] >= nums[left]) {
				if (target >= nums[left] && target < nums[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {
				if (target <= nums[right] && target > nums[mid]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		Search test = new Search();
		System.out.println(test.search(new int[]{3, 1}, 1));
		System.out.println(test.search(new int[]{1, 3}, 2));
		System.out.println(test.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
		System.out.println(test.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
		System.out.println(test.search(new int[]{1}, 0));
	}
}
