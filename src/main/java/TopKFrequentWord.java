import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author 吕胜 lvheng1
 * @date 2024/1/7
 **/
public class TopKFrequentWord {
	
	public List<String> topKFrequent(String[] words, int k) {
		HashMap<String, Integer> map = new HashMap<String, Integer>(words.length);
		for (String word : words) {
			Integer val = map.get(word);
			map.put(word, val == null ? 1 : val + 1);
		}
		
		PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(map.entrySet().size(), (e1, e2) -> {
			if (e1.getValue().equals(e2.getValue())) {
				return -e1.getKey().compareTo(e2.getKey());
			} else {
				return e1.getValue() - e2.getValue();
			}
		});
		map.entrySet().forEach(e -> {
			queue.add(e);
			if (queue.size() > k) queue.poll();
		});
		
		List<String> result = new ArrayList<>(k);
		for (int i = k - 1; i >= 0; i--) {
			result.add(queue.poll().getKey());
		}
		Collections.reverse(result);
		return result;
	}
	
	public static void main(String[] args) {
		TopKFrequentWord test = new TopKFrequentWord();
//		System.out.println(test.topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
		System.out.println(test.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 3));
	}
}
