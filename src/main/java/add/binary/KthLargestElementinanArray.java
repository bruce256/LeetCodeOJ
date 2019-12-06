package add.binary;

/**
 * @author lvsheng
 *         project LeetCodeOJ
 *         date 2016年2月23日
 *         time 上午11:12:18
 */
public class KthLargestElementinanArray {

	public static void main(String[] args) {
		int[] a = { 3, 2, 1, 5, 6, 4 };
		System.out.println(findKthLargest(a, 1));
		int[] b = { -1,2,0};
		System.out.println(findKthLargest(b, 3));
		int[] c = { 3,1,2,4};
		System.out.println(findKthLargest(c, 2));

	}

	public static int findKthLargest(int[] nums, int k) {
		int[] heap = new int[k];

		heap[0] = nums[0];
		for (int i = 1; i < k; i++) {
			siftUp(nums[i], heap, i);
		}

		for (int i = k; i < nums.length; i++) {
			siftDown(nums, k, heap, i);
		}

		return heap[0];
	}

	private static void siftDown(int[] nums, int k, int[] heap, int i) {
		if (nums[i] > heap[0]) {
			heap[0] = nums[i];
			int p = 0;
			while(p < k) {
				int minChild = 2 * p + 1;
				if(minChild + 1 < k && heap[minChild] > heap[minChild + 1]) minChild ++;
				if(minChild < k && heap[p] > heap[minChild]) {
					swap(heap, p, minChild);
					p = minChild;
				} else break;
			}
		}
	}

	private static void siftUp(int num, int[] heap, int i) {
		int p = i;
		heap[i] = num;
		while (p != 0) {
			int parent = (p - 1) / 2;
			if (heap[parent] > heap[p]) {
				swap(heap, p, parent);
			}
			p = parent;
		}
	}

	private static void swap(int[] heap, int p, int parent) {
		int temp = heap[parent];
		heap[parent] = heap[p];
		heap[p] = temp;
	}
}
