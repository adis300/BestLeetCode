package Voting.No229_MajorityElementII;

import java.util.LinkedList;
import java.util.List;

/**
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 * The algorithm should run in linear time and in O(1) space.
 */
public class Solution {

    // Moore voting algorithm
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new LinkedList<>();
        int first = 0, second = 0, firstCount = 0, secondCount = 0;
        for (int i = 0; i < nums.length; i ++){
            if (first == nums[i]) ++ firstCount;
            else if (second == nums[i]) ++ secondCount;
            else if (firstCount == 0){
                first = nums[i];
                firstCount = 1;
            }else if(secondCount == 0){
                second = nums[i];
                secondCount = 1;
            }else{
                --firstCount; -- secondCount;
            }
        }
        firstCount = 0; secondCount = 0;
        for (int i = 0; i < nums.length; i ++){
            if (nums[i] == first)
                ++ firstCount;
            else if(nums[i] == second)
                ++ secondCount;
        }
        if (firstCount > nums.length / 3) res.add(first);
        if (secondCount > nums.length / 3) res.add(second);

        return res;
    }

}
