/**
 * 
 */
package march;


/**
 * @auther lvsheng
 * @date 2016年3月2日
 * @time 下午7:01:41
 * @project LeetCodeOJ
 * 
 */

public class MoveZeroes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void moveZeroes(int[] nums) {
		if(nums.length == 0) return;
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
			if(nums[i] != 0) nums[idx++] = nums[i];
		}
        while (idx < nums.length) nums[idx ++] = 0;
    }

}
