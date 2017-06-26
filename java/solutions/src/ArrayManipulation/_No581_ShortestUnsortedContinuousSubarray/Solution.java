package ArrayManipulation._No581_ShortestUnsortedContinuousSubarray;

/**
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

 You need to find the shortest such subarray and output its length.

 Example 1:
 Input: [2, 6, 4, 8, 10, 9, 15]
 Output: 5
 Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 Note:
 Then length of the input array is in range [1, 10,000].
 The input array may contain duplicates, so ascending order here means <=.

 */
public class Solution {

    // One pass solution
    public int findUnsortedSubarray(int[] A) {
        if(A.length < 2) return 0;

        int start = 1, end = 0, max = A[0], min = A[A.length - 1];
        for (int i = 0; i < A.length; i ++){
            max = Math.max(A[i], max);
            min = Math.min(A[A.length - i - 1], min);

            if (A[i] < max) end = i;
            if (A[A.length - i - 1] > min) start = A.length - i - 1;
        }
        // Inclusive
        return end - start + 1;
    }

}
