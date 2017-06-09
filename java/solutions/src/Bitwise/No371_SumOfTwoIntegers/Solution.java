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

        int sum,carry;
        // Find out all 1s and shift left for rounding
        carry = (a&b);

        // sum up.
        sum = a^b;

        return getSum(sum,carry << 1);//
    }

}
