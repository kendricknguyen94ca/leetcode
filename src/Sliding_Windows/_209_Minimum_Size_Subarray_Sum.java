package Sliding_Windows;
/**
 * Given an array of positive integers nums and a positive integer target,
 * return the minimal length of a sub array whose sum is greater than or equal to target.
 * If there is no such subarray, return 0 instead.
 *
 * Example 1:
 *  Input: target = 7, nums = [2,3,1,2,4,3]
 *  Output: 2
 *  Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 *
 * Example 2:
 *  Input: target = 4, nums = [1,4,4]
 *  Output: 1
 *
 * Example 3:
 *  Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 *  Output: 0
 *
 * Constraints:
 *  1 <= target <= 109
 *  1 <= nums.length <= 105
 *  1 <= nums[i] <= 104
 *
 * Follow up: If you have figured out the O(n) solution,
 * try coding another solution of which the time complexity is O(n log(n)).
 * */
public class _209_Minimum_Size_Subarray_Sum {
    public int minSubArrayLen(int target, int[] nums) {
        int lPointer = -1, cur=0, minLength=Integer.MAX_VALUE;
        for (int rPointer=0; rPointer<nums.length; rPointer++) {
            cur += nums[rPointer];
            while (cur >= target) {
                int curLength = rPointer-lPointer;
                minLength = Math.min(minLength, curLength);
                lPointer++;
                cur -= nums[lPointer];
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
