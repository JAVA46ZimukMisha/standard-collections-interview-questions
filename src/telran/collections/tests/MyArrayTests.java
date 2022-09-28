package telran.collections.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.MyArray;

class MyArrayTests {
	int capacity = 10;
	MyArray<Integer> example = new MyArray<>(capacity);

	@BeforeEach
	void setUp() {
		Integer value = 0;
		for (int i = 0; i < capacity; i++) {
				example.set(i, value++);
		}
	}

	@Test
	void testSetAll() {
		example.setAll(100);
		for (int i = 0; i < capacity; i++) {
			assertTrue(example.get(i).equals(100));
		}
	}

	@Test
	void testGet() {
		Integer val = 0;
		for(int i = 0; i< capacity; i++) {
			assertTrue(example.get(i).equals(val++));
		}
		example.setAll(200);
		example.set(3, 5);
		assertTrue(example.get(0).equals(200));
		assertTrue(example.get(1).equals(200));
		assertTrue(example.get(3).equals(5));
	}

	@Test
	void testSet() {
			example.set(2, 9);
		assertTrue(example.get(2).equals(9));
	}
}