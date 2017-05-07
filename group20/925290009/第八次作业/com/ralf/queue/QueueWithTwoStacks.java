package com.ralf.queue;

import com.ralf.stack.MyStack;

/**
 * 利用两个栈实现队列
 * @author Administrator
 *
 */
public class QueueWithTwoStacks<T> {
	
	private MyStack<T>	stack_in = null;
	private MyStack<T>	stack_out = null;
	
	public QueueWithTwoStacks(){
		stack_in = new MyStack<>();
		stack_out = new MyStack<>();
	}
	
	public boolean isEmpty(){
		return stack_in.isEmpty() && stack_out.isEmpty();
	}
	public void enQueue(T t){
		stack_in.push(t);
	}
	
	public T deQueue(){
		if (isEmpty()) {
			throw new RuntimeException("the queue is underflow!");
		}
		if (stack_out.isEmpty()) {
			while(!stack_in.isEmpty()){
				stack_out.push(stack_in.pop());
			}
		}
		return stack_out.pop();
	}
	
	public int size(){
		return stack_in.size() + stack_out.size();
	}
}
