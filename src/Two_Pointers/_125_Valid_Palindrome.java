package Two_Pointers;

/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
 * and removing all non-alphanumeric characters, it reads the same forward and backward.
 * Alphanumeric characters include letters and numbers.
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
 * Example 1:
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 *
 * Example 2:
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 *
 * Example 3:
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric characters.
 * Since an empty string reads the same forward and backward, it is a palindrome.
 *
 * Constraints:
 * 1 <= s.length <= 2 * 105
 * s consists only of printable ASCII characters.
 * */
public class _125_Valid_Palindrome {
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return true; // An empty string is considered a palindrome.
        }
        String t = s.toLowerCase().replaceAll("[^a-zA-Z0-9]","");
        int start = 0;
        int end = t.length()-1;
        while (start < end) {
            if (t.charAt(start) == t.charAt(end)) {
                start++;
                end--;
            } else return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String example1 = "A man, a plan, a canal: Panama";
        String example2 = "race a car";
        _125_Valid_Palindrome test = new _125_Valid_Palindrome();
        System.out.println(test.isPalindrome(example1));
        System.out.println(test.isPalindrome(example2));
    }
}
