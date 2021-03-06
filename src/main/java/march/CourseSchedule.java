package march;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Administrator on 2016/6/17.
 */
public class CourseSchedule {

	public static void main(String[] args) {
		CourseSchedule cs = new CourseSchedule();
		int[][]        a  = {{0, 1}};
		System.out.println(cs.canFinish(2, a));
		int[][] b = {{0, 1}, {1, 0}};
		System.out.println(cs.canFinish(2, b));
	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		Edge[]    edges   = new Edge[numCourses];
		int[]     indgree = new int[numCourses];
		boolean[] visited = new boolean[numCourses];
		for (int i = 0; i < numCourses; i++) edges[i] = new Edge(-1);

		for (int i = 0; i < prerequisites.length; i++) {
			int[] edge = prerequisites[i];
			Edge e = new Edge(edge[1]);
			int edgeHead = edge[0];
			e.next = edges[edgeHead].next;
			edges[edgeHead].next = e;

			indgree[edge[1]]++;
		}
		Queue<Integer> q = new ArrayDeque<Integer>(numCourses);
		for (int i = 0; i < numCourses; i++) {
			if (indgree[i] == 0) q.add(i);
		}
		if (q.isEmpty()) return false;

		while (!q.isEmpty()) {
			int ver = q.poll();
			visited[ver] = true;
			Edge head = edges[ver].next;
			while (head != null) {
				if (--indgree[head.num] == 0) q.add(head.num);
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
