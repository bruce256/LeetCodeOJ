package easy;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/min-stack/description/?envType=study-plan-v2&envId=top-interview-150
 *
 * @auther: LvSheng
 * @date: 2024/10/18
 * @description:
 */
public class MinStack {
	
	private Stack<Integer> data;
	private Stack<Integer> min;
	
	public MinStack() {
		data = new Stack<>();
		min  = new Stack<>();
	}
	
	public void push(int val) {
		data.push(val);
		if (min.isEmpty() || val < min.peek()) {
			min.push(val);
		} else {
			min.push(min.peek());
		}
	}
	
	public void pop() {
		data.pop();
		min.pop();
	}
	
	public int top() {
		return data.peek();
	}
	
	public int getMin() {
		return min.peek();
	}
}
