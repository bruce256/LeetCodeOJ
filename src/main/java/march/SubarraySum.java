package march;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LvSheng
 * @date 2020/2/2
 **/
public class SubarraySum {
	
	public int subarraySum(int[] nums, int k) {
		if (nums.length == 0) return 0;
		
		int[]                 sum = new int[nums.length];
		Map<Integer, Integer> map = new HashMap<>(nums.length);
		
		sum[0] = nums[0];
		map.put(sum[0], 1);
		for (int i = 1; i < nums.length; i++) {
			sum[i] = sum[i - 1] + nums[i];
			map.put(sum[i], i);
		}
		
		int total = 0;
		for (int i = 0; i < nums.length; i++) {
			if (map.get(sum[i] - k) != null && i > map.get(sum[i] - k)) total ++;
			else if(sum[i] == k) total ++;
		}
		
		return total;
	}
	
	public static void main(String[] args) {
		SubarraySum ss = new SubarraySum();
		//System.out.println(ss.subarraySum(new int[]{1}, 0));
		System.out.println(ss.subarraySum(new int[]{-1, -1, 1}, 0));
	}
}
