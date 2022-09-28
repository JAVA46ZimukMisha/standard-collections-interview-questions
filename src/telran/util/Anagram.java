package telran.util;

import java.util.HashMap;
import java.util.Map;

public class Anagram {
/**
 * 
 * @param word
 * @param anagram
 * @return true if anagram is one of the possible anagrams of a given word
 * anagram is a string containing all symbols from a given word with different order
 * Example: yellow (wolely, lowlye, yellow) , wrong anagrams (yello, yelllw)
 */
	public static boolean isAnagram(String word, String anagram) {
		Map<Integer, Integer> mapWord = getMapOccurrences(word);
		Map<Integer, Integer> mapAnagram = getMapOccurrences(anagram);
	return mapWord.equals(mapAnagram);
}

private static Map<Integer, Integer> getMapOccurrences(String stringWord) {
	char[] wordChar = stringWord.toCharArray();
	Map<Integer, Integer> res = new HashMap<>();
	for (char c: wordChar) {
		Integer count = res.getOrDefault((int) c, 0);
		res.put((int)c, count + 1);
	}
	return res;
}
}