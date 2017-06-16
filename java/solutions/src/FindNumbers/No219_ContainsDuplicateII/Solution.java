package FindNumbers.No219_ContainsDuplicateII;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 */
public class Solution {

    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true; // Add returns true if this element already exists.
        }
        return false;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Set<Integer> nearByItems = new HashSet<Integer>();

        for(int i = 0; i < nums.length; i++){

            if(i > k) nearByItems.remove(nums[i-k-1]);
            if(nearByItems.contains(nums[i])) return true;
            nearByItems.add(nums[i]);

        }

        return false;
    }

    public static void main(String[] args){
        new Solution().containsNearbyDuplicate(new int[]{1,2,1}, 1);
    }
}
