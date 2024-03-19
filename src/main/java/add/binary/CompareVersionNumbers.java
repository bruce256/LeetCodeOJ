package add.binary;

/**
 * https://leetcode.cn/problems/compare-version-numbers/description/
 *
 * @author lvsheng
 *         project LeetCodeOJ
 *         date 2016年2月17日
 *         time 下午4:54:01
 */
public class CompareVersionNumbers {


	public static void main(String[] args) {
		System.out.println(compareVersion("1.1", "1.11"));
		System.out.println(compareVersion("1.10", "1.9"));
		System.out.println(compareVersion("1.10", "1.10"));
		System.out.println(compareVersion("1.0", "1"));
		System.out.println(compareVersion("1.1", "1"));
	}

	public static int compareVersion(String version1, String version2) {
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");
		for (int i = 0; i < v1.length || i < v2.length; i++) {
			if (i >= v1.length)
				if (Integer.parseInt(v2[i]) == 0) continue;
				else return -1;
			if (i >= v2.length)
				if (Integer.parseInt(v1[i]) == 0) continue;
				else return 1;
			int n1 = Integer.parseInt(v1[i]);
			int n2 = Integer.parseInt(v2[i]);
			if (n1 > n2)
				return 1;
			if (n1 < n2)
				return -1;
		}
		return 0;
	}
}
