package march;

/**
 * @author LvSheng
 * @date 2020/2/6
 **/
public class ContainsNearbyDuplicate {
	
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if (nums == null || nums.length <= 1) return false;
		
		for (int i = 0; i < nums.length; i++)
			for (int j = i + 1; j <= i + k && j < nums.length; j++) {
				if (nums[i] == nums[j]) return true;
			}
		
		return false;
	}
}
