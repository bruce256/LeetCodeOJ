package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 吕胜 lvheng1
 * @date 2023/12/11
 **/
public class EqualPairs {
	
	public int equalPairs(int[][] grid) {
		Map<List<Integer>, Integer> map = new HashMap();
		int                         n   = grid.length;
		
		for (int i = 0; i < n; i++) {
			List<Integer> list = new ArrayList<>();
			Arrays.stream(grid[i]).forEach(e -> list.add(e));
			Integer value = map.get(list);
			if (value == null) {
				map.put(list, 1);
			} else {
				map.put(list, value + 1);
			}
		}
		
		int result = 0;
		for (int i = 0; i < n; i++) {
			List<Integer> list = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				list.add(grid[j][i]);
			}
			Integer value = map.get(list);
			if (value != null) {
				result += value;
			}
		}
		return result;
	}
}
