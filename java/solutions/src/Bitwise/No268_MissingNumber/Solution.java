package Bitwise.No268_MissingNumber;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * For example,
 * Given nums = [0, 1, 3] return 2.
 *
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 *
 */

public class Solution {
    // Using a hash set, linear space requirement
    public int missingNumber(int[] nums) {
        int n = nums.length + 1;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i ++){
            set.add(i);
        }
        for (int i : nums){
            set.remove(i);
        }
        return (Integer)set.toArray()[0];
    }

    // 1.XOR
    public int missingNumber1(int[] nums) { //xor
        int res = nums.length;
        for(int i=0; i<nums.length; i++){
            res ^= i;
            res ^= nums[i];
        }
        return res;
    }
    // 2.SUM
    public int missingNumber2(int[] nums) { //sum
        int N = nums.length * (nums.length + 1) / 2;
        for (int i: nums)
            N -= i;
        return N;
    }
    //3.Binary Search
    public int missingNumber3(int[] nums) { //binary search
        //
        Arrays.sort(nums);
        int left = 0, right = nums.length, mid;

        while(left < right){
            mid = (left + right)/2;
            if (nums[mid] > mid) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}
