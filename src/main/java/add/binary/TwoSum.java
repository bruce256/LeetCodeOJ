package add.binary;

import java.util.HashMap;
import java.util.Map;


/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 *
 * @author lvsheng
 * project LeetCodeOJ
 * date 2016年2月18日
 * time 下午5:00:33
 */
public class TwoSum {
	
	public static void main(String[] args) {
		int[] a      = {2, 7, 11, 15};
		int[] result = twoSum(a, 9);
		System.out.println(result[0] + "\t" + result[1]);
	}
	
	public static int[] twoSum(int[] numbers, int target) {
		int[]                 result = new int[2];
		int                   n2;
		Integer               idx;
		Map<Integer, Integer> map    = new HashMap<Integer, Integer>(numbers.length);
		
		for (int i = 0; i < numbers.length; i++) {
			map.put(numbers[i], i);
		}
		for (int i = 0; i < numbers.length - 1; i++) {
			n2  = target - numbers[i];
			idx = map.get(n2);
			if (idx != null && idx > i) {
				result[0] = i + 1;
				result[1] = idx + 1;
				break;
			}
		}
		return result;
	}
}
