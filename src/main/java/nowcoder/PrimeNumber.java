package nowcoder;

import java.util.BitSet;
import java.util.Scanner;

/**
 * 华为上机题
 *
 * @author LvSheng
 * @date 2020/2/23
 **/
public class PrimeNumber {
	
	public static void main(String[] args) {
		PrimeNumber pn = new PrimeNumber();
		Scanner     sc = new Scanner(System.in);
		
		while (sc.hasNext()) {
			int    low   = sc.nextInt();
			int    high  = sc.nextInt();
			BitSet prime = new BitSet(high);
			prime.set(0, high, true);
			pn.calPrime(prime);
			System.out.println(pn.compare(prime, low, high));
		}
	}
	
	private void calPrime(BitSet prime) {
		int length = prime.length();
		for (int i = 2; i < length; i++) {
			if (prime.get(i)) {
				for (int j = 2; j * i < length; j++) {
					prime.set(j * i, false);
				}
			}
		}
	}
	
	private int compare(BitSet prime, int low, int high) {
		int ten = 0;
		int one = 0;
		for (int i = low; i < high; i++) {
			if (prime.get(i)) {
				int tmp = i;
				one += (tmp % 10);
				tmp /= 10;
				
				ten += (tmp % 10);
			}
		}
		
		return Math.min(one, ten);
	}
}
