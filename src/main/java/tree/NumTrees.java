package tree;

/**
 * @author LvSheng
 * @date 2024/2/2
 **/
public class NumTrees {
	
	public int numTrees(int n) {
		int[] result = new int[20];
		result[0] = 1;
		result[1] = 1;
		result[2] = 2;
		
		for (int i = 3; i <= n; i++) {
			int r = 0;
			for (int j = 1; j <= i; j++) {
				r += (result[j - 1] * result[i - j]);
			}
			result[i] = r;
		}
		
		return result[n];
	}
	
	public static void main(String[] args) {
		NumTrees test = new NumTrees();
		System.out.println(test.numTrees(3));
	}
}
