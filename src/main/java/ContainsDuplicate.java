import java.util.HashSet;

/**
 * @author LvSheng
 * @date 2022/12/22
 **/
public class ContainsDuplicate {
	public boolean containsDuplicate(int[] nums) {
		HashSet<Integer> hashSet = new HashSet<>(nums.length);
		for (int num : nums) {
			if(hashSet.contains(num)) return true;
			else {
				hashSet.add(num);
			}
		}
		
		return false;
	}
}
