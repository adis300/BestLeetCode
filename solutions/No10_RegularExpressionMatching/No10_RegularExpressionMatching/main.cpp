//
//  main.cpp
//  No10_RegularExpressionMatching
//
//  Created by Disi A on 7/19/15.
//  Copyright (c) 2015 VoteBin.com. All rights reserved.
//

//  '.' Matches any single character.
//  '*' Matches zero or more of the preceding element.
//
//  The matching should cover the entire input string (not partial).
//
//  The function prototype should be:
//  bool isMatch(const char *s, const char *p)
//
//  Some examples:
//  isMatch("aa","a") → false
//  isMatch("aa","aa") → true
//  isMatch("aaa","aa") → false
//  isMatch("aa", "a*") → true
//  isMatch("aa", ".*") → true
//  isMatch("ab", ".*") → true
//  isMatch("aab", "c*a*b") → true

#include <iostream>
#include <vector>
using namespace std;

// ---------------------------------------------------------------------------------------------------
//    8 ms     Not Very comprehensive,
//    leetCode checkes for "   321" and "-   321", but not "  -  321"
// ---------------------------------------------------------------------------------------------------

class Solution {
public:
    bool isMatch(string s, string p) {
        // * is 42 && . is 46
        int len = s.size();
        int lenExp = p.size();
        int i = 0, j = 0, nextCheck = 0, digitCount = 0;
        bool isContinuous = false;
        
        while (i < len - 1 && j < lenExp - 1) {
            if (p[j] == 46) {
                isContinuous = false;
                digitCount = 1;
                nextCheck = p[++j];
                while(nextCheck == 46 || nextCheck == 42){
                    if (nextCheck == 46) digitCount ++;
                    else if(nextCheck == 42) isContinuous = true;
                    nextCheck = p[++j];
                    if (j == lenExp - 1) break;
                }
                if (nextCheck == 42 || nextCheck == 46) { // Next check is reaching end.
                    if (isContinuous) {
                        if (len - i > digitCount) return true;
                        else return false;
                    }else{
                        if (len - i -1 == digitCount) return true;
                        else return false;
                    }
                }
                if (len - 1 -i <= digitCount) {
                    <#statements#>
                }
                while (s[i] != nextCheck) {
                    if (isContinuous) {
                        i ++;
                    }
                }
            }else if(p[j] == 42){
                digitCount = 0;
                if (j ==  lenExp - 1) return true;
                
                while(p[j+1] == 46 || p[j+1] == 42){
                    if (p[j+1] == 46) digitCount ++;
                    j ++;
                }
                
                nextCheck = p[++j];
                while ((nextCheck == 42 || nextCheck == 46) && j < lenExp) {
                    nextCheck
                }
            }
        }
        // Deal with the last bit.
        return true;
    }
    
};



int main(int argc, const char * argv[]) {
    
    string input = "aa";
    string regex = "a*";
    Solution solution;
    bool output = solution.isMatch(input, regex);
    
    cout << "Input is: " << input << endl;
    cout << "Output is: " << output << endl;
    return 0;
}

// ---------------------------------------------------------------------------------------------------
//    16 ms     Very comprehensive,
//    leetCode is stupid.  It checkes for "   321", "-   321", but not "  -  321"
// ---------------------------------------------------------------------------------------------------

//class Solution {
//public:
//    int myAtoi(string str) {
//        if (str.empty()) return 0;
//        int begin = 0;
//        int counter = str.size() - 1;
//
//        bool positive = true;
//        bool alreadySet = false;
//
//        while (str[begin] > 57 || str[begin] < 48){
//
//            cout<<int(str[begin]);
//            if (str[begin] == 45){
//                if (alreadySet) return 0;
//                else{
//                    positive = false;
//                    alreadySet = true;
//                }
//            }else if(str[begin] == 43){
//                if (alreadySet) {
//                    return 0;
//                }
//                else alreadySet = true;
//            }
//            begin ++;
//        }
//        /*
//        if (counter >= begin - 1) {
//            if (str[begin-1] == 45) {
//                positive = false;
//                if (counter >= begin - 2) {
//                    if (str[begin - 2] == 43) return 0;
//                }
//            }else if(str[begin-1] == 43){
//                if (counter >= begin - 2) {
//                    if (str[begin - 2] == 45) return 0;
//                }
//            }
//        }*/
//
//        if (counter < begin ) return 0;
//        if (counter - begin > 10) {
//            return positive? INT32_MAX: INT32_MIN;
//        }
//
//        long output = str[begin] - 48;begin ++;
//
//        while (begin <= counter) {
//            if (str[begin] > 47 && str[begin] < 58) {
//                output *= 10;
//                output += str[begin ++] - 48;
//            }
//            else break;
//        }
//        if (positive) {
//            if (output <= INT32_MAX) return int(output);
//            return INT32_MAX;
//        }
//        output = -output;
//        if (output >= INT32_MIN) return int(output);
//        return INT32_MIN;
//
//
//    }
//
//};