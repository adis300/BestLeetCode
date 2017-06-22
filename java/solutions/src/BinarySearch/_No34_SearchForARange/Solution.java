package BinarySearch._No34_SearchForARange;

/**
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4].


 */

// Typical binary search problem
public class Solution {

    public int[] searchRange(int[] nums, int target) {

        int low = 0, high = nums.length, mid = -1;
        if (high > 0) {
            while (low < high){
                if (mid == low + ((high - low)>>1)) break;

                mid = low + ((high - low)>>1);
                if (nums[mid] > target) high = mid;
                else if(nums[mid] < target) low = mid + 1;
                else return extend(nums, mid);
            }
        }

        return new int[]{-1,-1};
    }

    public int[] extend(int[] nums, int mid){
        int left = mid;
        int right = mid;
        while (left >= 0 && nums[left] == nums[mid]) --left;
        while (right <nums.length && nums[right] == nums[mid]) ++right;

        return new int[] {left + 1, right - 1};
    }

    public static void main(String [] args){
        new Solution().searchRange(new int[]{1,2,3}, 3);
    }

}
