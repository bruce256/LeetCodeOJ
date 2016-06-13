/**
 * 
 */
package add.binary;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther lvsheng
 * @date 2016年2月26日
 * @time 下午4:05:05
 * @project LeetCodeOJ
 * 
 */

public class MajorityElementII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> majorityElement(int[] nums) {
		List<Integer> list = new ArrayList<Integer>();
		if(nums.length == 0) return list;
		int a, b = 0, acnt, bcnt = 0;
		a = nums[0]; acnt  = 1;
		int i = 1;
		for (; i < nums.length; i++) {
			if(nums[i] == a) acnt ++;
			else {
				b = nums[i];
				bcnt = 1;
				break;
			}
		}
		
		for (; i < nums.length; i++) {
			if (nums[i] != a && nums[i] != b) {
				if(-- acnt == 0) {
					a = nums[i];
					acnt ++;
				}
			} else if(nums[i] == a) {
				acnt ++;
			} else if (nums[i] == b) {
				bcnt ++;
			}
		}
		
		list.add(a);
		if(bcnt > 0) list.add(b);
		return list;
	}
	
	public boolean isAnagram(String s, String t) {
        if(s == null || t== null) return false;
        if(s.length() == 0 && t.length() == 0) return true;
        StringBuilder sb = new StringBuilder(s);
        if(sb.reverse().toString().equals(t)) return true;
        else return false;
    }
}
