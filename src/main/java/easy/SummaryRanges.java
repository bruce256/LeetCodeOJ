package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/merge-intervals/description/?envType=study-plan-v2&envId=top-interview-150
 *
 * @author 吕胜 lvheng1
 * @date 2024/1/18
 **/
public class SummaryRanges {
	
	public List<String> summaryRanges(int[] nums) {
		if (nums.length == 0) return new ArrayList<>();
		
		List<String> list = new ArrayList<>();
		
		int start = nums[0];
		int next  = start + 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == next) {
				next++;
			} else {
				if (start == next - 1) {
					list.add(String.valueOf(start));
				} else {
					list.add(String.valueOf(start) + "->" + (next - 1));
				}
				
				start = nums[i];
				next  = start + 1;
			}
		}
		
		if (start == next - 1) {
			list.add(String.valueOf(start));
		} else {
			list.add(String.valueOf(start) + "->" + (next - 1));
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		SummaryRanges test = new SummaryRanges();
		System.out.println(test.summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
		System.out.println(test.summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
	}
}
