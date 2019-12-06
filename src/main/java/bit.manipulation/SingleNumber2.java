package bit.manipulation;

import java.util.*;

/**
 * project  : LeetCodeOJ
 * package  : bit.manipulation
 * author   : lvsheng
 * date     : 16/7/31 下午2:28
 */
public class SingleNumber2 {

	public static void main(String[] args) {
		int[] arr  = {-1, 5, 5, 5, 7, 7, 7, 90, 90, 90};
		int[] arr2 = {7};
		int[] arr3 = {0, 0, 0, 5};

		System.out.println(singleNumber(arr));
		System.out.println(singleNumber(arr2));
		System.out.println(singleNumber(arr3));

		System.out.println(singleNumber2(arr));
		System.out.println(singleNumber2(arr2));
		System.out.println(singleNumber2(arr3));

		System.out.println(singleNumber3(arr));
		System.out.println(singleNumber3(arr2));
		System.out.println(singleNumber3(arr3));
	}

	public static int singleNumber(int[] nums) {
		// if(nums.length == 1) return nums[0];
		int result = 0;
		for (int i = 0; i < 32; i++) {
			int cnt = 0;
			int bit = 1 << i;
			for (int num : nums) {
				if ((num & bit) != 0) {
					cnt++;
				}
			}
			cnt %= 3;
			if (cnt == 1) result |= bit;
		}
		return result;
	}

	public static int singleNumber2(int[] nums) {

		Map<Integer, Long> map = new HashMap<>(nums.length);
		for (int n : nums) {
			if (map.get(n) != null) {
				Long val = map.get(n);
				if (val == Long.MAX_VALUE) map.remove(n);
				else map.put(n, Long.MAX_VALUE);
			} else map.put(n, (long) n);
		}
		List<Integer> list = new ArrayList<>(map.keySet());
		return list.get(0);
	}

	public static int singleNumber3(int[] nums) {
		if (nums.length == 1) return nums[0];
		Arrays.sort(nums);
		int result = nums[0];
		int cnt    = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == result) cnt++;
			else {
				if (cnt == 3) {
					result = nums[i];
					cnt = 1;
				} else {
					break;
				}
			}
		}
		return result;
	}
}
