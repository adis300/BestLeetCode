package Voting.No169_MajorityElement;

import java.util.Arrays;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class Solution {

    // Smart algorithm.
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2]; // Needs to do more work on separate cases for odd number of items.
    }
    // Moore voting algorithm, 多者胜
    public int majorityElement3(int[] nums) {
        int count=0, majority = 0;
        for (int num: nums) {
            if (count==0)
                majority = num;
            if (num!=majority)
                count--;
            else
                count++;
        }
        return majority;
    }

    public int majorityElement(int[] nums) {
        if (nums.length < 3) return nums[0];

        int threshold = nums.length/2;
        Arrays.sort(nums);
        int next, current;
        int midUpperBound = (nums.length + 1)/2;
        for(int i = 0; i < midUpperBound; i++){
            current = nums[i];
            next = nums[i + 1];
            if(next == current){
                if(nums[i + threshold] == current) return current;
                while (next != current && i < midUpperBound){
                    ++i;
                    current = nums[i];
                    next = nums[i+1];
                }
            }
        }
        return 0;
    }

    public static void main(String[] args){
        new Solution().majorityElement3(new int[]{7,3,3});
    }
}
