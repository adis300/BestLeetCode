package Bitwise.No342_PowerOfFour;

/**
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 *
 * Example:
 * Given num = 16, return true. Given num = 5, return false.
 *
 * Follow up: Could you solve it without loops/recursion?
 */
public class Solution {

    public boolean isPowerOfFour(int n){
        return n>0 && (n&(n-1)) == 0 && (n&(0b01010101010101010101010101010101)) == n;
    }

    public boolean isPowerOfFour1(int n){
        if(n >0 && (n&(n - 1)) == 0){
            // If is power of two, test for 4th power
            while(n > 0){
                if(n == 1) return true;
                n >>= 2;
            }
        }
        return false;
    }

}
