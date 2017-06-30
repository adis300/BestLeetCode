package SlidingWindow._No539_PermutationInString;

/**
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.

 Example 1:
 Input:s1 = "ab" s2 = "eidbaooo"
 Output:True
 Explanation: s2 contains one permutation of s1 ("ba").
 Example 2:
 Input:s1= "ab" s2 = "eidboaoo"
 Output: False

 */
public class Solution {

    /**
     * Make use of a rolling counter
     */
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;

        int[] count = new int[26];
        for (int i = 0; i < len1; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        if (allZero(count)) return true;

        for (int i = len1; i < len2; i++) {
            count[s2.charAt(i) - 'a']--;
            //Disi's impl
            if(++count[s2.charAt(i - len1) - 'a'] == 0){
                if (allZero(count)) return true;
            }
            /** Original impl
            count[s2.charAt(i - len1) - 'a']++;
            if (allZero(count)) return true;
             */
        }

        return false;
    }

    private boolean allZero(int[] count) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }

    char[] s2Array;
    String s1;
    public boolean checkInclusion1(String s1, String s2) {
        s2Array = s2.toCharArray();
        this.s1 = s1;

        int[] counter = new int[26];

        for (char c: s1.toCharArray()) ++ counter[c-'a'];

        int i = 0;
        while (i<= s2Array.length - s1.length()){
            if (counter[s2Array[i] - 'a'] > 0){
                if(checkPermutation(i, counter.clone())) return true;
            }
            ++i;
        }

        return false;
    }

    public boolean checkPermutation(int startIndex, int[] charMap){
        for (int i = startIndex; i < startIndex + s1.length(); i ++){
            if (--charMap[s2Array[i] - 'a'] < 0) return false;
        }
        for (int charCount: charMap) if (charCount != 0) return false;
        return true;
    }

    public static void main(String[] args){
        System.out.println(new Solution().checkInclusion("eidbaooo", "ab"));
    }

}
