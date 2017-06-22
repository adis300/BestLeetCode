package Strings.No345_ReverseVowelsOfAString;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * Write a function that takes a string as input and reverse only the vowels of a string.

 Example 1:
 Given s = "hello", return "holle".

 Example 2:
 Given s = "leetcode", return "leotcede".

 Note:
 The vowels does not include the letter "y".
 */
public class Solution {

    Set<Character> vowels = new HashSet<>();

    public String reverseVowels(String s) {
        for (char c : "aeiouAEIOU".toCharArray()) vowels.add(c);

        char[] charArray = s.toCharArray();

        int i = 0, j = charArray.length - 1; char swap;

        while (i < j){
            if(!vowels.contains(charArray[i])) ++i;
            else if(!vowels.contains(charArray[j])) --j;
            else {
                swap = charArray[i];
                charArray[i] = charArray[j];
                charArray[j] = swap;
                ++i; -- j;
            }
        }

        return new String(charArray);

    }

    public static void main(String[] args){
        new Solution().reverseVowels("hello");
    }
}
