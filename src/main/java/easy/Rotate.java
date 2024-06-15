package easy;

/**
 * https://leetcode.cn/problems/rotate-image/
 *
 * @auther: LvSheng
 * @date: 2024/6/15
 * @description:
 */
public class Rotate {
	
	public void rotate(int[][] matrix) {
		int     length = matrix.length;
		int[][] copy   = new int[length][length];
		
		// 逐行复制
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				copy[j][length - 1 - i] = matrix[i][j];
			}
		}
		
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				matrix[i][j] = copy[i][j];
			}
		}
	}
	
	public static void main(String[] args) {
	
	}
}
