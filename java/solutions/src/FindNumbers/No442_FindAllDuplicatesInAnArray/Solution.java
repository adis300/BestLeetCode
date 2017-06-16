package FindNumbers.No442_FindAllDuplicatesInAnArray;

import java.util.LinkedList;
import java.util.List;

/**
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * Find all the elements that appear twice in this array.
 * Could you do it without extra space and in O(n) runtime?

 Example:
 Input:
 [4,3,2,7,8,2,3,1]

 Output:
 [2,3]

 */
public class Solution {

    // Use negative marker to mark position, This doesn't take care of numbers that duplicates multiple times
    // when find a number i, flip the number at position i-1 to negative.
    // if the number at position i-1 is already negative, i is the number that occurs twice.

    public List<Integer> findDuplicates1(int[] nums) {
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i])-1;
            if (nums[index] < 0)
                res.add(Math.abs(index+1));
            nums[index] = -nums[index];
        }
        return res;
    }

    public List<Integer> findDuplicates(int[] nums) {
        LinkedList<Integer> res = new LinkedList<>();
        int temp;
        for (int i = 0; i < nums.length; i ++){
            while (nums[i] != i + 1){
                temp = nums[i];
                if (nums[temp -1] == temp) break;

                // Otherwise swap the two elements
                nums[i] = nums[temp - 1];
                nums[temp -1] = temp;
            }
        }

        for(int i = 0;i < nums.length; i ++){
            if (nums[i] > 0 && nums[i] != i + 1){
                if(nums[nums[i]-1] > 0){
                    res.add(nums[i]);
                    nums[nums[i]-1] = 0;
                }
            }
        }
        return res;
    }

}
