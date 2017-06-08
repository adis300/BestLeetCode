package No18_4Sum;

import java.util.*;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 */
public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> results = new LinkedList<>();
        if(nums.length < 4) return results;

        Arrays.sort(nums);

        if (4 * nums[0] > target || 4 * nums[nums.length - 1] < target)
            return results;

        int left, low, high, right, sum;
        for(left = 0; left < nums.length - 3; left ++){

            if (left > 0 && nums[left] == nums[left - 1]) continue;
            // Skip loop if boundary condition fails
            if (3 * nums[left + 1] + nums[left]> target  || 3 * nums[nums.length - 1] + nums[left] < target) continue;

            for(low = left + 1; low < nums.length - 2; low ++){

                if (low - 1 > left && nums[low] == nums[low - 1]) continue;
                // Skip loop if boundary condition fails
                // if (2 * nums[low + 1] + nums[left] + nums[low] > target  || 2 * nums[nums.length - 1] + nums[low] + nums[left] < target) continue;

                high = low + 1; right = nums.length - 1;
                while (high < right){
                    sum = nums[left] + nums[low] + nums[high] + nums[right];

                    if(sum < target) ++high;
                    else if (sum > target) -- right;
                    else{
                        results.add(Arrays.asList(nums[left],nums[low],nums[high],nums[right]));
                        while (high + 1 < right && nums[high] == nums[high + 1]) ++ high;
                        while (high < right - 1 && nums[right] == nums[right - 1]) -- right;
                        --right; ++high;
                    }

                }

            }

        }
        return results;

    }

    public static void main(String[] args){

        new Solution().fourSum(new int[]{0,0,0,0}, 0);
    }


    /*

            while (mid < high){
                sum = nums[low] + nums[mid] + nums[high];
                if(sum < 0) ++mid;
                else if (sum > 0) --high;
                else {
                    results.add(Arrays.asList(nums[low], nums[mid], nums[high]));
                    // Jump through repeated elements
                    while(mid + 1 < high && nums[mid + 1] == nums[mid]) ++mid;
                    while(mid < high - 1 && nums[high - 1] == nums[high]) --high;
                    ++mid; --high;
                }
            }
     */
}
