package FindNumbers._No41_FirstMissingPositive;

/**
 * Given an unsorted integer array, find the first missing positive integer.

 For example,
 Given [1,2,0] return 3,
 and [3,4,-1,1] return 2.

 Your algorithm should run in O(n) time and uses constant space.
 */
public class Solution {

    // Put the value to n'th position and find the fist mismatch.

    public int firstMissingPositive(int[] A) {
        int i = 0;
        while(i < A.length){
            if(A[i] == i+1 || A[i] <= 0 || A[i] > A.length) i++;
            else if(A[A[i]-1] != A[i]) swap(A, i, A[i]-1);
            else i++;
        }
        i = 0;
        while(i < A.length && A[i] == i+1) i++;
        return i+1;
    }

    private void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args){
        new Solution().firstMissingPositive(new int[]{3,1,2});

    }

    /* Unable to resolve duplicate keys
    public int codeWithSpirit(int[] nums){

        int counter = 0, sum = 0;
        for (int num: nums){
            if(num > 0) {
                ++ counter;
                sum += num;
            }
        }

        sum = (1 + counter) * counter/2 - sum;
        return (counter + 1) + sum;

    }

    public int firstMissingPositive(int[] nums) {

        int counter = 0;
        for (int i = 0; i < nums.length; i ++){
            if(nums[i] > 0) ++ counter;
            else nums[i] = 0;
        }

        int sum = (1 + counter) * counter/2;
        for (int num: nums  ){
            sum -= num;
        }
        // if (sum < 0) return (counter + 1) + sum;
        // else return counter + 1;
        return (counter + 1) + sum;
    }
    */
}
