package Array_String;

import java.util.Arrays;
/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 *
 * Example 2:
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 * Constraints:
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters.
 * */
public class _14_Longest_Common_Prefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuffer prefix = new StringBuffer();
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length-1];

        // Compare each char within compareString with other in the list
        // If there's a match, add char at index i to prefix
        // Else reset prefix to current char
        for (int i=0; i<(Math.min(first.length(), last.length())); i++) {
            if(first.charAt(i)!=last.charAt(i)) return prefix.toString();
            prefix.append(first.charAt(i));
        }

        return prefix.toString();
    }

    public static void main(String[] args) {
        String[] example1 = {"flower","flow","flight"};
        String[] example2 = {"dog","racecar","car"};
        _14_Longest_Common_Prefix test = new _14_Longest_Common_Prefix();
        System.out.println(test.longestCommonPrefix(example1));
        System.out.println(test.longestCommonPrefix(example2));
    }
}
