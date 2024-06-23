package add.binary;


/**
 * https://leetcode.cn/problems/find-peak-element/description
 *
 * @author lvsheng
 * project LeetCodeOJ
 * date 2016年2月16日
 * time 下午8:37:41
 */
public class FindPeakElement {
	
	public int findPeakElement(int[] nums) {
		int idx = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[idx]) {
				idx = i;
			} else {
				break;
			}
		}
		
		return idx;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
	}
	
}
