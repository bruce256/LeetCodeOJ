package march;

/**
 * @author LvSheng
 * @date 2020/2/22
 **/
public class MergeArray {
	
	public void merge(int[] A, int m, int[] B, int n) {
		int pos  = m + n - 1;
		int pos1 = m - 1;
		int pos2 = n - 1;
		
		while (pos1 >= 0 && pos2 >= 0) {
			if (A[pos1] > B[pos2]) {
				A[pos--] = A[pos1--];
			} else {
				A[pos--] = B[pos2--];
			}
		}
		
		while (pos2 > 0) {
			A[pos--] = B[pos2--];
		}
	}
}
