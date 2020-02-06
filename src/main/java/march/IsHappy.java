package march;

import java.util.HashSet;
import java.util.Set;

/**
 * @author LvSheng
 * @date 2020/2/6
 **/
public class IsHappy {
	
	public boolean isHappy(int n) {
		Set<Integer> set = new HashSet<>();
		while (n != 1) {
			n = square(n);
			if (set.contains(n)) return false;
			else set.add(n);
		}
		return true;
	}
	
	private int square(int d) {
		int sum = 0;
		while (d != 0) {
			int yu = d % 10;
			d /= 10;
			sum += (yu * yu);
		}
		
		return sum;
	}
}
