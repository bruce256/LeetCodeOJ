package bit.manipulation;

/**
 * Created by Administrator on 2016/6/21.
 */
public class BitwiseANDofNumbersRange {

	public static void main(String[] args) {
		BitwiseANDofNumbersRange br = new BitwiseANDofNumbersRange();
		System.out.println(br.rangeBitwiseAnd(5, 7));
		System.out.println(br.rangeBitwiseAnd(600000000, 2147483645));
	}

	public int rangeBitwiseAnd(int m, int n) {
		int r   = 0;
		int b   = 1;
		int xor = m & n;
		for (int i = 0; i < 32; i++) {
			if ((b & xor) != 0) {
				boolean ok = true;
				for (int j = m; j <= n; j++) {
					if ((b & j) == 0) {
						ok = false;
						break;
					}
				}
				if (ok) r += b;
			}
			b <<= 1;
		}
		return r;
	}
}
