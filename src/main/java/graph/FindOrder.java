package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/course-schedule-ii/description/
 * 拓扑排序
 *
 * @auther: LvSheng
 * @date: 2024/6/29
 * @description:
 */
public class FindOrder {
	
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		ArrayList<Integer>[] adjacentTable = new ArrayList[numCourses];
		int[]                indegree      = new int[numCourses];
		
		// 构建邻接表
		for (int i = 0; i < prerequisites.length; i++) {
			// 反向表示边
			int right  = prerequisites[i][0];
			int left = prerequisites[i][1];
			if (adjacentTable[left] == null) {
				adjacentTable[left] = new ArrayList<>();
			}
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
			return new int[0];
		}
		
		// bfs
		int   idx    = 0;
		int[] result = new int[numCourses];
		while (!queue.isEmpty()) {
			Integer poll = queue.poll();
			result[idx++] = poll;
			ArrayList<Integer> edges = adjacentTable[poll];
			if (edges == null) continue;
			for (Integer left : edges) {
				indegree[left]--;
				if (indegree[left] == 0) {
					queue.add(left);
				}
			}
		}
		
		return idx == numCourses ? result : new int[0];
	}
	
	public static void main(String[] args) {
		FindOrder test = new FindOrder();
		System.out.println(test.findOrder(2, new int[][]{{1, 0}}));
	}
}
