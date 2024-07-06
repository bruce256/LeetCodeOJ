package graph;

/**
 * https://leetcode.cn/problems/number-of-provinces/description/
 * 并查集求解
 *
 * @author LvSheng
 * @date 2020/1/28
 **/
public class FindCircleNum {
	
	public int findCircleNum(int[][] M) {
		int[] parents = new int[M.length];
		for (int i = 0; i < parents.length; i++) parents[i] = i;
		for (int i = 0; i < M.length; i++)
			for (int j = i + 1; j < M.length; j++) {
				if (i == j) continue;
				if (M[i][j] == 1) {
					int p1 = getParents(parents, i);
					int p2 = getParents(parents, j);
					if (p1 != p2) {
						parents[p1] = p2;
					}
				}
			}
		
		int sum = 0;
		
		for (int i = 0; i < M.length; i++) {
			if (parents[i] == i) sum++;
		}
		
		return sum;
	}
	
	private int getParents(int[] p, int i) {
		while (p[i] != i) {
			i = p[i];
		}
		return i;
	}
}
