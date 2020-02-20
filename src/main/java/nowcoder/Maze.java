package nowcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author LvSheng
 * @date 2020/2/20
 **/
public class Maze {
	
	static boolean     ok;
	static List<Point> result;
	static int         row;
	static int         column;
	
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
			row = cin.nextInt();
			column = cin.nextInt();
			
			int[][] maze = new int[row][column];
			for (int i = 0; i < row; i++)
				for (int j = 0; j < column; j++) {
					maze[i][j] = cin.nextInt();
				}
			
			List<Point> list = new ArrayList<>();
			ok = false;
			backtrack(maze, 0, 0, list);
			result.stream().forEach(System.out::println);
		}
	}
	
	static void backtrack(int[][] maze, int r, int c, List<Point> list) {
		if (ok) return;
		if (r < 0 || r >= row || c < 0 || c >= column || maze[r][c] == 1) return;
		
		list.add(new Point(r, c));
		
		if (r == row - 1 && c == column - 1) {
			ok = true;
			result = new ArrayList<>(list);
			return;
		}
		
		maze[r][c] = 1;
		backtrack(maze, r, c + 1, list);
		backtrack(maze, r, c - 1, list);
		backtrack(maze, r - 1, c, list);
		backtrack(maze, r + 1, c, list);
		
		maze[r][c] = 0;
		list.remove(list.size() - 1);
	}
	
	static class Point {
		
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public String toString() {
			return "(" + x + "," + y + ")";
		}
	}
}
