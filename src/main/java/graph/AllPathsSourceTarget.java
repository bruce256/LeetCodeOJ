package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/all-paths-from-source-to-target/description/
 *
 * @author 吕胜 lvheng1
 * @date 2024/1/8
 **/
public class AllPathsSourceTarget {
	
	/**
	 * bfs
	 *
	 * @param graph
	 * @return
	 */
	public List<List<Integer>> allPathsSourceTarget1(int[][] graph) {
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
	
	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		List<List<Integer>> result = new ArrayList<>();
		Stack<Integer>      path   = new Stack<>();
		path.add(0);
		dfs(graph, result, path);
		return result;
	}
	
	private void dfs(int[][] graph, List<List<Integer>> result, Stack<Integer> path) {
		Integer last = path.get(path.size() - 1);
		if (last == (graph.length - 1)) {
			ArrayList<Integer> dest = new ArrayList<>(path.size());
			dest.addAll(path);
			result.add(dest);
		}
		
		for (int i : graph[last]) {
			path.add(i);
			dfs(graph, result, path);
			path.pop();
		}
	}
	
	public static void main(String[] args) {
		AllPathsSourceTarget all = new AllPathsSourceTarget();
		System.out.println(all.allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}}));
	}
}
