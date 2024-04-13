package bit.manipulation;

/**
 * https://leetcode.com/problems/single-number/description/
 *
 * @author LvSheng
 * @date 2024/1/28
 **/
public class SingleNumber {
	
	public int singleNumber(int[] nums) {
		int result = 0;
		for (int num : nums) {
			result ^= num;
		}
		return result;
	}
	
}
