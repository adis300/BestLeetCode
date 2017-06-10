package Bitwise.No371_SumOfTwoIntegers;

/**
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 * Example:
 * Given a = 1 and b = 2, return 3.
 *
 */
public class Solution {

    public int getSum(int a, int b) {
        return a + b;
    }

    public int getSum2(int a, int b) {
        if(b == 0) return a;

        int sum,carry;

        carry = (a&b)<<1; //完成第二步进位并且左移运算

        // sum up.
        sum = a^b; //完成第一步加法的运算

        return getSum(sum,carry);//
    }

    public int getSum3(int a, int b) {
        if(b == 0) return a;

        // Find out all 1s and shift left for rounding
        int carry = (a&b) << 1;

        // sum up the reminder without carry components
        return getSum(a^b, carry);//
    }

    public int getSum4(int a, int b) {
        return b == 0?a: getSum(a^b, (a&b) << 1);
    }

}
