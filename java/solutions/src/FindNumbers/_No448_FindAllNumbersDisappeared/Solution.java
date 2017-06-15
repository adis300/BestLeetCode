package FindNumbers._No448_FindAllNumbersDisappeared;

import java.util.LinkedList;
import java.util.List;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

 Example:

 Input:
 [4,3,2,7,8,2,3,1]

 Output:
 [5,6]

 */
public class Solution {

    //Mark seen elements as negative
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> ret = new LinkedList<>();

        for(int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                ret.add(i+1);
            }
        }
        return ret;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new LinkedList<>();
        int temp, j;
        for (int i = 0; i< nums.length; i ++){
            j = i;
            while (nums[j] != j + 1){
                temp = nums[j];
                if (nums[temp - 1] == temp) break;
                nums[j] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }
        for (int i = 0; i< nums.length; i ++){
            if(nums[i] != i + 1) res.add(i + 1);
        }
        return res;
    }

    public static void main(String[] args){
        new Solution().findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
    }

}
