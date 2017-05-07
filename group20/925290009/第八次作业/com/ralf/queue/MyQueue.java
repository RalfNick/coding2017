package com.ralf.queue;

/**
 * 队列，有头有尾
 * @author Administrator
 *
 */
public class MyQueue<E>{

	private Node<E> head;
	private Node<E> last;
	private int size;
	
	private static class Node<E>{
		
		private Node<E> next;
		private E item;
	}
	
	public MyQueue(){
		head = null;
		last = null;
		size = 0;
	}
	
	public boolean isEmpty(){
		return head == null;
	}
	
	public int size(){
		return size;
	}
	
	public void enQueue(E item){
		Node<E> oldNode = last;
		Node<E> newNode = new Node<>();
		newNode.item = item;
		newNode.next = null;
		last = newNode;
		
		if (isEmpty()) {
			head = newNode;
		}
		else {
			oldNode.next = last;
		}
		size++;
	}
	
	public E deQueue(){
		if (isEmpty()) {
			throw new RuntimeException("the queue is underflow!");
		}
		E item = head.item;
		head = head.next;
		size--;
		if (isEmpty()) {
			last = null;
		}
		return item;
	}
}