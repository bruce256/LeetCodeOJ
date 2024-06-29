package graph;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @auther: LvSheng
 * @date: 2024/6/29
 * @description:
 */
public class CanFinish2 {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		Edge[]    edges   = new Edge[numCourses];
		int[]     indegree = new int[numCourses];
		boolean[] visited = new boolean[numCourses];
		for (int i = 0; i < numCourses; i++) edges[i] = new Edge(-1);
		
		for (int i = 0; i < prerequisites.length; i++) {
			int[] edge = prerequisites[i];
			Edge e = new Edge(edge[1]);
			int edgeHead = edge[0];
			e.next = edges[edgeHead].next;
			edges[edgeHead].next = e;
			
			indegree[edge[1]]++;
		}
		Queue<Integer> q = new ArrayDeque<Integer>(numCourses);
		for (int i = 0; i < numCourses; i++) {
			if (indegree[i] == 0) q.add(i);
		}
		if (q.isEmpty()) return false;
		
		while (!q.isEmpty()) {
			int ver = q.poll();
			visited[ver] = true;
			Edge head = edges[ver].next;
			while (head != null) {
				if (--indegree[head.num] == 0) q.add(head.num);
				head = head.next;
			}
		}
		
		boolean result = true;
		for (boolean v : visited) result &= v;
		return result;
	}
}

class Edge {
	public Edge(int n) {
		num = n;
	}
	
	public int num;
	public Edge next = null;
}
