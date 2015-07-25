//
//  main.cpp
//  No3_LongestSubstring
//
//  Created by Disi A on 7/16/15.
//  Copyright (c) 2015 VoteBin.com. All rights reserved.
//
/*
 Problem:
 There are two sorted arrays nums1 and nums2 of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 */

// -------------------------------------------------------------------------
//                  40 ms solution by assembling a sorted vector
// -------------------------------------------------------------------------


#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    double findMedian(vector<int>& nums){
        if (nums.size()% 2 == 0)
            return 0.5 * (nums[nums.size()/2 - 1] + nums[nums.size()/2]);
        
        return nums[nums.size()/2];
        
    }
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        if (nums1.empty())
            return findMedian(nums2);// num2 might also be empty, but we can ignore that.
        if(nums2.empty()) return findMedian(nums1);
        
        int num1Size = nums1.size(), num2Size = nums2.size();
        
        int size = num1Size + num2Size, i = 0, n1 = 0, n2 = 0;
        
        // Initialize a vector that has the size of both arrays
        vector<int> merged(size);
        
        // Fill up the new array by merging the two sorted list
        while (i < size) {
            if (n1 == num1Size) {
                merged[i] = nums2[n2];
                n2 ++;
            }else if (n2 == num2Size) {
                merged[i] = nums1[n1];
                n1 ++;
            }else{
                if(nums1[n1] < nums2[n2]){
                    merged[i] = nums1[n1];
                    n1 ++;
                }else{
                    merged[i] = nums2[n2];
                    n2 ++;
                }
            }
            i ++;
            
        }
        // Return the median of sorted vector.
        return findMedian(merged);
    }
};



int main() {
    Solution solution;
    string str = "hahah stupid";
    vector<int> num1 = {1,2,3};
    vector<int> num2 = {4,5,6,7};
    
    double median = solution.findMedianSortedArrays(num1, num2);
    
    cout << "The median of two sorted arrays are: " << median <<endl;
    return 0;
}