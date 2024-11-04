package HashMap;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number n is happy.
 *
 * A happy number is a number defined by the following process:
 *
 *  Starting with any positive integer, replace the number by the sum of the squares of its digits.
 *  Repeat the process until the number equals 1 (where it will stay),
 *      or it loops endlessly in a cycle which does not include 1.
 *  Those numbers for which this process ends in 1 are happy.
 *  Return true if n is a happy number, and false if not.
 *
 * Example 1:
     * Input: n = 19
     * Output: true
     * Explanation:
     * 12 + 92 = 82
     * 82 + 22 = 68
     * 62 + 82 = 100
     * 12 + 02 + 02 = 1
 *
 * Example 2:
     * Input: n = 2
     * Output: false
 *
 * Constraints:
     * 1 <= n <= 231 - 1
 * */
public class _202_Happy_Number {
    // Create a helper function to compute the sum of squares of digits.
    private int isHappyNumber(int n) {
        int sum = 0;
        while (n>0) {
            int digit = n%10;
            sum += (digit*digit);
            n /= 10;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        // Initialize a set to store numbers seen in the process.
        Set<Integer> finalVal = new HashSet<>();
        // Repeat the following until we reach 1 or a cycle is detected:
        while (n!=1 && !finalVal.contains(n)) { // If the result is already in the set, break the loop.
            // Add the result to the set and continue.
            finalVal.add(n);
            // Calculate the sum of squares of the digits.
            n = isHappyNumber(n);
        }
        // If the result is 1, return true
        // Else, return false
        return n==1;
    }
}
