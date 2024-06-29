package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/course-schedule/
 * 拓扑排序
 *
 * @auther: LvSheng
 * @date: 2024/6/29
 * @description:
 */
public class CanFinish {
	
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		ArrayList<Integer>[] adjacentTable = new ArrayList[numCourses];
		int[]                indegree      = new int[numCourses];
		
		// 构建邻接表
		for (int i = 0; i < prerequisites.length; i++) {
			int left = prerequisites[i][0];
			if (adjacentTable[left] == null) {
				adjacentTable[left] = new ArrayList<>();
			}
			int right = prerequisites[i][1];
			adjacentTable[left].add(right);
			indegree[right]++;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < indegree.length; i++) {
			if (indegree[i] == 0) {
				queue.add(i);
			}
		}
		if (queue.isEmpty()) {
			return false;
		}
		
		// bfs
		while (!queue.isEmpty()) {
			Integer            poll  = queue.poll();
			ArrayList<Integer> edges = adjacentTable[poll];
			if (edges == null) continue;
			for (Integer right : edges) {
				indegree[right]--;
				if (indegree[right] == 0) {
					queue.add(right);
				}
			}
		}
		
		for (int value : indegree) {
			if (value != 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		CanFinish test = new CanFinish();
		System.out.println(test.canFinish(2, new int[][]{{0, 1}}));
	}
}
