package march;

/**
 * @author LvSheng
 * @date 2020/2/3
 **/
public class MyCircularQueue {
	
	int[] array;
	int   head;
	int   tail;
	int   capacity;
	
	/**
	 * Initialize your data structure here. Set the size of the queue to be k.
	 */
	public MyCircularQueue(int k) {
		array = new int[k + 1];
		capacity = k + 1;
		head = 0;
		tail = 0;
	}
	
	/**
	 * Insert an element into the circular queue. Return true if the operation is successful.
	 */
	public boolean enQueue(int value) {
		if (isFull()) return false;
		array[tail] = value;
		tail = (tail + 1) % capacity;
		return true;
	}
	
	/**
	 * Delete an element from the circular queue. Return true if the operation is successful.
	 */
	public boolean deQueue() {
		if (isEmpty()) return false;
		
		int data = array[head];
		head = (head + 1) % capacity;
		return true;
	}
	
	/**
	 * Get the front item from the queue.
	 */
	public int Front() {
		if(isEmpty()) return -1;
		return array[head];
	}
	
	/**
	 * Get the last item from the queue.
	 */
	public int Rear() {
		if(isEmpty()) return -1;
		
		int pos = tail - 1;
		if(pos < 0) pos += capacity;
		return array[pos];
	}
	
	/**
	 * Checks whether the circular queue is empty or not.
	 */
	public boolean isEmpty() {
		return head == tail;
	}
	
	/**
	 * Checks whether the circular queue is full or not.
	 */
	public boolean isFull() {
		return (tail + 1) % capacity == head;
	}
	
	public static void main(String[] args) {
		MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
		circularQueue.enQueue(1); // 返回 true
		
		circularQueue.enQueue(2); // 返回 true
		
		circularQueue.enQueue(3); // 返回 true
		
		circularQueue.enQueue(4); // 返回 false，队列已满
		
		circularQueue.Rear(); // 返回 3
		
		circularQueue.isFull(); // 返回 true
		
		circularQueue.deQueue(); // 返回 true
		
		circularQueue.enQueue(4); // 返回 true
		
		circularQueue.Rear(); // 返回 4
		
		
	}
}
