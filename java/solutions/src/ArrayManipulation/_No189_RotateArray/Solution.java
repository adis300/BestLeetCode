package ArrayManipulation._No189_RotateArray;

/**
 * Rotate an array of n elements to the right by k steps.

 For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

 */
public class Solution {

    public void rotate(int[] nums, int k) {
        int steps = k % nums.length;
        if (steps == 0) return;
        // Rotate second half
        reverse(nums, nums.length - steps, nums.length - 1);
        // Rotate first half
        reverse(nums, 0, nums.length - steps - 1);
        // Rotate all
        reverse(nums, 0, nums.length - 1);
    }

    void reverse(int[] nums, int start, int end){
        int temp;
        while (start < end) {
            // swap start and end
            temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    public static void main(String[] args){
        new Solution().rotate(new int[]{1,2,3,4},3 );
    }

}
