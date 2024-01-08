package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode.cn/problems/all-paths-from-source-to-target/description/
 *
 * @author 吕胜 lvheng1
 * @date 2024/1/8
 **/
public class AllPathsSourceTarget {
	
	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		int                  num    = graph.length;
		List<List<Integer>>  result = new ArrayList<>();
		Deque<List<Integer>> queue  = new ArrayDeque<>();
		List<Integer>        start  = new ArrayList<>();
		start.add(0);
		queue.add(start);
		while (!queue.isEmpty()) {
			List<Integer> current     = queue.poll();
			Integer       lastElement = current.get(current.size() - 1);
			if (lastElement == (num - 1)) {
				result.add(current);
				continue;
			}
			
			for (int i : graph[lastElement]) {
				ArrayList<Integer> dest = new ArrayList<>(current.size());
				dest.addAll(current);
				dest.add(i);
				queue.add(dest);
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		AllPathsSourceTarget all = new AllPathsSourceTarget();
		System.out.println(all.allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}}));
	}
}
