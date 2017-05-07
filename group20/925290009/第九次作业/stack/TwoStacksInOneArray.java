package com.ralf.stack;

import java.security.PublicKey;
import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * ʹ��һ������ʵ������ջ����һ��ջ�����������ʼλ�ã��ڶ���ջ���������β����
 * �����Ԫ��ʱ������ָ��ֱ����м��ƶ���������ָ���غ�ʱ����Ҫ���ݡ�
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
	 * ���ݴ���
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
	 * ���һ��ջ����Ԫ��
	 * @param e
	 */
	public void push1(E e){
		
		if (left == right - 1) {
			ensureCapacity(elements.length);
		}
		elements[++left] = e;
		
	}
	/**
	 * �ӵ�һ��ջȡ��Ԫ��
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
	 * ��һ��ջ��ջ��Ԫ��
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
	 * ��ڶ���ջ����Ԫ��
	 * @param e
	 */
	public void push2(E e){
		if (right == left + 1) {
			ensureCapacity(elements.length);
		}
		elements[--right] = e;
	}
	
	/**
	 * �ӵڶ���ջ�е���Ԫ��
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
	 * �ڶ���ջ��Ԫ��
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
