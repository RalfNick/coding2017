package com.ralf.queue;

/**
 * 用数组实现循环队列
 * 
 * @author Administrator
 * 
 */
public class CircleQueue<E> {

	private static final int DEFAULT_SIZE = 10;
	private E[] elements;

	private int front;
	private int tail;
	private int size;

	public CircleQueue() {
		elements = (E[]) new Object[DEFAULT_SIZE];
		size = DEFAULT_SIZE;
		front = 0;
		tail = 0;
	}
	
	public CircleQueue(int size){
		elements = (E[]) new Object[size];
		this.size = size;
		front = 0;
		tail = 0;
	}

	public boolean isEmpty() {
		return elements[front] == null;
	}

	public void enQueue(E e) {

		if (tail == front && elements[front] != null) {
			throw new RuntimeException("the queue is overflow!");
		}
		elements[tail] = e;
		tail++;
		if (tail == size) {
			tail = 0;
		}
	}

	public E deQueue() {

		if (isEmpty()) {
			throw new RuntimeException("the queue is underflow!");
		}
		E item = elements[front];
		elements[front] = null;
		front++;
		if (front == size) {
			front = 0;
		}
		return item;
	}

	public int size() {
		if (isEmpty()) {
			return 0;
		}
		return tail > front ? tail - front : size - (front - tail);
	}
}
