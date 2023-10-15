/**
 * https://leetcode.cn/problems/longest-common-prefix/solutions/288575/zui-chang-gong-gong-qian-zhui-by-leetcode-solution/?envType=study-plan-v2&envId=top-interview-150
 *
 * @author LvSheng
 * @date 2023/10/15
 **/
public class LongestCommonPrefix {
	
	public static void main(String[] args) {
		LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
		String              prefix              = longestCommonPrefix.longestCommonPrefix(new String[]{"flower", "flow", "flight"});
		System.out.println(prefix);
		prefix = longestCommonPrefix.longestCommonPrefix(new String[]{"dog", "racecar", "car"});
		System.out.println(prefix);
		prefix = longestCommonPrefix.longestCommonPrefix(new String[]{"ab", "a"});
		System.out.println(prefix);
	}
	
	public String longestCommonPrefix(String[] strs) {
		int commonLen = 0;
		int length    = strs[0].length();
		int count     = strs.length;
		for (; commonLen < length; commonLen++) {
			if (!compare(strs, commonLen, count)) {
				break;
			}
		}
		return strs[0].substring(0, commonLen);
	}
	
	private boolean compare(String[] strs, int commonLen, int count) {
		char target = strs[0].charAt(commonLen);
		for (int i = 1; i < count; i++) {
			if (commonLen >= strs[i].length()) return false;
			if (target != strs[i].charAt(commonLen)) return false;
		}
		return true;
	}
}
