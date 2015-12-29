//
//  main.cpp
//  No9_PalindromeNumber
//
//  Created by Disi A Innovation on 7/21/15.
//  Copyright (c) 2015 VoteBin.com. All rights reserved.
//

//  Problem:
//
//  Determine whether an integer is a palindrome. Do this without extra space.
//
//  click to show spoilers.
//
//  Some hints:
//  Could negative integers be palindromes? (ie, -1)
//
//  If you are thinking of converting the integer to string, note the restriction of using extra space.
//
//  You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?
//
//  There is a more generic way of solving this problem.


#include <iostream>
#include <vector>

using namespace std;

// ---------------------------------------------------------------------------------------------------
//    72 ms     solution
// ---------------------------------------------------------------------------------------------------


class Solution {
public:
    bool isPalindrome(int x) {
        
        if(x<0) return false;
        
        int temp = x, a=0;
        
        while(temp)
        {
            a=a*10 + temp%10;
            temp /= 10;
        }
        
        return a == x;
        
    }
};

//class Solution {
//public:
//    bool isPalindrome(int x) {
//        
//        if (x<10) return x<0? false: true;
//        
//        int temp = x/10, a=x - temp* 10;
//        
//        while(temp)
//        {
//            a=a*10 + temp%10;
//            temp /= 10;
//        }
//        
//        return a == x;
//        
//    }
//};



int main(int argc, const char * argv[]) {
    
    int input = 1310;
    Solution solution;
    bool output = solution.isPalindrome(input);
    
    cout << "Input is Palindrome: " << output << endl;
    return 0;
}

// ---------------------------------------------------------------------------------------------------
//    72 ms     solution,
//  Saved half iteration but added an extra assignment and two checks.
// ---------------------------------------------------------------------------------------------------


//class Solution {
//public:
//    bool isPalindrome(int x) {
//        if (x<10) return x<0? false: true;
//        
//        int temp = x/10, a=x%10;
//        if (a) {
//            while(a< temp)
//            {
//                x = temp;
//                temp /= 10;
//                a=a*10 + x%10;
//
//            }
//            return a==temp || a==x;
//            
//        }
//        return false;
//    }
//};

// Rewriting the mod operator
//class Solution {
//public:
//    bool isPalindrome(int x) {
//        if (x<10) return x<0? false: true;
//        
//        int temp = x/10, a=a=x-temp*10;
//        if (a) {
//            while(a< temp)
//            {
//                x = temp;
//                temp /= 10;
//                //a=a*10 + (x-temp* 10); Rewriting the mod operator
//                a = 10*(a-temp) + x;
//            }
//            return a==temp || a==x;
//            
//        }
//        return false;
//    }
//};

// ---------------------------------------------------------------------------------------------------
//    104 ms     Using a vector to track all digits
// ---------------------------------------------------------------------------------------------------


//class Solution {
//public:
//    bool isPalindrome(int x) {
//        if (x < 0) return false;
//        vector<int> digits;
//        while (x > 0) {
//            digits.push_back(x%10);
//            x/=10;
//        }
//        int len = digits.size();
//        for (int i = 0; i < len /2; i ++) {
//            if(digits[i] != digits[len - i - 1]) return false;
//        }
//        return true;
//    }
//};

