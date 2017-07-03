package Counting._No628_MaximumProductOfThreeNumbers;

/**

 Given an integer array, find three numbers whose product is maximum and output the maximum product.

 Example 1:
 Input: [1,2,3]
 Output: 6
 Example 2:
 Input: [1,2,3,4]
 Output: 24

 */
public class Solution {

    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE, min2 = Integer.MIN_VALUE;
        for (int n : nums) {
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }

            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;
            }
        }
        return Math.max(max1*max2*max3, max1*min1*min2);
    }

    public int maximumProduct1(int[] nums) {
        int[] posMax = new int[]{Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE};
        // Use different sign. also, updates the first min value first, the second will be auto-updated
        int[] negMax = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};

        for (int num: nums){
            if (num < negMax[0]) {
                negMax[1] = negMax[0];
                negMax[0] = num;
            }
            else if (num < negMax[1]) negMax[1] = num;

            if (num > posMax[0]) {
                posMax[2] = posMax[1];
                posMax[1] = posMax[0];
                posMax[0] = num;
            }
            else if (num > posMax[1]){
                posMax[2] = posMax[1];
                posMax[1] = num;
            }
            else if (num > posMax[2]) posMax[2] = num;
        }

        return Math.max(negMax[0] * negMax[1] * posMax[0], posMax[0] * posMax[1] * posMax[2]);
    }

}
