package Sum.No16_3SumClosest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 */
public class Solution {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];
        int mid, low, high, sum;

        for(low = 0; low < nums.length - 2; low ++){

            if (low - 1 >= 0 && nums[low] == nums[low - 1]) continue;

            mid = low + 1; high = nums.length - 1;

            while (mid < high){
                sum = nums[low] + nums[mid] + nums[high];
                if(Math.abs(sum - target) < Math.abs(closestSum - target)) closestSum = sum;
                if(sum < target) ++mid;
                else if (sum > target) --high;
                else return sum;
            }
        }
        return closestSum;
    }

}
