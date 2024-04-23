package divideAndConquer;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @author LvSheng
 * @date 2024/4/23
 **/
public class SortArrayTask extends RecursiveTask<int[]> {
	
	int[] nums;
	int   left;
	int   right;
	int[] tmp;
	
	public SortArrayTask(int[] nums, int[] tmp, int left, int right) {
		this.nums  = nums;
		this.left  = left;
		this.right = right;
		this.tmp   = tmp;
	}
	
	@Override
	protected int[] compute() {
		if (left >= right) {
			return nums;
		}
		
		int middle = (left + right) / 2;
		
		SortArrayTask leftSortArrayTask = new SortArrayTask(nums, tmp, left, middle);
		leftSortArrayTask.fork();
		
		int           newLeft            = middle + 1;
		SortArrayTask rightSortArrayTask = new SortArrayTask(nums, tmp, newLeft, right);
		rightSortArrayTask.fork();
		
		leftSortArrayTask.join();
		rightSortArrayTask.join();
		
		int i = left, j = newLeft;
		int k = 0;
		while (i <= middle && j <= right) {
			if (nums[i] < nums[j]) {
				tmp[k] = nums[i];
				k++;
				i++;
			} else {
				tmp[k] = nums[j];
				j++;
				k++;
			}
		}
		
		while (i <= middle) {
			tmp[k++] = nums[i++];
		}
		while (j <= right) {
			tmp[k++] = nums[j++];
		}
		
		for (i = 0; i < k; i++) {
			nums[left + i] = tmp[i];
		}
		return nums;
	}
	
	public static void main(String[] args) {
		int    num    = 1000000;
		int[]  nums   = new int[num];
		int[]  tmp    = new int[num];
		Random random = new Random();
		for (int i = 0; i < nums.length; i++) {
			nums[i] = random.nextInt();
		}
		System.out.println(nums.length);
		
		ForkJoinPool  forkJoinPool = new ForkJoinPool();
		SortArrayTask task         = new SortArrayTask(nums, tmp, 0, nums.length - 1);
		long          start        = System.currentTimeMillis();
		Future<int[]> result       = forkJoinPool.submit(task);
		try {
			int[] r = result.get();
			
			long duration = System.currentTimeMillis() - start;
			System.out.println("fork/join time cost: " + duration + " ms");
			System.out.println(r);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		SortArray test = new SortArray();
		for (int i = 0; i < nums.length; i++) {
			nums[i] = random.nextInt();
		}
		start = System.currentTimeMillis();
		int[] array    = test.sortArray(nums);
		long  duration = System.currentTimeMillis() - start;
		System.out.println("single thread time cost: " + duration + " ms");
		System.out.println(array);
	}
}
