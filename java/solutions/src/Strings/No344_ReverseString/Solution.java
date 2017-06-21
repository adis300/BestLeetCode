package Strings.No344_ReverseString;

/**
 * Write a function that takes a string as input and returns the string reversed.

 Example:
 Given s = "hello", return "olleh".

 */
public class Solution {

    // One lines solution
    public String reverseString(String s) {
        return  (new StringBuilder()).append(s).reverse().toString();
    }

    public String reverseString1(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = s.length()-1; i >= 0; i--)
            builder.append(s.charAt(i));
        return  builder.toString();
    }
}
