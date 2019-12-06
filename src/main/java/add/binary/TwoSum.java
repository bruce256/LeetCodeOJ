package add.binary;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * @author lvsheng
 * project LeetCodeOJ
 * date 2016年2月18日
 * time 下午5:00:33
 */
public class TwoSum {

	public static void main(String[] args) {
		int[] a = { 2, 7, 11, 15 };
		System.out.println(twoSum(a, 9));
	}
	
	public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int n2;
        Integer idx;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length);
        
        for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
        for (int i = 0; i < nums.length - 1; i++) {
			n2 = target - nums[i];
			idx = map.get(n2);
			if(idx != null && idx > i){
				result[0] = i;
				result[1] = idx;
				break;
			}
		}
        return result;
    }
}
