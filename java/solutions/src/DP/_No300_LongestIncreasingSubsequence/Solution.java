package DP._No300_LongestIncreasingSubsequence;

import java.util.Arrays;

/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.

 For example,
 Given [10, 9, 2, 5, 3, 7, 101, 18],
 The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4.
 Note that there may be more than one LIS combination, it is only necessary for you to return the length.

 Your algorithm should run in O(n2) complexity.

 Follow up: Could you improve it to O(n log n) time complexity?
 */
public class Solution {

    // Make use of binary search and put the most reasonable length by doing a binarySearch insert
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {

            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1); //(-(insertion point) - 1) = i ;   - i - 1 = insersion
            dp[i] = x;
            if(i == len) ++len;
        }

        return len;
    }

    public int lengthOfLIS1(int[] nums) {
        int[] dp = new int[nums.length];
        for(int i = 0; i < dp.length; i ++) dp[i] = 1;// Initialize subsequence values

        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args){
        new Solution().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
    }

}
