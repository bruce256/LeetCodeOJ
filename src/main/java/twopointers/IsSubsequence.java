package twopointers;

/**
 * https://leetcode.cn/problems/is-subsequence/
 *
 * @auther: LvSheng
 * @date: 2025/1/12
 * @description:
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int si = 0;
        for (int ti = 0; ti < t.length() && si < s.length(); ti++) {
            if (t.charAt(ti) == s.charAt(si)) {
                si++;
            }
        }
        return si == s.length();
    }
}
