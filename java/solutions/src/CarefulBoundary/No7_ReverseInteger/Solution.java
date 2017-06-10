package CarefulBoundary.No7_ReverseInteger;

/**
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 */
public class Solution {

    public int reverse(int x) {

        long result = 0; int next;
        while (x != 0){
            next = x / 10;
            result *= 10;
            result += (x - next * 10);
            x = next;
        }
        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) return 0; // check for any overflow;

        return (int)result;
    }

    public static void main(String[] args){
        new Solution().reverse(1534236469);
    }

}
