package march;

import java.util.BitSet;

/**
 * @author LvSheng
 * @date 2020/2/1
 **/
public class MyHashSet {
	
	private BitSet bs = new BitSet(1000001);
	
	/**
	 * Initialize your data structure here.
	 */
	public MyHashSet() {
	
	}
	
	public void add(int key) {
		bs.set(key);
	}
	
	public void remove(int key) {
		bs.clear(key);
	}
	
	/**
	 * Returns true if this set contains the specified element
	 */
	public boolean contains(int key) {
		return bs.get(key);
	}
}
