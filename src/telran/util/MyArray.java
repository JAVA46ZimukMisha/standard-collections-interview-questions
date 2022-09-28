package telran.util;

import java.util.HashMap;
import java.util.HashSet;

/**
 * All methods of the class should have complexity O[1]
 * 
 * @author User
 *
 * @param <T>
 */
public class MyArray<T> {
//TODO fields
	int size;
	T forAll = null;
	HashMap<Integer, T> hashMapArray = new HashMap<>();
	HashSet<Integer> forKeys;

	public MyArray(int size) {
		this.size = size;
		this.forKeys = getForKeys(size);
	}

	private HashSet<Integer> getForKeys(int size2) {
		this.forKeys = new HashSet<>();
		for (int i = 0; i < size; i++) {
			forKeys.add(i);
		}
		return forKeys;
	}

	/**
	 * sets all array's elements with a given value
	 * 
	 * @param value
	 */
	public void setAll(T value) {
		forAll = value;
		this.hashMapArray = new HashMap<>();
	}

	/**
	 * 
	 * @param index
	 * @return value at given index or null if index is wrong
	 */
	public T get(int index) {
		if (this.hashMapArray.containsKey(index)) {
			return this.hashMapArray.get(index);
		} else if (forKeys.contains(index)) {
			return forAll;
		} else {
			return null;
		}
	}

	/**
	 * sets a given value at a given index throws IndexOutOfBoundsException in the
	 * case of wrong index
	 * 
	 * @param index
	 * @param value
	 */
	public void set(int index, T value) {
		if (!this.forKeys.contains(index)) {
			throw new IndexOutOfBoundsException();
		} else {
			this.hashMapArray.put(index, value);
		}
	}
}