package add.binary;


/**
 * @author lvsheng
 * project LeetCodeOJ
 * date 2016年2月25日
 * time 下午7:44:12
 */
public class MinimumSizeSubarraySum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a= {2,3,1,2,4,3};
		System.out.print(minSubArrayLen(7, a));
	}
	
	public static int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        if(len == 0 || s == 0) return 0;
		int[] add = new int[len];
		add[0] = nums[0];
		for (int i = 1; i < len; i++) {
			add[i] += (add[i - 1] + nums[i]);
		}
		
		int l = Integer.MAX_VALUE;
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if(add[j] - add[i] == s && j - i < l) {
					l = j - i;
				}
			}
		}
		if(l == Integer.MAX_VALUE) return 0;
		else return l;
    }

}
