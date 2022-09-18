package telran.collections.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.StackInt;
import java.util.*;

class StackIntTest {
	StackInt stack = new StackInt();
	StackInt stackNotEmpty = new StackInt();
	Integer[] forStack = new Integer[]{3, 4, 15, 2, 7, 12};
	@BeforeEach
	void setUp () {
		fillStack();
	}
	private void fillStack() {
		for(int i = 0; i<forStack.length; i++) {
			stackNotEmpty.push(forStack[i]);
		}
	}
	@Test
	void testPop() {
		assertThrows(NoSuchElementException.class, ()-> stack.pop());
		assertEquals(12, stackNotEmpty.pop());
	}

	@Test
	void testPush() {
		stackNotEmpty.push(1);
		assertTrue(stackNotEmpty.getLast()==1);
	}

	@Test
	void testIsEmpty() {
		assertTrue(stack.isEmpty());
		assertFalse(stackNotEmpty.isEmpty());
		for(int  i = forStack.length; i>0;i--) {
			stackNotEmpty.pop();
		}
		assertTrue(stackNotEmpty.isEmpty());
	}

	@Test
	void testGetMaxNumber() {
		assertTrue(15==stackNotEmpty.getMaxNumber());
		stackNotEmpty.push(30);
		assertTrue(30==stackNotEmpty.getMaxNumber());
		stackNotEmpty.pop();
		assertTrue(15==stackNotEmpty.getMaxNumber());
		for(int  i = 4; i>0;i--) {
			stackNotEmpty.pop();// remove all obj in stack until max number/ now max number must change
		}
		assertTrue(4==stackNotEmpty.getMaxNumber());
		assertThrows(NoSuchElementException.class, ()-> stack.getMaxNumber());

	}

}
