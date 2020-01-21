package march;

/**
 * @author LvSheng
 * @date 2020/1/21
 **/
public class SurroundArea {
	
	public void solve(char[][] board) {
		if(board == null || board.length == 0) return;
		
		int[][] c    = new int[board.length][board[0].length];
		
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 'O' && (i == 0 || j == 0 || i == board.length - 1 || j == board[i].length - 1)) {
					dfs(board, i, j, c);
				}
			}
		
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 'O' && c[i][j] != 1) {
					board[i][j] = 'X';
				}
			}
	}
	
	
	public void dfs(char[][] board, int row, int col, int[][] c) {
		if (row < 0 || row >= board.length || col < 0 || col >= board[row].length
				|| c[row][col] != 0) {
			return;
		}
		if (board[row][col] == 'O') {
			c[row][col] = 1;
		} else {
			c[row][col] = -1;
			return;
		}
		
		dfs(board, row + 1, col, c);
		dfs(board, row - 1, col, c);
		dfs(board, row, col + 1, c);
		dfs(board, row, col - 1, c);
	}
	
	public static void main(String[] args) {
		char[][]     board = new char[][]{{'X','O','X','O','X','O'},{'O','X','O','X','O','X'},{'X','O','X','O','X','O'},{'O','X','O','X','O','X'}};
		SurroundArea sa    = new SurroundArea();
		sa.solve(board);
		System.out.println(board);
	}
}
