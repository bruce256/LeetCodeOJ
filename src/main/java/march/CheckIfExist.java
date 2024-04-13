package march;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LvSheng
 * @date 2020/2/10
 **/
public class CheckIfExist {
	
	public boolean checkIfExist(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>(arr.length);
		
		for (int i = 0; i < arr.length; i++) map.put(arr[i], i);
		
		for (int i = 0; i < arr.length; i++) {
			int key = arr[i] * 2;
			if (map.containsKey(key) && map.get(key) != i) return true;
		}
		
		return false;
	}
}
