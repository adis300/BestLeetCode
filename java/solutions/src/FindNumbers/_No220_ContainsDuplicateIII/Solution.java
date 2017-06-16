package FindNumbers._No220_ContainsDuplicateIII;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Given an array of integers, find out whether there are two distinct indices i and j in the array
 * such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference
 * between i and j is at most k.
 */
public class Solution {

    // Making use of AVL tree to floor and ceiling certain numbers.
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        // Preconditioning
        if(t<0 || k <=0 || nums.length < 2) return false;
        TreeSet<Long> set = new TreeSet<>();
        long tl = (long) t;
        Long floor, ceiling; long lower, upper;
        for(int i = 0; i < nums.length; i ++){
            if(i > k) set.remove((long)nums[i- k - 1]);
            if(!set.isEmpty()){
                upper = (long)nums[i] + tl;
                lower = (long)nums[i] - tl;
                floor = set.floor(upper);
                if (floor != null && floor >= lower) return true;
                ceiling = set.ceiling(lower);
                if(ceiling != null && ceiling <= upper) return true;
            }
            set.add((long)nums[i]);
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        Set<Long> set = new HashSet<>();
        for(int i = 0; i < nums.length; i ++){
            if(i > k) set.remove((long)nums[i- k - 1]);
            for(long item : set){
                if(item >= (long)nums[i] - t && item <= (long)nums[i] + t ) return true;
            }
            set.add((long)nums[i]);
        }
        return false;
    }


    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i ++){
            if(i > k) set.remove(nums[i- k - 1]);
            for(int item : set){
                if(item >= nums[i] - t && item <= nums[i] + t ) return true;
            }
            set.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args){
        new Solution().containsNearbyAlmostDuplicate2(new int[]{-1,-1}, 1, 0);
    }

}
