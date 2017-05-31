package com.ralf.tree;

import java.util.ArrayList;
import java.util.List;

import com.ralf.stack.MyStack;

public class BinaryTreeUtil {

	/**
	 * �õݹ�ķ�ʽǰ�����
	 * @param root
	 * @return
	 */
	public static<T> List<T> preOrderVisit(BinaryTreeNode root){
		List<T> list = new ArrayList<T>();
		 if (root.getData() == null) {
			return null;
		}
		 preOrder(list,root);
		 
		return list;
	}
	private static<T> void preOrder(List<T> list, BinaryTreeNode root){
		if (root != null) {
			list.add((T) root.getData());
			preOrder(list, root.getLeft());
			preOrder(list, root.getRight());
		}
	}
	
	/**
	 * �õݹ�ķ�ʽʵ�ֶԶ��������б���
	 * 
	 * @param root
	 * @return
	 */
	public static <T> List<T> inOrderVisit(BinaryTreeNode root) {
		List<T> list = new ArrayList<T>();
		if (root.getData() == null) {
			return null;
		}
		inOrder(list,root);
		return list;
	}
	private static<T> void inOrder(List<T> list, BinaryTreeNode root){
		if (root == null) {
			return;
		}
		inOrder(list, root.getLeft());
		list.add((T) root.getData());
		inOrder(list, root.getRight());
	} 
	
	/**
	 * �õݹ�ķ�ʽʵ�ֶ������ĺ������
	 * @param root
	 * @return
	 */
	public static<T> List<T> postOrderVisit(BinaryTreeNode root){
		List<T> list = new ArrayList<>();
		if (root.getData() == null) {
			return null;
		}
		postOrder(list,root);
		return list;
	} 
	private static<T> void postOrder(List<T> list, BinaryTreeNode root){
		if (root == null) {
			return;
		}
		postOrder(list, root.getLeft());
		postOrder(list, root.getRight());
		list.add((T) root.getData());
	}
	
	/**
	 * �÷ǵݹ�ķ�ʽʵ�ֶԶ�������ǰ�����
	 * @param root
	 * @return
	 */
	public static <T> List<T> preOrderWithoutRecursion(BinaryTreeNode root) {
		
		List<T> list = new ArrayList<T>();	
		MyStack<BinaryTreeNode> stack = new MyStack<>();
		if (root == null) {
			return null;
		}
		stack.push(root);
		while(!stack.isEmpty()){
			BinaryTreeNode temp = stack.pop();
			list.add((T) temp.getData());
			if (temp.getRight() != null) {
				stack.push(temp.getRight());
			}
			if (temp.getLeft() != null) {
				stack.push(temp.getLeft());
			}
		}
		
		return list;
	}
	/**
	 * �÷ǵݹ�ķ�ʽʵ�ֶԶ��������������
	 * @param root
	 * @return
	 */
	public static <T> List<T> inOrderWithoutRecursion(BinaryTreeNode root) {
		
		List<T> list = new ArrayList<T>();
		MyStack<BinaryTreeNode> stack = new MyStack<>();
		if (root == null) {
			return null;
		}
		
		while(root != null){
			stack.push(root);
			root = root.getLeft();
		}
		while(!stack.isEmpty()){
			BinaryTreeNode left = stack.pop();
			list.add((T) left.getData());
			if (left.getRight() != null) {
				BinaryTreeNode right = left.getRight();
				while(right != null){
					stack.push(right);
					right = right.getLeft();
				}
			}
		}
		
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
