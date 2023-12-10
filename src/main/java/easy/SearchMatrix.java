package easy;

/**
 * @author 吕胜 lvheng1
 * @date 2023/12/7
 **/
public class SearchMatrix {
	
	public boolean searchMatrix(int[][] matrix, int target) {
		int rowNum    = matrix.length;
		int columnNum = matrix[0].length;
		
		boolean find = false;
		for (int i = 0; i < rowNum; i++) {
			if (target >= matrix[i][0] && target <= matrix[i][columnNum - 1]) {
				for (int j = 0; j < columnNum; j++) {
					if (matrix[i][j] == target) {
						find = true;
					}
				}
				break;
			} 
		}
		return find;
	}
}
