package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/n-queens/
 *
 * @author LvSheng
 * @date 2024/2/7
 **/
public class SolveNQueens {
	
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> result = new ArrayList<>();
		int[]              board  = new int[n];
		dfs(board, 0, n, result);
		return result;
	}
	
	void dfs(int[] board, int level, int n, List<List<String>> result) {
		if (level == n) {
			List<String> list = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < n; j++) sb.append('.');
				sb.setCharAt(board[i], 'Q');
				list.add(sb.toString());
			}
			result.add(list);
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
				dfs(board, level + 1, n, result);
			}
		}
	}
	
	
	public static void main(String[] args) {
		SolveNQueens test = new SolveNQueens();
		System.out.println(test.solveNQueens(4));
		System.out.println(test.solveNQueens(1));
	}
}
