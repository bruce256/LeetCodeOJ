package backtrack;

/**
 * https://leetcode.cn/problems/n-queens-ii/
 *
 * @author LvSheng
 * @date 2024/2/7
 **/
public class TotalNQueens {
	
	int result;
	
	public int totalNQueens(int n) {
		int[] board = new int[n];
		result = 0;
		dfs(board, 0, n);
		return result;
	}
	
	void dfs(int[] board, int level, int n) {
		if (level == n) {
			result++;
			return;
		}
		
		for (int i = 0; i < n; i++) {
			// 判断第i号位置是否可以摆放棋子
			boolean ok = true;
			for (int j = 0; j < level; j++) {
				if (i == board[j] || level + i == j + board[j] || level - i == j - board[j]) {
					ok = false;
				}
			}
			if (ok) {
				board[level] = i;
				dfs(board, level + 1, n);
			}
		}
	}
	
	
	public static void main(String[] args) {
		TotalNQueens test = new TotalNQueens();
		System.out.println(test.totalNQueens(4));
		System.out.println(test.totalNQueens(1));
	}
}
