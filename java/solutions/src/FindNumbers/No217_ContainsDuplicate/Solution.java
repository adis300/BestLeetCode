package FindNumbers.No217_ContainsDuplicate;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct.
 *
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for(int num : nums){
            if(seen.contains(num)) return true;
            seen.add(num);
        }
        return false;
    }
}
