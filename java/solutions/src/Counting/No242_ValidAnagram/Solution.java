package Counting.No242_ValidAnagram;

import java.util.Arrays;

/**

 Given two strings s and t, write a function to determine if t is an anagram of s.

 For example,
 s = "anagram", t = "nagaram", return true.
 s = "rat", t = "car", return false.

 Note:
 You may assume the string contains only lowercase alphabets.

 */
public class Solution {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] counter = new int[128];
        for (int i = 0;i < s.length(); i ++) {
            ++counter[s.charAt(i)];
            --counter[t.charAt(i)];
        }
        for (int charCount : counter) if(charCount != 0) return false;
        return true;
    }

    // Naive sort algorithm
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        for (int i = 0; i < sArray.length; i++)
            if (sArray[i] != tArray[i]) return false;

        return true;
    }
}
