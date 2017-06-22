package Strings.No28_ImplementStrStr;

/**
 * Implement strStr().

 Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 */
public class Solution {

    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        char[] hay = haystack.toCharArray();
        char[] sample = needle.toCharArray();
        for (int i = 0; i <= hay.length - sample.length; i ++){
            for (int j = 0; j < sample.length; j ++){
                if (sample[j] != hay[i + j]) break;
                if (j == sample.length - 1) return i;
            }
        }
        return -1;
    }

}
