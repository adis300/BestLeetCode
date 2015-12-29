//
//  main.cpp
//  No287_Find the duplicate number
//
//  Created by Disi A Innovation on 7/21/15.
//  Copyright (c) 2015 VoteBin.com. All rights reserved.
//

//  Problem:
//
//  Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
//  prove that at least one duplicate number must exist. Assume that there is only one duplicate number,
//  find the duplicate one.
//
// Note:
// 1. You must not modify the array (assume the array is read only).
// 2. You must use only constant, O(1) extra space.
// 3. Your runtime complexity should be less than O(n2).
// 4. There is only one duplicate number in the array, but it could be repeated more than once.


#include <iostream>
#include <vector>

using namespace std;



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
class Solution {
public:
    int findDuplicate(vector<int>& nums){
        int len = nums.size();
        int head = len;
        int slow = nums[len - 1];
        int fast = nums[slow - 1];
        
        while (slow != fast){
            slow = nums[slow-1];
            fast = nums[nums[fast-1]-1];
            cout << "Slow is: " << slow << endl;
            cout << "Fast is: " << fast << endl;
        }
        
        while (head != slow){
            head = nums[head-1];
            slow = nums[slow-1];
            cout << "Head is: " << head << endl;
            cout << "Slow is: " << slow << endl;
        }
        return head;
    }
};


int main(int argc, const char * argv[]) {
    
    vector<int> nums = {1,5,5,4,3,2,6};
    Solution solution;
    int repeatedNum = solution.findDuplicate(nums);
    
    cout << "The repeated num is: " << repeatedNum << endl;
    return 0;
}

// ---------------------------------------------------------------------------------------------------
//    72 ms     Brutal force solution
// ---------------------------------------------------------------------------------------------------


//class Solution {
//public:
//    int findDuplicate(vector<int>& nums) {
//        int len = nums.size();
//        int i, j;
//        for (i = 0; i < len; i ++ ) {
//            for (j = i + 1; j < len; j ++){
//                if(nums[i] == nums[j]) return nums[i];
//            }
//        }
//        return 0;
//    }
//};


