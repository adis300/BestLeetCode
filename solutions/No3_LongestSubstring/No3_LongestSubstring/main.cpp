//
//  main.cpp
//  No3_LongestSubstring
//
//  Created by Disi A on 7/16/15.
//  Copyright (c) 2015 VoteBin.com. All rights reserved.
//
/*
 Problem:
 Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */


// -------------------------------------------------------------------------
//                  16 ms final solution using ascii boolean record
// -------------------------------------------------------------------------

#include <iostream>
using namespace std;


class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int n = s.size();
        int start = 0, i = 0;
        int maxLen = 0;
        // Using a boolean array of 256 to track the existance of all ASCII values.
        // Toggle the same value when it reappear;
        bool exist[256] = { false };
        while (i < n) {
            if (exist[s[i]]) {
                maxLen = maxLen > i-start? maxLen: i-start; // can use the max function;
                while (s[start] != s[i]) { //Also remove previously accured ascii values
                    exist[s[start]] = false;
                    start++;
                }
                start++;
                
            } else exist[s[i]] = true;
            i++;
        }
        return maxLen > n-start? maxLen: n-start;
    }
};



int main(int argc, const char * argv[]) {
    Solution solution;
    string str = "aa";
    int i = solution.lengthOfLongestSubstring(str);
    std::cout << "Longest substring length is: " << i <<endl;
    return 0;
}

// ---------------------------------------------------------------------
//                  100 ms solution
// ---------------------------------------------------------------------
//class Solution {
//public:
//    int lengthOfLongestSubstring(string s) {
//        
//        set<int> tracker;
//        unsigned long trackerMaxSizeRecord = 0;
//        int size = int(s.size());
//        
//        if(size < 2) {
//            return size;
//        }
//        int start;
//        
//        for (int i = 0; i < size; i++) {
//            
//            if(tracker.count(s[i])){
//                trackerMaxSizeRecord = trackerMaxSizeRecord > tracker.size()? trackerMaxSizeRecord: tracker.size();
//                while (start <= i && s[start] != s[i] ) {
//                    tracker.erase(s[start]);
//                    start ++;
//                }
//                start ++;
//            }else{
//                tracker.insert(s[i]);
//            }
//        }
//        
//        return int(trackerMaxSizeRecord > tracker.size()? trackerMaxSizeRecord: tracker.size());
//    }
//};

// // 108 ms
//class Solution {
//public:
//    int lengthOfLongestSubstring(string s) {
//        map<char, int> tracker;
//        unsigned long trackerMaxSizeRecord = 0;
//        
//        for (int i = 0; i < s.size(); i++) {
//            
//            if(tracker.count(s[i])){
//                
//                if (tracker[s[i]] == i - tracker.size()) {
//                    
//                    tracker[s[i]] = i;
//                    
//                }else{
//                    i = tracker[s[i]]; //Automatically add one by the for loop
//                    if(tracker.size() > trackerMaxSizeRecord){
//                        trackerMaxSizeRecord = tracker.size();
//                    }
//                    tracker.clear();
//                }
//            }else{
//                tracker[s[i]] = i;
//                if(tracker.size() > trackerMaxSizeRecord){
//                    trackerMaxSizeRecord = tracker.size();
//                }
//            }
//        }
//        return int(trackerMaxSizeRecord);
//    }
//};

//class Solution {
//public:
//    int lengthOfLongestSubstring(string s) {
//        map<char, int> tracker;
//        unsigned long trackerMaxSizeRecord = 0;
//        int i = 0;
//        unsigned long size = s.size();
//        while (i < size) {
//            if(tracker.count(s[i])){
//                
//                int index = tracker[s[i]];
//                
//                if (index == i - tracker.size()) {
//                    
//                    tracker[s[i]] = i;
//                    
//                }else{
//                    i = tracker[s[i]]; //Automatically add one by the for loop
//                    if(tracker.size() > trackerMaxSizeRecord){
//                        trackerMaxSizeRecord = tracker.size();
//                    }
//                    tracker.clear();
//                }
//            }else{
//                tracker[s[i]] = i;
//                if(tracker.size() > trackerMaxSizeRecord){
//                    trackerMaxSizeRecord = tracker.size();
//                }
//            }
//            i ++;
//        }
//        
//        return int(trackerMaxSizeRecord);
//    }
//};

// // 124 ms
//class Solution {
//public:
//    int lengthOfLongestSubstring(string s) {
//        map<char, int> tracker;
//        unsigned long trackerMaxSizeRecord = 0;
//        int size = int(s.size());
//        if(size <= 1) {
//            return size;
//        }
//        
//        for (int i = 0; i < size; i++) {
//            
//            if(tracker.count(s[i])){
//                
//                if (tracker[s[i]] == i - tracker.size()) {
//                    
//                    tracker[s[i]] = i;
//                    if(tracker.size() > trackerMaxSizeRecord){
//                        trackerMaxSizeRecord = tracker.size();
//                    }
//                    
//                }else{
//                    i = tracker[s[i]]; //Automatically add one by the for loop
//                    if(tracker.size() > trackerMaxSizeRecord){
//                        trackerMaxSizeRecord = tracker.size();
//                    }
//                    tracker.clear();
//                }
//            }else{
//                tracker[s[i]] = i;
//            }
//        }
//        if(tracker.size() > trackerMaxSizeRecord){
//            trackerMaxSizeRecord = tracker.size();
//        }
//        return int(trackerMaxSizeRecord);
//    }
//};
