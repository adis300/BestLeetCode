package Sum.No167_TwoSumII;

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 *
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {

        int low = 0, high = nums.length - 1, sum;

        while(low < high){
            sum = nums[low] + nums[high];
            if(sum < target) ++ low;
            else if (sum > target) -- high;
            else return new int[]{low + 1, high + 1};
        }

        return new int[]{};
    }

}
