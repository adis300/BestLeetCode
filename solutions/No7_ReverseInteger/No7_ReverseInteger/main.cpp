//
//  main.cpp
//  No7_ReverseInteger
//
//  Created by Avaya IT Innovation on 7/17/15.
//  Copyright (c) 2015 VoteBin.com. All rights reserved.
//

#include <iostream>
#include <vector>
using namespace std;


class Solution{
public:
    int reverse(int x) {
        long out = 0;
        while(x)
        {
            out *= 10;
            out += x % 10;
            x /= 10;
        }
        return (out < 2147483647 && out > - 2147483647)? int(out) : 0;
    }
};

int main(int argc, const char * argv[]) {
    Solution solution;
    int res = solution.reverse(-2147483412);
    cout << res << endl;
    return 0;
}

// First cumbersome solution tracking digit with a vector

//class Solution{
//public:
//    int reverse(int x) {
//        if(x <10 && x> -10) return x;
//        vector<int> digits = {};
//        long res = 0, pow = 1;
//        int digit = 0;
//        while (x != 0){
//            digit = x % 10;
//            x /= 10;
//            digits.push_back(digit);
//        }
//        for(int i=digits.size() - 1; i>-1; i--){
//            res += digits[i] * pow;
//            pow *= 10;
//        }
//        if(res > 2147483647 || res < - 2147483647) return 0;
//        return int(res);
//    }
//    
//};