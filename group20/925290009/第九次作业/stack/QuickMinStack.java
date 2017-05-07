package com.ralf.stack;

import java.util.NoSuchElementException;

/**
 * 设计一个栈，支持栈的push和pop操作，以及第三种操作findMin, 它返回改数据结构中的最小元素
 * finMin操作最坏的情形下时间复杂度应该是O(1) ， 简单来讲，操作一次就可以得到最小值
 * @author Ralf
 *
 */
public class QuickMinStack {

	private MyStack<Integer> minStack = null;
	private MyStack<Integer> stack = null;
	
	public QuickMinStack(){
		minStack = new MyStack<>();
		stack = new MyStack<>();
	}
	public void push(int value){
		stack.push(value);
		if (minStack.isEmpty() || minStack.peek() >= value) {
			minStack.push(value);
		}
		else if (minStack.peek() < value) {
			minStack.push(minStack.peek());
		}
	}

	
	public int pop(){
		int value = stack.pop();
		minStack.pop();
		return value;
	}
	
	public int findMin(){
		if (!minStack.isEmpty()) {
			return minStack.peek();
		}
		return -1;
	}
}
