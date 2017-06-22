package Palindrome.No129_ValidPalindrome;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 For example,
 "A man, a plan, a canal: Panama" is a palindrome.
 "race a car" is not a palindrome.

 */
public class Solution {

    public boolean isPalindrome(String s) {
        char [] charArray = s.toCharArray();
        int i = 0, j = charArray.length - 1;

        while (i < j){
            if (charArray[i] >= 'a' && charArray[i] <= 'z') charArray[i] -=32;
            if (charArray[j] >= 'a' && charArray[j] <= 'z') charArray[j] -=32;
            if (charArray[i] > 'Z' || (charArray[i] < 'A' && charArray[i] > '9') || charArray[i] < '0') ++i;
            else if (charArray[j] > 'Z' || (charArray[j] < 'A' && charArray[j] > '9') || charArray[j] < '0') --j;
            else if (charArray[i++] != charArray[j--]) return false;
        }

        return true;
    }

    public static void main(String[] args){
        new Solution().isPalindrome("0P");
    }

    // For strings with only characters
    public boolean isPalindrome1(String s) {
        char [] charArray = s.toCharArray();

        for (int i = 0; i < charArray.length/2; i ++){
            if (charArray[i] != charArray[charArray.length - i - 1]) return false;
        }
        return true;
    }
}
