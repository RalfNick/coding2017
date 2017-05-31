package com.ralf.tree;

public class BinaryTreeNode<T extends Comparable<T>> {

	public T data;
	public BinaryTreeNode<T> left;
	public BinaryTreeNode<T> right;
	
	public BinaryTreeNode(T data){
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public BinaryTreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}

	public BinaryTreeNode<T> getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}
	
	public BinaryTreeNode<T> insert(T t){
		if (this.data == null) {
			this.data = t;
			return this;
		}
		int result = this.data.compareTo(t);
		if (result > 0) {
			if (this.left == null) {
				BinaryTreeNode<T> node = new BinaryTreeNode<>(t);
				this.left = node;
				return this.left;
			}
			else {
				return this.left.insert(t);
			}
		}
		else if (result < 0) {
			if (this.right == null) {
				BinaryTreeNode<T> node = new BinaryTreeNode<>(t);
				this.right = node;
				return this.right;
			}
			else {
				return this.right.insert(t);
			}
		}
		return this;
	}
	
	public BinaryTreeNode<T> search(T t){
		if (this.data == null) {
			return null;
		}
		int result = this.data.compareTo(t);
		if (result > 0) {
			if (this.left == null) {
				return null;
			}
			else {
				return this.left.search(t);
			}
		}
		else if (result < 0) {
			if (this.right == null) {
				return null;
			}
			else {
				return this.right.search(t);
			}
		}
		return this;
	}
	
}
