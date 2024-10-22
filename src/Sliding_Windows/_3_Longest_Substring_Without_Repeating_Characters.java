package Sliding_Windows;

import java.util.LinkedList;
/**
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *  Input: s = "abcabcbb"
 *  Output: 3
 *  Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 *  Input: s = "bbbbb"
 *  Output: 1
 *  Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 *  Input: s = "pwwkew"
 *  Output: 3
 *  Explanation: The answer is "wke", with the length of 3.
 *  Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * Constraints:
 *  0 <= s.length <= 5 * 104
 *  s consists of English letters, digits, symbols and spaces.
 * */
public class _3_Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        LinkedList<Character> curSub = new LinkedList<>();
        int longestSubstring = 0;

        for (int i=0; i<s.length(); i++) {
            while(curSub.contains(s.charAt(i))) {
                curSub.removeFirst();
            }
            curSub.add(s.charAt(i));
            longestSubstring = Math.max(longestSubstring, curSub.size());
        }

        return longestSubstring;
    }
}
