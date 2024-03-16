import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/insert-interval/description/
 *
 * @author LvSheng
 * @date 2024/2/14
 **/
public class Insert {
	
	public int[][] insert(int[][] intervals, int[] newInterval) {
		if (intervals.length == 0) return new int[][]{newInterval};
		
		List<int[]> result = new ArrayList<>();
		int         left   = -1;
		for (int i = 0; i < intervals.length; i++) {
			if (left < 0) {
				if (newInterval[0] > intervals[i][1]) {
					result.add(intervals[i]);
					if (i == intervals.length - 1) {
						result.add(newInterval);
					}
					continue;
				} else if (newInterval[0] >= intervals[i][0]) {
					if (newInterval[1] <= intervals[i][1]) {
						result.add(intervals[i]);
						for (int j = i + 1; j < intervals.length; j++) {
							result.add(intervals[j]);
						}
						break;
					} else {
						left = intervals[i][0];
					}
				} else if (newInterval[0] < intervals[i][0]) {
					if (newInterval[1] < intervals[i][0]) {
						result.add(newInterval);
						for (int j = i; j < intervals.length; j++) {
							result.add(intervals[j]);
						}
						break;
					} else if (newInterval[1] <= intervals[i][1]) {
						result.add(new int[]{newInterval[0], intervals[i][1]});
						for (int j = i + 1; j < intervals.length; j++) {
							result.add(intervals[j]);
						}
						break;
					} else {
						left = newInterval[0];
					}
				}
			} else {
				if (newInterval[1] < intervals[i][0]) {
					result.add(new int[]{left, newInterval[1]});
					for (int j = i; j < intervals.length; j++) {
						result.add(intervals[j]);
					}
					left = -1;
					break;
				} else if (newInterval[1] <= intervals[i][1]) {
					result.add(new int[]{left, intervals[i][1]});
					for (int j = i + 1; j < intervals.length; j++) {
						result.add(intervals[j]);
					}
					left = -1;
					break;
				}
			}
		}
		
		if (left >= 0) {
			result.add(new int[]{left, newInterval[1]});
		}
		
		int[][] array = new int[result.size()][];
		result.toArray(array);
		return array;
	}
	
	public static void main(String[] args) {
		Insert test = new Insert();
		System.out.println(test.insert(new int[][]{{1, 5}, {9, 12}}, new int[]{0, 4}));
		System.out.println(test.insert(new int[][]{{2, 5}}, new int[]{3, 4}));
		System.out.println(test.insert(new int[][]{{2, 5}}, new int[]{0, 1}));
		System.out.println(test.insert(new int[][]{{1, 5}}, new int[]{0, 6}));
		System.out.println(test.insert(new int[][]{{1, 5}}, new int[]{6, 8}));
		System.out.println(test.insert(new int[][]{{1, 5}}, new int[]{5, 7}));
		System.out.println(test.insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8}));
		System.out.println(test.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5}));
	}
}
