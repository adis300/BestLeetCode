package DP._No97_InterleavingString;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

 For example,
 Given:
 s1 = "aabcc",
 s2 = "dbbca",

 When s3 = "aadbbcbcac", return true.
 When s3 = "aadbbbaccc", return false.

 */
public class Solution {

    // DP solution

    // Alternative solution: Merge, pull first character from s3, diverge if same character exists in s1 and s2.

    public boolean isInterleave(String s1, String s2, String s3) {

        if(s3.length()!=s1.length()+s2.length()) return false;

        boolean [][] dp = new boolean [s1.length()+1][s2.length()+1];
        dp[0][0]=true;

        // build the boundary conditions
        for(int i = 1; i<=s1.length() && s1.charAt(i-1)==s3.charAt(i-1); i++) dp[i][0]=true;

        for(int i = 1; i<=s2.length() && s2.charAt(i-1)==s3.charAt(i-1); i++) dp[0][i]=true;

        char c3;
        for(int i = 1; i <= s1.length(); i++){
            for(int j = 1; j <= s2.length(); j++){
                c3 = s3.charAt(i+j-1);
                if(c3 == s1.charAt(i-1) && dp[i-1][j]) dp[i][j] = true;

                if(c3 == s2.charAt(j-1) && dp[i][j-1]) dp[i][j] = true;
            }
        }
        return dp[s1.length()][s2.length()];
    }

    /* Wrong solution
    public boolean isInterleave1(String s1, String s2, String s3) {

        if (s3.length() != s1.length() + s2.length()) return false;

        int [] charMap = new int[256];

        for (char c1: s1.toCharArray())
            ++charMap[c1];
        for (char c2: s2.toCharArray())
            ++charMap[c2];

        for (char c3: s3.toCharArray())
            --charMap[c3];

        for (int count: charMap)
            if (count != 0) return false;

        return true;
    }
    */

}
