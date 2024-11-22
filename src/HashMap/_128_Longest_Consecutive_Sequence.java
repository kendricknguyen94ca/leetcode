package HashMap;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * You must write an algorithm that runs in O(n) time.
 *
 * Example 1:
     * Input: nums = [100,4,200,1,3,2]
     * Output: 4
     * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 *
 * Example 2:
     * Input: nums = [0,3,7,2,5,8,4,6,0,1]
     * Output: 9
 *
 * Constraints:
     * 0 <= nums.length <= 105
     * -109 <= nums[i] <= 109
 * */
public class _128_Longest_Consecutive_Sequence {
    public int longestConsecutive(int[] nums) {
        int longest = 1;
        Set<Integer> numsSet = new HashSet<>();

        // Add nums in to a numsSet
        for (int num : nums) {
            numsSet.add(num);
        }

        // We'll start with the smallest num by verify if there's not num-1 in numsSet
        // Declare a length = 1, keep length+=1 as long as numsSet contains num+length to find the current consecutive elements sequence
        // When current consecutive elements sequence stops, find the longest sequence using Math.max(longest, length)
        for (int num : numsSet) {
            if (!numsSet.contains(num - 1)) {
                int length = 1;

                while (numsSet.contains(num+length)) {
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}
