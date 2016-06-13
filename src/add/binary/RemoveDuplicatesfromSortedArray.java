package add.binary;


/**
 * @author lvsheng
 * project LeetCodeOJ
 * date 2016年2月20日
 * time 下午1:30:14
 */
public class RemoveDuplicatesfromSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = { 1, 1, 1, 2, 2, 3 };
		System.out.println(removeDuplicates(a));
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ", ");
		}
		System.out.println();
		int[] b = { 1, 1, 1, 1, 3, 3 };
		System.out.println(removeDuplicates(b));
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + ", ");
		}
	}

	public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
			return 0;
		}
        
        int idx = 1, pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
			if(nums[i] != pre) {
				nums[idx ++] = nums[i];
				pre = nums[i];
			}
		}
        
        return idx;
    }
}
