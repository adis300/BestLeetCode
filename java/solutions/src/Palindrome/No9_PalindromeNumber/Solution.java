package Palindrome.No9_PalindromeNumber;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class Solution {

    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int reversed = 0, original = x;
        while (x != 0){
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        return reversed == original;
    }

    public static void main(String[] args){
        new Solution().isPalindrome(-2147447412);
    }

}
