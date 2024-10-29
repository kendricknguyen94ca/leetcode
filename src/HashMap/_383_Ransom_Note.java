package HashMap;

import java.util.HashMap;

/**
 * Given two strings ransomNote and magazine,
 * return true if ransomNote can be constructed by using the letters from magazine
 * and false otherwise.
 * Each letter in magazine can only be used once in ransomNote.
 *
 * Example 1:
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 *
 * Example 2:
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 *
 * Example 3:
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 *
 * Constraints:
 * 1 <= ransomNote.length, magazine.length <= 105
 * ransomNote and magazine consist of lowercase English letters.
*/
public class _383_Ransom_Note {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> magaHash = new HashMap<>();

        // Count every character in magazine String and put into a hash called magaHash
        for (char c : magazine.toCharArray()) {
            magaHash.put(c, magaHash.getOrDefault(c,0) + 1);
        }

        // Compare every char in ransomNote
        // -1 if detect in magaHash
        // If cannot detect ransomNote char in magaHash -> false
        // If every char in ransomNote are detected in magaHash -> true
        for (char c : ransomNote.toCharArray()) {
            if (!magaHash.containsKey(c) || magaHash.get(c) <= 0)
                return false;
            magaHash.put(c, magaHash.get(c) - 1);
        }

        return true;
    }
}
