package com.ralf.stack;

import java.security.PublicKey;
import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * 使用一个数组实现两个栈：第一个栈底是数组的起始位置，第二个栈底是数组的尾部，
 * 当添加元素时，两个指针分别向中间移动，当两个指针重合时，需要扩容。
 * @author Administrator
 *
 */
public class TwoStacksInOneArray<E> {

	E[] elements = null;
	private static final int DEFAULT_SIZE = 5;
	private int left;
	private int right;
	
	public TwoStacksInOneArray(){
		elements = (E[]) new Object[DEFAULT_SIZE];
		left = -1;
		right = DEFAULT_SIZE;
	}
	/**
	 * 扩容处理
	 * @param size
	 */
	private void ensureCapacity(int size){
		E[] newArr = (E[]) new Object[size * 2 + 1];
		
		for (int i = 0; i <= left; i++) {
			newArr[i] = elements[i];
		}
		for (int i = 0; i < elements.length - left; i++) {
			newArr[newArr.length - 1 -i] = elements[elements.length - 1 -i];
		}
		right = newArr.length - elements.length/2;
		elements = newArr;		
		
	}
	
	/**
	 * 向第一个栈加入元素
	 * @param e
	 */
	public void push1(E e){
		
		if (left == right - 1) {
			ensureCapacity(elements.length);
		}
		elements[++left] = e;
		
	}
	/**
	 * 从第一个栈取出元素
	 * @return
	 */
	public E pop1(){
		if (left < 0) {
			throw new NoSuchElementException("the stack1 is empty!");
		}
		E item = elements[left];
		elements[left] = null;
		left--;
		return item;
	}
	/**
	 * 第一个栈的栈顶元素
	 * @param e
	 */
	public E peek1(){
		if (left > -1) {
			return elements[left];
		}
		return null;
	}
	public boolean isEmpty1(){
		return left > -1;
	}
	
	/**
	 * 向第二个栈加入元素
	 * @param e
	 */
	public void push2(E e){
		if (right == left + 1) {
			ensureCapacity(elements.length);
		}
		elements[--right] = e;
	}
	
	/**
	 * 从第二个栈中弹出元素
	 * @return
	 */
	public E pop2(){
		if (right >= elements.length) {
			throw new NoSuchElementException("the stack2 is empty!");
		}
		E item = elements[right];
		elements[right] = null;
		right++;
		return item;
	}
	
	/**
	 * 第二个栈顶元素
	 * @return
	 */
	public E peek2(){
		if (right < elements.length) {
			return elements[right];
		}
		return null;
	}
	
	public boolean isEmpty2(){
		return right < elements.length;
	}
}
