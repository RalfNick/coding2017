package com.ralf.stack;

import java.util.NoSuchElementException;

import com.ralf.queue.MyQueue;

/**
 * 利用两个队列实现栈
 * @author Administrator
 *
 */
public class StackWithTwoQueues<E> {

	private MyQueue<E> queue1 = null;
	private MyQueue<E> queue2 = null;
	
	public StackWithTwoQueues(){
		queue1 = new MyQueue<>();
		queue2 = new MyQueue<>();
	}
	
	public void push(E e){
		if (queue1.isEmpty() && queue2.isEmpty()) {
			queue1.enQueue(e);
			return;
		}
		if (queue1.isEmpty()) {
			queue2.enQueue(e);
			return;
		}
		if (queue2.isEmpty()) {
			queue1.enQueue(e);
			return;
		}
	}
	
	public E pop(){
		if (isEmpty()) {
			throw new NoSuchElementException("the stack is empty!");
		}
		if (queue1.isEmpty()) {
			while(queue2.size() > 1){
				queue1.enQueue(queue2.deQueue());
			}
			return queue2.deQueue();
		}
		if (queue2.isEmpty()) {
			while(queue1.size() > 1){
				queue2.enQueue(queue1.deQueue());
			}
			return queue1.deQueue();
		}
		return null;
	}
	
	public boolean isEmpty(){
		return queue1.isEmpty() && queue2.isEmpty();
	}
	
	public int size(){
		return queue1.size() + queue2.size();
	}
}
