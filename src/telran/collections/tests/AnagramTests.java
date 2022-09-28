package telran.collections.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.util.Anagram;

class AnagramTests {

	@Test
	void testIsAnagram() {
		assertTrue(Anagram.isAnagram("yellow", "lloyew"));
		assertTrue(Anagram.isAnagram("yellow", "wolley"));
		assertTrue(Anagram.isAnagram("yellow", "lewlyo"));
		assertTrue(Anagram.isAnagram("yellow", "yellow"));
		assertFalse(Anagram.isAnagram("yellow", "lllew"));
		assertFalse(Anagram.isAnagram("yellow", ""));
		assertFalse(Anagram.isAnagram("yellow", "yellov"));
		
		
	}

}