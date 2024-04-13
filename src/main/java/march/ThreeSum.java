package march;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode.cn/problems/3sum/description/
 *
 * @author LvSheng
 * @date 2020/1/25
 **/
public class ThreeSum {
	
	public List<List<Integer>> threeSum(int[] nums) {
		// 设置好初始容量，提速
		HashMap<Integer, Integer> map    = new HashMap<>(nums.length * 2);
		HashSet<List<Integer>>    result = new HashSet<>();
		Arrays.sort(nums);
		
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		
		for (int i = 0; i < nums.length; i++) {
			// 剪枝
			if (nums[i] > 0) {
				break;
			}
			for (int j = i + 1; j < nums.length; j++) {
				int sum = nums[i] + nums[j];
				if (sum > 0) {
					break;
				}
				if (sum + nums[nums.length - 1] < 0) {
					continue;
				}
				if (map.get(-sum) != null && map.get(-sum) > j) {
					Integer[]     s = {nums[i], nums[j], -sum};
					List<Integer> l = Arrays.asList(s);
					result.add(l);
				}
			}
		}
		return new ArrayList<>(result);
	}
	
	public List<List<Integer>> threeSum1(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		
		HashMap<Integer, Integer> map = new HashMap<>(nums.length * 2);
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (i != 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			
			for (int j = i + 1; j < nums.length; j++) {
				if (j != (i + 1) && nums[j] == nums[j - 1]) {
					continue;
				}
				
				int     sum = nums[i] + nums[j];
				Integer idx = map.get(-sum);
				if (idx != null && idx > j) {
					List<Integer> list = new ArrayList<>();
					list.add(nums[i]);
					list.add(nums[j]);
					list.add(-sum);
					result.add(list);
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		ThreeSum            ts    = new ThreeSum();
		List<List<Integer>> lists = ts.threeSum(new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4});
		System.out.println(lists);
		lists = ts.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
		System.out.println(lists);
	}
}
