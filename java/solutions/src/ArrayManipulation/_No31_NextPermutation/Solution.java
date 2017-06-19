package ArrayManipulation._No31_NextPermutation;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

 If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

 The replacement must be in-place, do not allocate extra memory.

 Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 1,2,3 → 1,3,2
 3,2,1 → 1,2,3
 1,1,5 → 1,5,1
 */
public class Solution {

    private int[] array;

    void swap(int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    void reverseRemaining(int left){
        int right = array.length - 1;
        while (left < right) swap(left ++, right --);
    }

    public void nextPermutation(int[] nums) {
        array = nums;

        if (nums.length < 2) return;
        int i = nums.length -1, j;

        while ( i > 0){
            // Find the reverse order breaking element [i - 1]
            if (nums[i] > nums[i - 1]) {
                j = i;
                // Find the next possible replacement j - 1 when j is smaller than the pivot
                while (j < nums.length && nums[j] > nums[i - 1]) j ++;

                swap(i - 1, j - 1);
                break;
            }
            i --;
        }

        // Reverse the array after the pivot i-1
        reverseRemaining(i);
    }

    public  static  void main(String[] args){
        new Solution().nextPermutation(new int[] {1,2});
    }

}
