package easy;

/**
 * https://leetcode.cn/problems/rotate-string/
 *
 * @auther: LvSheng
 * @date: 2024/6/15
 * @description:
 */
public class RotateString {
	
	public boolean rotateString(String s, String goal) {
		String str = s + s;
		return s.length() == goal.length() && str.contains(goal);
	}
}
