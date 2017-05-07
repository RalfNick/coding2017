package com.ralf.stack;

import java.util.NoSuchElementException;

/**
 * ���һ��ջ��֧��ջ��push��pop�������Լ������ֲ���findMin, �����ظ����ݽṹ�е���СԪ��
 * finMin�������������ʱ�临�Ӷ�Ӧ����O(1) �� ������������һ�ξͿ��Եõ���Сֵ
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
