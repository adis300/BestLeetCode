package SlidingWindow._No209_MinimumSizeSubarraySum;

/**

 Given an array of n positive integers and a positive integer s,
 find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

 For example, given the array [2,3,1,2,4,3] and s = 7,
 the subarray [4,3] has the minimal length under the problem constraint.

 click to show more practice.

 More practice:
 If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).

 */
public class Solution {

    public int minSubArrayLen(int s, int[] a) {
        if (a.length == 0) return 0;

        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;

        while (j < a.length) {
            sum += a[j++];

            while (sum >= s) {
                min = Math.min(min, j - i);
                sum -= a[i++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public int minSubArrayLen1(int s, int[] nums) {
        if (nums.length == 0) return 0;
        if (nums[0] == s) return 1;
        if (nums.length < 2) return 0;


        int minLength = Integer.MAX_VALUE;
        int start = 0, end = 1;
        int sum = nums[start] + nums[end];

        while (end < nums.length){
            if (sum < s) {
                if(end < nums.length - 1)sum += nums[++end];
                else break;
            }
            else if (sum > s) {
                if (start < end)
                    sum -= nums[start++];
                else{
                    if(end < nums.length - 1)sum += nums[++end];
                    else break;
                }
            }
            else {
                minLength = Math.min(minLength, end - start + 1);
                sum -= nums[start++];
            }
        }
        return minLength == Integer.MAX_VALUE? 0: minLength;
    }

    public static void main(String[] args){
        new Solution().minSubArrayLen(7, new int[]{2,3,1,2,4,3});
    }

}
