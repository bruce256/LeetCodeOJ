package divideAndConquer;

/**
 * https://leetcode.cn/problems/sort-an-array/description/
 *
 * @author LvSheng
 * @date 2024/4/22
 **/
public class SortArray {
	
	int[] tmp;
	
	public int[] sortArray(int[] nums) {
		tmp = new int[nums.length];
		mergeSort(nums, 0, nums.length - 1);
		return nums;
	}
	
	private void mergeSort(int[] nums, int left, int right) {
		if (left >= right) {
			return;
		}
		
		int middle = (left + right) / 2;
		
		mergeSort(nums, left, middle);
		int newLeft = middle + 1;
		mergeSort(nums, newLeft, right);
		
		int i = left, j = newLeft;
		int k = 0;
		while (i <= middle && j <= right) {
			if (nums[i] < nums[j]) {
				tmp[k] = nums[i];
				k++;
				i++;
			} else {
				tmp[k] = nums[j];
				j++;
				k++;
			}
		}
		
		while (i <= middle) {
			tmp[k++] = nums[i++];
		}
		while (j <= right) {
			tmp[k++] = nums[j++];
		}
		
		for (i = 0; i < k; i++) {
			nums[left + i] = tmp[i];
		}
	}
	
	public static void main(String[] args) {
		SortArray test  = new SortArray();
		int[]     array = test.sortArray(new int[]{5,2,3,1});
		System.out.println(array);
		array = test.sortArray(new int[]{5, 1, 1, 2, 0, 0});
		System.out.println(array);
	}
}
