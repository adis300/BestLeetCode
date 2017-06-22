package ArrayManipulation.No80_RemoveDuplicateFromSortedArray;

/**
 * Follow up for "Remove Duplicates":
 What if duplicates are allowed at most twice?

 For example,
 Given sorted array nums = [1,1,1,2,2,3],

 Your function should return length = 5, with the first five elements of nums
 being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
 */
public class Solution {

    public int removeDuplicates(int[] nums) {
        int counter = 0, left = 0;
        int num = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i ++){
            if(nums[i] != num){
                num = nums[i];
                nums[left++] = num;
                counter =1;
            }else{
                counter ++;
                if(counter == 2){
                    nums[left++] = num;
                }
            }

        }
        return left;
    }

}
