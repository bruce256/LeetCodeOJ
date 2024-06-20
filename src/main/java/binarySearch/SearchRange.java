package binarySearch;

/**
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array
 *
 * @auther: LvSheng
 * @date: 2024/6/20
 * @description:
 */
public class SearchRange {
	
	public int[] searchRange(int[] nums, int target) {
		int l    = -1, r = -1;
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target) {
				l     = mid;
				right = mid - 1;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		left  = 0;
		right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target) {
				r    = mid;
				left = mid + 1;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return new int[]{l, r};
	}
	
	public static void main(String[] args) {
		SearchRange test = new SearchRange();
		System.out.println(test.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
		System.out.println(test.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6));
		System.out.println(test.searchRange(new int[]{}, 6));
	}
}
