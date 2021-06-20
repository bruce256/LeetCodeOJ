package backtrack;

import java.util.LinkedList;

/**
 * @author LvSheng
 * @date 2021/6/11
 **/
public class Moves {

    public static int bfs(int n, int startRow, int startCol, int endRow, int endCol) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(new Node(startRow, startCol, 0));
        //避免重走
        boolean[][] visited = new boolean[n][n];
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.row < 0 || node.col < 0
                || node.row >= n || node.col >= n
                || visited[node.row][node.col]) {
                continue;
            }

            if (node.row == endRow && node.col == endCol) {
                return node.moves;
            }
            visited[node.row][node.col] = true;

            queue.add(new Node(node.row + 2, node.col + 1, node.moves + 1));
            queue.add(new Node(node.row + 1, node.col + 2, node.moves + 1));
            queue.add(new Node(node.row - 2, node.col + 1, node.moves + 1));
            queue.add(new Node(node.row - 1, node.col + 2, node.moves + 1));
            queue.add(new Node(node.row + 2, node.col - 1, node.moves + 1));
            queue.add(new Node(node.row + 1, node.col - 2, node.moves + 1));
            queue.add(new Node(node.row - 2, node.col - 1, node.moves + 1));
            queue.add(new Node(node.row - 1, node.col - 2, node.moves + 1));
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(Moves.bfs(30, 25, 2, 23, 29));
        System.out.println(Moves.bfs(9, 4, 4, 4, 8));
        System.out.println(Moves.bfs(10, 0, 0, 0, 2));
        System.out.println(Moves.bfs(6, 5, 1, 0, 5));
    }
}


class Node {
    int row;
    int col;
    int moves;

    public Node(int row, int col, int moves) {
        this.row   = row;
        this.col   = col;
        this.moves = moves;
    }
}
