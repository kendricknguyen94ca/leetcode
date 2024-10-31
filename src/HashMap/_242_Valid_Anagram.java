package HashMap;

import java.util.HashMap;

public class _242_Valid_Anagram {
    public boolean isAnagram(String s, String t) {
        // Return false if s and t have different length
        if (s.length() != t.length()) return false;

        // Count all character in s and put in a HashMap
        HashMap<Character,Integer> sMap = new HashMap<>();
        for (char sChar : s.toCharArray()) {
            sMap.put(sChar, sMap.getOrDefault(sChar, 0) + 1);
        }

        // For every char found in t (tChar), -1 its index in sMap
        // Return false if tChar not found or sMap.get(tChar) <= 0
        for (char tChar : t.toCharArray()) {
            if (!sMap.containsKey(tChar) || sMap.get(tChar) <= 0)
                return false;

            sMap.put(tChar, sMap.get(tChar) - 1);
        }

        return true;
    }
}
