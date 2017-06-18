package DP._No377_CombinationSumIv;

import java.util.Arrays;
/**
 * Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.

 Example:

 nums = [1, 2, 3]
 target = 4

 The possible combination ways are:
 (1, 1, 1, 1)
 (1, 1, 2)
 (1, 2, 1)
 (1, 3)
 (2, 1, 1)
 (2, 2)
 (3, 1)

 Note that different sequences are counted as different combinations.

 Therefore the output is 7.

 Follow up:
 What if negative numbers are allowed in the given array?
 How does it change the problem?
 What limitation we need to add to the question to allow negative numbers?

 */
public class Solution {

    public int combinationSum4_1(int[] nums, int target) {
        Arrays.sort(nums);
        int[] dp= new int[target+1];
        dp[0] = 1;
        for(int i = 1; i <= target;i++){
            for(int num:nums){
                if (num > i) break;
                else dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }

    // Solved with dynamic programming
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] res = new int[target + 1];
        for (int i = 1; i < res.length; i++) {
            for (int num : nums) {
                if (num > i)
                    break;
                else if (num == i)
                    res[i] += 1;
                else
                    res[i] += res[i-num];
            }
        }
        return res[target];
    }

    public static void main(String[] args){
        new Solution().combinationSum4(new int[]{1,2}, 3);
    }

    /*
    private int target;
    private int[] candidates;
    private int resultCount = 0;

    public void testAdd(int currentSum, int startIndex){

        if (currentSum >= target){
            if (currentSum == 0) ++ resultCount;
            return;
        }

        // CurrentSum is less, now proceed to recursion
        for (int i = startIndex; i < candidates.length; i ++){
            // Skip duplicates //
            // if (i > startIndex && candidates[i] == candidates[i - 1]) continue;

            testAdd(currentSum + candidates[i], startIndex);
        }

    }

    public int combinationSum4(int[] nums, int target) {
        this.candidates = nums;
        this.target = target;

        testAdd(0, 0);
        return resultCount;
    }
    */

}
