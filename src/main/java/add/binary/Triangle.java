package add.binary;

import java.util.ArrayList;
import java.util.List;


/**
 * @author lvsheng
 * project LeetCodeOJ
 * date 2016年2月19日
 * time 下午5:44:44
 */
public class Triangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<List<Integer>> dp = new ArrayList<List<Integer>>();
		List<Integer> l1 = new ArrayList<Integer>();
		List<Integer> l2 = new ArrayList<Integer>();
		List<Integer> l3 = new ArrayList<Integer>();
		l1.add(-1);
		l2.add(2);
		l2.add(3);
		l3.add(1);
		l3.add(-1);
		l3.add(-3);
		dp.add(l1);
		dp.add(l2);
		dp.add(l3);
		System.out.print(minimumTotal(dp));
	}
	
	public static int minimumTotal(List<List<Integer>> triangle) {
		if(triangle.size() == 0) return 0;
		List<List<Integer>> dp = new ArrayList<List<Integer>>();
		dp.add(triangle.get(0));
		for (int i = 1; i < triangle.size(); i++) {
			List<Integer> dpl = new ArrayList<Integer>();
			List<Integer> list = triangle.get(i);
			List<Integer> dpup = dp.get(i-1);
			dpl.add(list.get(0) + dpup.get(0));
			for (int j = 1; j < list.size() - 1; j++) {
				int a = dpup.get(j-1) ,b = dpup.get(j);
				int min = a > b ? b : a;
				dpl.add(list.get(j) + min);
			}
			dpl.add(list.get(list.size() - 1) + dpup.get(dpup.size() - 1));
			dp.add(dpl);
		}
		List<Integer> last = dp.get(dp.size() - 1);
		int min = last.get(0);
		for (int i = 1; i < last.size(); i++) 
			if(last.get(i) < min) min = last.get(i);
		
		return min;
    }

}
