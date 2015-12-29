//
//  main.cpp
//  No5_LongestPalindromicSubstring
//
//  Created by Disi A on 7/16/15.
//  Copyright (c) 2015 VoteBin.com. All rights reserved.
//
//  Please see refer to the nice articles from LeetCode.com
//  http://articles.leetcode.com/2011/11/longest-palindromic-substring-part-ii.html
//
//  And Johan's blog
//  http://johanjeuring.blogspot.com/2007/08/finding-palindromes.html
//


//  Problem:
//  Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.


#include <iostream>
using namespace std;

class Solution {
public:

    string longestPalindrome(string s) {
        // Assuming LeetCode doen't test with null string;
        int len = s.size();
        if (len < 2) return s; // if (s.isEmpty() ||len < 2) return s;
        
        int fullLength = len * 2 + 3; // fullLength is the length of the string with splitters and boundaries
        // Add boundaries;
        int* str = new int[fullLength](); // Using an integer array instead of string changes the performance 12ms -> 4ms
        str[0] = -1; // Set left boundary, use negative numbers or zero as boundary values
        str[fullLength - 1] = -2;
        int j = 2;
        for (int i = 0; i < len + 1; i++){
            str[j++] = s[i];
            j++;
        }
        
        // Upto this point, the string is formatted,  abc becomes   (-1), (0) , a, (0), b, (0), c, (0), (-2)

        int* pLength = new int[fullLength]();
        int center = 0, radius = 0, maxLen = 0, centerIndex = 0;
        //int left, right;
        for (int i = 0; i < fullLength; i++) {
            int ii = 2*center-i;   // ii: the mirror of i from center equals to ii = C - (i - C)
            if (radius > i)
                pLength[i] = min(radius-i, pLength[ii]);
            else radius = 0;
            
            // Attempt to expand palindrome centered at i
            while (str[i + 1 + pLength[i]] == str[i - 1 - pLength[i]])
                pLength[i]++;
            
            // If palindrome centered at i expand past radius,
            // adjust center based on expanded palindrome.
            if (i + pLength[i] > radius) {
                center = i;
                radius = i + pLength[i];
            }
            
            if (maxLen < pLength[i]) {
                maxLen = pLength[i];
                centerIndex = i;
            }
        }
        //delete[] P;
        
        return s.substr((centerIndex - 1 - maxLen)/2, maxLen);
    }
};


int main() {
    Solution solution;
    string str = "aaabaa";
    
    string palindromic = solution.longestPalindrome(str);
    
    cout << "The median of two sorted arrays are: " << palindromic <<endl;
    return 0;
}

// 52 ms Naive expand around center.
//class Solution {
//public:
//    string longestPalindrome(string s) {
//        int len = s.size();
//        if (len < 2) return s;
//
//        // Add boundaries;
//        string str = char(0) + s + char(1);
//
//        int allPos = len * 2;  // - 1 (0 and len * 2 + 1 are boundary chars, 1, len *2 -1 are boundary splitters)
//        bool isChar = true;
//        int pLength = 0;
//
//        int pLoc = 0; //Used for storing the result start and result end
//
//        int center, left, right, maxLength = 1; // Max length starts from 1 because we get boundaries.
//        int i;
//
//        for (i = 2; i < allPos + 1; i++) {
//
//            center = i/2;
//
//            left = isChar? center - 1 : center;
//            right = center + 1;
//
//            while (str[left] == str[right]) {
//                left --;
//                right ++;
//            }
//
//            pLength = right - left;
//            isChar = !isChar;
//
//            if (maxLength < pLength) {
//                maxLength = pLength;
//                pLoc = left;
//            }
//        }
//
//
//        return s.substr(pLoc, maxLength - 1);
//    }
//
//};


// 128 mm  dynamic programing solution
//class Solution {
//public:
//    string longestPalindrome(string s) {
//        
//        int N = s.length();
//        bool dp[N][N];
//        int maxlength = 1,start = 0;
//        string out;
//        memset(dp,false,sizeof(dp));
//        for(int i=N-1;i>=0;i--)
//        {
//            for(int j=i;j<N;j++)
//            {
//                
//                if((j-i <= 2 || dp[i+1][j-1]) && s[i] == s[j])
//                {
//                    dp[i][j] = true;
//                    if(maxlength < j-i+1)
//                    {
//                        start = i;
//                        maxlength = j-i+1;
//                    }
//                }
//            }
//        }
//
//        out = s.substr(start,maxlength);
//        return out;
//    }
//    
//};