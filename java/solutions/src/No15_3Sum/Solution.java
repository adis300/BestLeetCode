package No15_3Sum;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 *
 */
public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> results = new LinkedList<>();
        Arrays.sort(nums);
        int mid, low, high, sum;
        for(low = 0; low < nums.length - 2; low ++){

            if (low - 1 >= 0 && nums[low] == nums[low - 1]) continue;

            mid = low + 1; high = nums.length - 1;

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
        }
        return results;

    }

}
