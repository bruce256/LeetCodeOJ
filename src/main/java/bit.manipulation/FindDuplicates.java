package bit.manipulation;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * @author 吕胜 lvheng1
 * @date 2024/1/13
 **/
public class FindDuplicates {
	
	public List<Integer> findDuplicates(int[] nums) {
		BitSet        bitSet = new BitSet(nums.length);
		List<Integer> list   = new ArrayList<>();
		for (int num : nums) {
			if (bitSet.get(num)) {
				list.add(num);
			} else {
				bitSet.set(num, true);
			}
		}
		return list;
	}
}
