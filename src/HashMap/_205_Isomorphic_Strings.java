package HashMap;

import java.util.HashMap;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character
 * while preserving the order of characters.
 * No two characters may map to the same character, but a character may map to itself.
 *
 * Example 1:
     * Input: s = "egg", t = "add"
     * Output: true
     * Explanation:
     * The strings s and t can be made identical by:
     * Mapping 'e' to 'a'.
     * Mapping 'g' to 'd'.
 *
 * Example 2:
     * Input: s = "foo", t = "bar"
     * Output: false
     * Explanation:
     * The strings s and t can not be made identical as 'o' needs to be mapped to both 'a' and 'r'.
 *
 * Example 3:
     * Input: s = "paper", t = "title"
     * Output: true
 *
 * Constraints:
 * 1 <= s.length <= 5 * 104
 * t.length == s.length
 * s and t consist of any valid ascii character.
*/
public class _205_Isomorphic_Strings {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> charMap = new HashMap<>();
        // Create a HashMap with key-value is sChar-tChar
        // Return false in following scenarios:
            // if - charMap already contains key sChar and value is not tChar
            // else if - charMap already contains value tChar
        for (int i=0; i<s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (charMap.containsKey(sChar)) {
                if (charMap.get(sChar) != tChar) return false;
            } else if (charMap.containsValue(tChar)) {
                return false;
            }

            charMap.put(sChar, tChar);
        }

        return true;
    }
}
