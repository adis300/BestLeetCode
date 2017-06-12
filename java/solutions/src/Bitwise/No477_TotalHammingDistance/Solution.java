package Bitwise.No477_TotalHammingDistance;

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Now your job is to find the total Hamming distance between all pairs of the given numbers.

 Example:
 Input: 4, 14, 2

 Output: 6

 Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
 showing the four bits relevant in this case). So the answer will be:
 HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.

 Note:
 Elements of the given array are in the range of 0 to 10^9
 Length of the array will not exceed 10^4.
 */
public class Solution {

    // Bit by bit construction
    public int totalHammingDistance(int[] nums) {
        int dist = 0;
        int oneCount, zeroCount, trueZeroCount;
        do{
            oneCount = 0; zeroCount = 0; trueZeroCount = 0;
            for (int i = 0;i< nums.length; i ++){
                if (nums[i] == 0) {
                    ++ trueZeroCount;
                    // if(trueZeroCount == nums.length) return dist;
                }
                if((nums[i] & 1) == 1) ++ oneCount;
                else ++ zeroCount;
                nums[i] >>= 1;

            }
            dist += oneCount * zeroCount;
        }while (trueZeroCount != nums.length);

        return dist;
    }


    public int hammingDistance(int x, int y){
        x ^= y;
        int count = 0;
        for(int i = 0; i < 32; i ++) count += (x>>i & 1);
        return count;
    }

    // Trivial approach
    public int totalHammingDistance2(int[] nums) {
        int dist = 0;
        for (int i = 0;i< nums.length; i ++){
            for (int j = i+1; j < nums.length; j ++){
                dist += hammingDistance(nums[i], nums[j]);
            }
        }
        return dist;
    }

}
