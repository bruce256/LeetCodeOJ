package march;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author LvSheng
 * @date 2020/1/25
 **/
public class ThreeSum {
	
	public List<List<Integer>> threeSum(int[] nums) {
		// 设置好初始容量，提速
		HashMap<Integer, Integer> map    = new HashMap<>(nums.length * 2);
		List<List<Integer>>       result = new ArrayList<>();
		Arrays.sort(nums);
		
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		
		for (int i = 0; i < nums.length; i++) {
			// 剪枝
			if (nums[i] > 0) {
				break;
			}
			if(nums[i] == nums[i+1]) {
				continue;
			}
			for (int j = i + 1; j < nums.length; j++) {
				int sum = nums[i] + nums[j];
				if (map.get(-sum) != null && map.get(-sum) > j) {
					Integer[]     s = {nums[i], nums[j], -sum};
					List<Integer> l = Arrays.asList(s);
					if (!result.contains(l)) {
						result.add(l);
					}
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		ThreeSum            ts    = new ThreeSum();
		List<List<Integer>> lists = ts.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
		System.out.println(lists);
	}
}
