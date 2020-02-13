package backtrack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LvSheng
 * @date 2020/2/6
 **/
public class NumSquares {
	
	
	public int numSquares(int n) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(n);
		int num = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			num++;
			for (int i = 0; i < size; i++) {
				int cur = queue.poll();
				for (int j = 1; cur - j * j >= 0; j++) {
					int c = cur - j * j;
					if (c == 0) return num;
					else if (c > 0) queue.add(c);
				}
			}
		}
		
		return num;
	}
	
	
	public static void main(String[] args) {
		NumSquares ns = new NumSquares();
//		System.out.println(ns.numSquares(13));
//		System.out.println(ns.numSquares(9));
		System.out.println(ns.numSquares(313));
	}
}
