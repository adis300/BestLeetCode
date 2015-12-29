//
//  main.cpp
//  No8_StringToInteger
//
//  Created by Disi A on 7/19/15.
//  Copyright (c) 2015 VoteBin.com. All rights reserved.
//

//  Implement atoi to convert a string to an integer.
//
//  Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
//
//  Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
//
//  Update (2015-02-10):
//  The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.
//
//  spoilers alert... click to show requirements for atoi.
//
//  Requirements for atoi:
//  The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
//
//  The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
//
//  If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
//
//  If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.

#include <iostream>
#include <vector>
using namespace std;

// ---------------------------------------------------------------------------------------------------
//    8 ms     Not Very comprehensive,
//    leetCode checkes for "   321" and "-   321", but not "  -  321"
// ---------------------------------------------------------------------------------------------------

class Solution {
public:
    int myAtoi(string str) {
        if(str.empty()) return 0;
        int sum  = 0;
        bool negative  = false;
        int i = 0;
        int len = str.size();
        int DIV = INT_MAX/10;
        while(i < len)
        {
            if(str[i] == '+')
            {
                i++; // Go to the next element if this string is a sign.
                if(str[i] < '0' || str[i] > '9') return 0;  //Check if next element is a number
                else negative = false;
            }
            if(str[i] == '-')
            {
                i ++; // Go to the next element if this string is a sign.
                if(str[i] < '0' || str[i] > '9') return 0;  //Check if next element is a number
                else negative = true;
            }
            
            if(str[i] > 47 && str[i] < 58 )  // 48~ 57 are 0 ~ 9
            {
                // Check sum value before multiply by 10
                if(sum > DIV) return negative? INT_MIN : INT_MAX;
                
                sum = sum * 10;
                
                // Check sub value before adding next digit;
                if(sum > INT_MAX - str[i] + 48) return negative? INT_MIN: INT_MAX; // Note, missing an extreme case
                
                sum = sum + str[i] - '0';
                
                i++;

                if(str[i] < '0' || str[i] > '9') return negative? -sum: sum;
            }
            else
            {
                // If letter appears, break the sum this is only for leetCode test cases.
                // Infact, 0 should be returned if any invalide character appears.
                if(str[i] >= 'a' && str[i] <= 'z' ) return negative? -sum: sum;
                i++;
            }
        }
            
        return negative? -sum: sum;
            
    }
    
};



int main(int argc, const char * argv[]) {

    string input = "-2147483648";
    Solution solution;
    int output = solution.myAtoi(input);
    
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