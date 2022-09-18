package telran.util;

import java.util.NoSuchElementException;

public class StackInt {
	private static class Node {
		Integer obj;
		Integer max;
		Node prev;
		Node(Integer obj) {
			this.obj = obj;
		}
	}
	private Node tail;
public int pop() {
	if(tail == null) {
		throw new NoSuchElementException();	
	}else {
		int res = tail.obj;
		tail = tail.prev; 
		return res;
	}
}
public void push(int number) {
	Node newNode = new Node(number);
	if (tail == null) {
		newNode.max = number;
		tail = newNode;
	} else {
		newNode.max = number>tail.max ? number : tail.max;
		newNode.prev = tail;
		tail = newNode;
	}
}
public boolean isEmpty() {
	return tail == null;
}
public int getMaxNumber() {
	if(tail == null) {
		throw new NoSuchElementException();	
	}
	return tail.max;
}
/**
 * method for push test
 * @return last object in a stack
 */
public int getLast() {
	return tail.obj;
}
}