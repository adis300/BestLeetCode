package Counting._No335_IncreasingTripletSubsequence;

/**
 *
 Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

 Formally the function should:
 Return true if there exists i, j, k
 such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 Your algorithm should run in O(n) time complexity and O(1) space complexity.

 Examples:
 Given [1, 2, 3, 4, 5],
 return true.

 Given [5, 4, 3, 2, 1],
 return false.

 */
public class Solution {

    // Smart algorithm, using a small and a large value
    public boolean increasingTriplet(int[] nums) {
        // start with two largest values, as soon as we find a number bigger than both, while both have been updated, return true.
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n < small) { small = n; } // update small if n is smaller than both
            else if (n < big) { big = n; } // update big only if greater than small but smaller than big
            else return true; // return if you find a number bigger than both
        }
        return false;
    }

    // Naive brute force solution
    public boolean increasingTriplet1(int[] nums) {

        int [] store = new int[2];

        for (int i = 0; i < nums.length - 2; i ++){
            store[0] = nums[i];
            for (int j = i + 1; j < nums.length - 1; j ++){
                if(nums[j] <= store[0]) continue;
                store[1] = nums[j];
                for (int k = j+ 1; k < nums.length; k ++){
                    if(nums[k] <= store[1]) continue;
                    return true;
                }
            }
        }
        return false;
    }

}
