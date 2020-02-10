package march;

/**
 * @author LvSheng
 * @date 2020/2/8
 **/
public class SearchInsert {
	
	public int searchInsert(int[] nums, int target) {
		if (nums.length == 0) return 0;
		
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] == target) return i;
			else if (target > nums[i]) return i + 1;
		}
		return 0;
	}
}
