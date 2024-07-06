package graph;

/**
 * https://leetcode.cn/problems/number-of-provinces/description/
 * 图的联通分量
 *
 * @auther: LvSheng
 * @date: 2024/7/6
 * @description:
 */
public class FindCircleNum1 {
	
	public int findCircleNum(int[][] isConnected) {
		int       length  = isConnected.length;
		boolean[] visited = new boolean[length];
		
		int circle = 0;
		for (int i = 0; i < length; i++) {
			if (!visited[i]) {
				circle++;
				dfs(i, isConnected, visited);
			}
		}
		
		return circle;
	}
	
	private void dfs(int cur, int[][] isConnected, boolean[] visited) {
		visited[cur] = true;
		for (int i = 0; i < visited.length; i++) {
			if (isConnected[cur][i] == 1 && !visited[i]) {
				dfs(i, isConnected, visited);
			}
		}
	}
	
	public static void main(String[] args) {
		FindCircleNum1 test = new FindCircleNum1();
		System.out.println(test.findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
	}
}
