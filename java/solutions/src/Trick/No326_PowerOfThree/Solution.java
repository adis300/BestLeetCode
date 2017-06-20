package Trick.No326_PowerOfThree;

/**
 * Given an integer, write a function to determine if it is a power of three.
 *
 * Follow up:
 * Could you do it without using any loop / recursion?
 *
 */
public class Solution {

    // Best code
    public boolean isPowerOfThree(int n) {
        // 1162261467 is 3^19,  3^20 is bigger than int
        return ( n>0 &&  1162261467%n==0);
    }

    public boolean isPowerOfThree2(int n) {
        if (n <= 0) return false;
        return isPowerOfThreeHelper(n);

    }

    public boolean isPowerOfThreeHelper(int n){
        if (n == 1) return true;

        if(n%3 == 0) return isPowerOfThree(n/3);
        else return false;
    }

}
