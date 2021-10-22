package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LvSheng
 * @date 2021/10/22
 **/
public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result  = new ArrayList<>();
        int           row     = 0, col = 0;
        boolean[][]   visited = new boolean[matrix.length][matrix[0].length];

        while (!isAllVisited(visited)) {
            for (; col < matrix[0].length && !visited[row][col]; col++) {
                result.add(matrix[row][col]);
                visited[row][col] = true;
            }
            col--;
            row++;
            for (; row < matrix.length && !visited[row][col]; row++) {
                result.add(matrix[row][col]);
                visited[row][col] = true;
            }
            row--;
            col--;
            for (; col >= 0 && !visited[row][col]; col--) {
                result.add(matrix[row][col]);
                visited[row][col] = true;
            }
            col++;
            row--;
            for (; row >= 0 && !visited[row][col]; row--) {
                result.add(matrix[row][col]);
                visited[row][col] = true;
            }
            row++;
            col++;
        }
        return result;
    }

    private boolean isAllVisited(boolean[][] visited) {
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[i].length; j++) {
                if (!visited[i][j]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] arrays = new int[3][4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                arrays[i][j] = i * 4 + j + 1;
            }
        }

        SpiralOrder printArray = new SpiralOrder();
        System.out.println(printArray.spiralOrder(arrays));
    }
}
