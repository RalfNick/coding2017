package com.ralf.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ralf.queue.MyQueue;

public class BinarySearchTree<T extends Comparable> {

	private BinaryTreeNode root;

	public BinarySearchTree(BinaryTreeNode root) {
		this.root = root;
	}

	public BinaryTreeNode getRoot() {
		return root;
	}

	public T findMin(BinaryTreeNode t) {

		if (t.getData() == null) {
			return null;
		}
		if (t.getLeft() == null) {
			return (T) t.getData();
		} else {
			return this.findMin(t.getLeft());
		}

	}

	public T findMax(BinaryTreeNode t) {
		if (t.getData() == null) {
			return null;
		}
		if (t.getRight() == null) {
			return (T) t.getData();
		} else {
			return this.findMax(t.getRight());
		}
	}

	public int height(BinaryTreeNode t) {
		if (t == null) {
			return 0;
		}
		int leftNum = height(t.getLeft());
		int rightNum = height(t.getRight());

		return leftNum > rightNum ? leftNum + 1 : rightNum + 1;
	}

	public int size(BinaryTreeNode t) {
		if (t == null) {
			return 0;
		}
		return size(t.getLeft()) + 1 + size(t.getRight());
	}

	public void remove(T e) {
		remove(root, e);
	}

	private BinaryTreeNode remove(BinaryTreeNode root, T e) {
		if (root == null) {
			return null;
		}
		int result = root.getData().compareTo(e);
		if (result > 0) {
			root.setLeft(remove(root.getLeft(), e));

		} else if (result < 0) {
			root.setRight(remove(root.getRight(), e));

		} else {
			if (root.getLeft() != null && root.getRight() != null) {
				T data = findMin(root.getRight());
				root.setData(data);
				root.setRight(remove(root.getRight(), data));
			}
			else {
				root = (root.getLeft() != null)? root.getLeft() : root.getRight();
			}
		}
		return root;

	}

	public List<T> levelVisit() {

		List<T> list = new ArrayList<>();
		MyQueue<BinaryTreeNode> queue = new MyQueue<>();
		queue.enQueue(root);
		while(!queue.isEmpty()){
			BinaryTreeNode current = queue.deQueue();
			list.add((T)current.getData());
			if (current.getLeft() != null) {
				queue.enQueue(current.getLeft());
			}
			if (current.getRight() != null) {
				queue.enQueue(current.getRight());
			}
		}
		return list;
	}

	public boolean isValid() {
		return isValid(root);
	}
	
	private boolean isValid(BinaryTreeNode root) {
		if (root == null) {
			return true;
		}
		if (root.getLeft() != null && root.getLeft().getData().compareTo(root.getData()) > 0) {
			return false;
		}
		if (root.getRight() != null && root.getRight().getData().compareTo(root.getData()) < 0) {
			return false;
		}
		if (!isValid(root.getLeft()) || !isValid(root.getRight())) {
			return false;
		}
		return false;
	}

	public T getLowestCommonAncestor(T n1, T n2){
		if (root == null) {
			return null;
		}
		return lowestCommonAncestor(root,n1,n2);
        
	}
	private T lowestCommonAncestor(BinaryTreeNode root, T n1, T n2) {

		if (root.getData() == n1 || root.getData() == n2) {
			return null;
		}
		if (root.getLeft() != null && (root.getLeft().getData().compareTo(n1) ==0 || root.getLeft().getData().compareTo(n2) == 0)) {
			return (T) root.getData();
		}
		if (root.getRight() != null && (root.getRight().getData().compareTo(n1) ==0  || root.getRight().getData().compareTo(n2) == 0)) {
			return (T) root.getData();
		}
		if (root.getLeft().getData().compareTo(n1) > 0 && root.getRight().getData().compareTo(n2) < 0) {
			return (T) root.getData();
		}
		if (root.getData().compareTo(n1) > 0 && root.getData().compareTo(n2) > 0) {
			return lowestCommonAncestor(root.getLeft(), n1, n2);
		}
		if (root.getData().compareTo(n1) < 0 && root.getData().compareTo(n2) < 0) {
			return lowestCommonAncestor(root.getRight(), n1, n2);
		}
		return null;
	}

	public List<T> getNodesBetween(T n1, T n2){
		
		if (root == null) {
			return null;
		}
		List<T> list = new ArrayList<>();
		getNodesBetween(list, n1, n2);
		return list;
	}

	private void getNodesBetween(List<T> list, T n1, T n2) {
		
		List<T> allList = BinaryTreeUtil.preOrderVisit(root);
		for(T t : allList){
			int r1 = t.compareTo(n1);
			int r2 = t.compareTo(n2);
			if (r1 > 0 && r2 < 0) {
				list.add(t);
			}
		}
	}
}
