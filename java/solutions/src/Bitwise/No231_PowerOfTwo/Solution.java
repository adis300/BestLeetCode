package Bitwise.No231_PowerOfTwo;

/**
 * Given an integer, write a function to determine if it is a power of two.
 */
public class Solution {

    public boolean isPowerOfTwo(int n) {

        if (n <0) return false;

        int count = 0;
        for(int i = 0; i< 32; i ++){
            if (count > 1) return false;
            if((n & 1) == 1) ++ count;
            n >>= 1;
        }
        return count == 1;

    }

    public boolean isPowerOfTwo1(int n){
        //0b10000000 - 1 = 0b01111111
        return n > 0 && (n & n-1) == 0;
    }

    public boolean isPowerOfTwoCheat(int n){
        return n >0 && 1073741824%n == 0;
    }

    public boolean isPowerOfTwo2(int n){
        return n > 0 && Integer.bitCount(n) == 1;
    }

    public static void main(String[] args){
        new Solution().isPowerOfTwo(-8);
    }
}
