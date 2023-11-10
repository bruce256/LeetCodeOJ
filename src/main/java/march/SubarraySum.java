package march;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LvSheng
 * @date 2020/2/2
 **/
public class SubarraySum {
	
	int result;
	
	public int subarraySum(int[] nums, int k) {
		if (nums.length == 0) return 0;
		int                         subNum = 0;
		int[]                       sum    = new int[nums.length];
		Map<Integer, List<Integer>> map    = new HashMap<>();
		sum[0] = nums[0];
		map.put(0, new ArrayList<Integer>() {{
			add(-1);
		}});
		
		for (int i = 0; i < nums.length; i++) {
			if(i == 0) sum[i] = nums[i];
			else sum[i] = sum[i - 1] + nums[i];
			
			List<Integer> value = map.get(sum[i]);
			if (value == null) {
				ArrayList<Integer> arrayList = new ArrayList<Integer>();
				arrayList.add(i);
				map.put(sum[i], arrayList);
			} else {
				value.add(i);
			}
		}
		
		for (int i = 0; i < sum.length; i++) {
			List<Integer> list = map.getOrDefault(sum[i] - k, new ArrayList<>());
			for (Integer integer : list) {
				if (integer < i) subNum++;
				else break;
			}
		}
		return subNum;
	}
	
	public int subarraySum1(int[] nums, int k) {
		if (nums.length == 0) return 0;
		int   subNum = 0;
		int[] sum    = new int[nums.length + 1];
		sum[0] = 0;
		sum[1] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			sum[i + 1] = sum[i] + nums[i];
		}
		
		for (int i = 0; i < sum.length; i++) {
			for (int j = i + 1; j < sum.length; j++) {
				if (sum[j] - sum[i] == k) {
					subNum++;
				}
			}
		}
		return subNum;
	}
	
	private void dfs(int[] nums, int k, int level, int sum) {
		if (nums.length == level) {
			if (sum == k) {
				result++;
			}
			
			return;
		}
		
		dfs(nums, k, level + 1, sum + nums[level]);
		dfs(nums, k, level + 1, sum);
	}
	
	public static void main(String[] args) {
		SubarraySum ss = new SubarraySum();
		System.out.println(ss.subarraySum(new int[]{0, 0}, 0) == 3);
		System.out.println(ss.subarraySum(new int[]{1, -1, 0}, 0));
		System.out.println(ss.subarraySum(new int[]{1, 2, 3}, 3));
		System.out.println(ss.subarraySum(new int[]{1, 1, 1}, 2));
		System.out.println(ss.subarraySum(new int[]{-1, -1, 1}, 0));
	}
}
