package easy;

/**
 * https://leetcode.cn/problems/diagonal-traverse/description/
 *
 * @auther: LvSheng
 * @date: 2024/7/7
 * @description:
 */
public class FindDiagonalOrder {
	
	public int[] findDiagonalOrder(int[][] mat) {
		int     rowLength    = mat.length;
		int     columnLength = mat[0].length;
		boolean direction    = true;
		int[]   result       = new int[rowLength * columnLength];
		int     idx          = 0;
		
		for (int i = 0; i < rowLength + columnLength - 1; i++) {
			for (int j = 0; j <= i; j++) {
				if (direction && j < columnLength && (i - j) < rowLength) {
					result[idx++] = mat[i - j][j];
				} else if (!direction && j < rowLength && (i - j) < columnLength) {
					result[idx++] = mat[j][i - j];
				}
			}
			
			direction = !direction;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		FindDiagonalOrder test = new FindDiagonalOrder();
		System.out.println(test.findDiagonalOrder(new int[][]{{2, 3}}));
		System.out.println(test.findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
	}
}
