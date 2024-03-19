package easy;

/**
 * https://leetcode.cn/problems/compare-version-numbers/description/
 *
 * @author LvSheng
 * @date 2024/3/18
 **/
public class CompareVersion {
	
	public int compareVersion(String version1, String version2) {
		String[] arr1 = version1.split("\\.");
		String[] arr2 = version2.split("\\.");
		
		
		for (int i = 0; i < arr1.length || i < arr2.length; i++) {
			Integer v1 = 0;
			if (i < arr1.length) {
				v1 = Integer.valueOf(arr1[i]);
			}
			Integer v2 = 0;
			if (i < arr2.length) {
				v2 = Integer.valueOf(arr2[i]);
			}
			
			if (v1 > v2) {
				return 1;
			}
			if (v1 < v2) {
				return -1;
			}
		}
		
		return 0;
	}
}
