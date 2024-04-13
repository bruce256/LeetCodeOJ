package add.binary;

/**
 * @author lvsheng
 * project LeetCodeOJ
 * date 2016年2月20日
 * time 下午1:18:11
 */
public class RemoveElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 2, 2, 5, 2 };
		
		System.out.println(removeElement(a, 2));
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ", ");
		}
	}
	public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
			return 0;
		}
        
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
			if(nums[i] != val) {
				nums[idx ++] = nums[i];
			} 
		}
        
        return idx;
    }

}
