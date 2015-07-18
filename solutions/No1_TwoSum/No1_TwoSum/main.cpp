//
//  main.cpp
//  No1_TwoSum
//
//  Created by Disi A on 7/15/15.
//  Copyright (c) 2015 VoteBin.com. All rights reserved.
//

#include <iostream>
//#include<map>
#include <vector>
using namespace std;

// ---------------------------------------------------------------------
//    8ms           This is the fastest solution
// ---------------------------------------------------------------------

typedef pair<int, int> Pair;

int compare(const void* a,const void* b)
{
    return ((Pair *)a) -> first - ((Pair *)b) -> first;
}

class Solution
{
public:
    vector<int> twoSum(vector<int>& nums, int target)
    {
        // Initialize variables
        int len = nums.size(), sum = 0;
        Pair* temp = new Pair[len];
        
        // Creating a pair array and use the second element to track indices.
        for(int i = 0; i < len; i++){
            temp[i].first = nums[i];
            temp[i].second = i;
        }
        
        // Sorting the array
        qsort(temp,len,sizeof(Pair),compare);
        
        // Find matching sum and return the real indices.
        int left = 0;
        int right = len - 1;
        while(left < right)
        {
            sum = temp[left].first + temp[right].first;
            if(sum > target)
                right--;
            else if(sum < target)
                left++;
            else{
                left = temp[left].second;
                right = temp[right].second;
                if (left < right) return {left + 1, right + 1};
                else return {right + 1,left + 1};
            }
            
        }
        
        // If result is not reasonable return a {0, 0} vector
        return {0, 0};
    }
};


int main(int argc, const char * argv[]) {
    vector<int> input = {3,2,4};
    Solution solution;
    vector<int> res = solution.twoSum(input, 6);
    cout << "The length of this vector is: " << res.size() << endl;
    cout << "The first element is: " << res[0] << endl;
    cout << "The second element is: " << res[1] << endl;
    return 0;
}

// ---------------------------------------------------------------------
//     24ms  This is an elegant solution with hash map/dictionary
// ---------------------------------------------------------------------

//class Solution {
//public:
//    vector<int> twoSum(vector<int>& nums, int target) {
//
//        // Initialize a map tracker
//        map<int, int> tracker;
//
//        for(int i = 0; i < nums.size(); i ++ ){
//            if (tracker.count(nums[i])) {
//                // If tracker has the record return the recorded index and current index
//                return {tracker[nums[i]] + 1,i + 1};
//            }else{
//                // Ir tracker does not have the key, record the target value as the key and current index as value
//                tracker[target-nums[i]] = i;
//            }
//        }
//        return {0,0};
//    }
//};
