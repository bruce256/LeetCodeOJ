package backtrack;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author LvSheng
 * @date 2021/6/10
 **/
public class Delivery {
    public static List<Integer> calc(int cityNodes, List<Integer> from, List<Integer> to, int company) {

        //数据结构构建
        int[][]   graph   = new int[cityNodes + 1][cityNodes + 1];
        boolean[] visited = new boolean[cityNodes + 1];

        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        for (int[] g : graph) {
            for (int i = 0; i < g.length; i++) {
                g[i] = 0;
            }
        }

        for (int i = 0; i < from.size(); i++) {
            graph[from.get(i)][to.get(i)] = 1;
            graph[to.get(i)][from.get(i)] = 1;
        }

        // 层次遍历
        List<Integer> result = new ArrayList<>();

        LinkedList<Integer> queue     = new LinkedList<>();
        LinkedList<Integer> nextQueue = new LinkedList<>();
        queue.add(company);
        visited[company] = true;
        while (!queue.isEmpty() || !nextQueue.isEmpty()) {
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int i = 1; i < graph[cur].length; i++) {
                    if (graph[cur][i] == 1 && !visited[i]) {
                        nextQueue.add(i);
                        visited[i] = true;
                    }
                }
            }
            Collections.sort(nextQueue);
            result.addAll(nextQueue);
            queue.addAll(nextQueue);
            nextQueue.clear();
        }

        return result;
    }



    public static void main(String[] args) {
        int cityNode = 8;
        int company  = 2;

        List<Integer> from = new ArrayList<>();
        from.add(1);
        from.add(2);
        from.add(2);
        from.add(2);
        from.add(6);
        from.add(1);
        from.add(4);
        from.add(4);
        from.add(3);
        List<Integer> to = new ArrayList<>();
        to.add(2);
        to.add(3);
        to.add(4);
        to.add(6);
        to.add(5);
        to.add(8);
        to.add(5);
        to.add(3);
        to.add(7);

        System.out.println(calc(cityNode, from, to, company));
    }
}
