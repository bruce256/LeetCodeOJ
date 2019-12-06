package bit.manipulation;

/**
 * @author LvSheng
 * @date 2019/12/6
 **/
public class Bit1Num {
	
	// you need to treat n as an unsigned value
	public int hammingWeight(int n) {
		int num   = 1;
		int total = 0;
		for (int i = 0; i < 32; i++) {
			if ((n & (num << i)) != 0) {
				total++;
			}
		}
		return total;
	}
}
