package Bitwise._No260_SingleNumberIII;

import java.util.Arrays;

/**
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

 For example:

 Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

 Note:
 The order of the result is not important. So in the above example, [5, 3] is also correct.
 Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?

 */
public class Solution {

    public int[] singleNumber1(int[] nums) {
        // Pass 1 :
        // Get the XOR of the two numbers we need to find
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        // Get its last set bit
        diff &= -diff; //Taking advantage of adding one bit at the inversion step.

        // Pass 2 :
        int[] rets = {0, 0}; // this array stores the two numbers we will return
        for (int num : nums)
        {
            if ((num & diff) == 0) // the last bit is not set for this group of numbers
                rets[0] ^= num;
            else // the bit is set or this group of numbers
                rets[1] ^= num;
        }
        return rets;
    }

    public int[] singleNumber(int[] nums) {
        Arrays.sort(nums);
        int[] res = new int[2];
        boolean check = false; int previousNum = 0; int counter = 0;
        for (int i = 0; i < nums.length; i ++){
            if(check){
                if(nums[i] == previousNum){
                    check = false;
                }else{
                    res[counter ++] = previousNum;
                    previousNum = nums[i];
                    check = true;
                    if(counter == 2) return res;
                }
            } else{
                previousNum = nums[i];
                check = true;
            }
        }
        if(check) res[1] = previousNum;
        return res;
    }

    public static void main(String[] args){
        new Solution().singleNumber1(new int[]{1,2,1,3,2,5});
    }

}
