package march;

import java.util.*;

/**
 * Created by Administrator on 2016/6/16.
 */
public class TopKFrequentElements {
	public static void main(String[] args) {
		int[] a = {1, 1, 1, 2, 2, 3};
		System.out.println(topKFrequent(a, 2));
		System.out.println(topKFrequent2(a, 2));
		int[] b = {-1, -1};
		System.out.println(topKFrequent(b, 1));
		System.out.println(topKFrequent2(b, 1));
	}

	// 归并排序
	public static List<Integer> topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length);
		for (int n : nums) {
			Integer val = map.get(n);
			map.put(n, val == null ? 1 : val + 1);
		}

		List<Map.Entry<Integer, Integer>> l = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet().size());
		l.addAll(map.entrySet());
		Collections.sort(l, new Comparator<Map.Entry<Integer, Integer>>() {
			@Override
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return -(o1.getValue() - o2.getValue());
			}
		});

		List<Integer> result = new ArrayList<Integer>(k);
		for (int i = 0; i < k; i++) {
			result.add(l.get(i).getKey());
		}
		return result;
	}

	// 堆排序
	public static List<Integer> topKFrequent2(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length);
		for (int n : nums) {
			Integer val = map.get(n);
			map.put(n, val == null ? 1 : val + 1);
		}

		PriorityQueue<Map.Entry<Integer, Integer>> q = new PriorityQueue<Map.Entry<Integer, Integer>>(map.entrySet().size(), new Comparator<Map.Entry<Integer, Integer>>() {
			@Override
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return -(o1.getValue() - o2.getValue());
			}
		});
		q.addAll(map.entrySet());
		List<Integer> result = new ArrayList<Integer>(k);
		for (int i = 0; i < k; i++) {
			result.add(q.poll().getKey());
		}
		return result;
	}
}
