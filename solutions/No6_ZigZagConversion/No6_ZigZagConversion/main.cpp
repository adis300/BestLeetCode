//
//  main.cpp
//  No6_ZigZagConversion
//
//  Created by Disi A on 7/18/15.
//  Copyright (c) 2015 VoteBin.com. All rights reserved.
//

#include <iostream>
using namespace std;

// ---------------------------------------------------------------------------------------------------
//    16 ms           This is the fastest solution but leetCode.com has a little glitch running it
// ---------------------------------------------------------------------------------------------------
// Use the next one for leet code

//class Solution {
//public:
//    string convert(string s, int nRows) {
//        int len = s.size();
//        if(nRows < 2 || len <= nRows) return s;
//        
//        char* res = new char[len]; // Use char to improve performance
//        
//        int sectionCapcity = 2 * nRows- 2;
//        
//        int inc, cur, pre, j = 0;
//        for(int i=0; i<nRows; i++) {
//            
//            //increment = nRow - (i + 1)  current position = i row, and reset previous position
//            inc = 2*(nRows-i-1), cur = i, pre = -1;
//            while(cur < len) {
//                if(cur != pre) res[j++] = s[cur]; // res.push_back(s[cur]) for empty string
//                pre = cur;
//                cur += inc;
//                inc = sectionCapcity - inc; //Take the negative difference to find the next increment value
//            }
//        }
//        return string(res);
//    }
//};

// ---------------------------------------------------------------------------------------------------
//    16 ms           This is the next fastest solution. LeetCode runs it with no problem
// ---------------------------------------------------------------------------------------------------
// Use the next one for leet code

class Solution {
public:
    string convert(string s, int nRows) {
        int len = s.size();
        if(nRows < 2 || len <= nRows) return s;

        string res; // Use char

        int sectionCapcity = 2 * nRows- 2;

        int inc, cur, pre, j = 0;
        for(int i=0; i<nRows; i++) {

            //increment = nRow - (i + 1)  current position = i row, and reset previous position
            inc = 2*(nRows-i-1), cur = i, pre = -1;
            while(cur < len) {
                if(cur != pre) res.push_back(s[cur]);
                pre = cur;
                cur += inc;
                inc = sectionCapcity - inc; //Take the negative difference to find the next increment value
            }
        }
        return res;
    }
};

int main(int argc, const char * argv[]) {
    //string input = "Apalindromeisaword,phrase,number,orothersequenceofunitsthatcanbereadthesamewayineitherdirection,withgeneralallowancesforadjustmentstopunctuationandworddividers.";
    string input = "1234567";
    int row = 4;
    Solution solution;
    string output = solution.convert(input, row);

    cout << "Input is: " << input << endl;
    cout << "Output is: " << output << endl;
    cout << "Input is equal to output: " << (input.length() == output.length()) <<endl;
    return 0;
}



// ---------------------------------------------------------------------
//     20ms  Using a weight factor to replace column and row value
// ---------------------------------------------------------------------

//// Mapping to a custom data structure;
//struct CharMap
//{
//    char a;
//    int weight;
//};
//
//// Create a custom comparator
//int compare(const void* a,const void* b)
//{
//    return ((CharMap *)a)->weight- ((CharMap *)b)->weight;
//}
//
//class Solution {
//public:
//    string convert(string s, int numRows) {
//        int len = s.size();
//        if (len <= numRows || numRows == 1) return s;
//
//        int sectionCap = numRows*2 - 2;
//        int sectionCols = numRows - 1;
//
//        int safeColumnMultiplier = (len/sectionCap + 1)* sectionCols;// This value is floored
//
//        CharMap * charMap = new CharMap[len];
//
//        int fullSectionNum, index, i, col, row;
//
//        for (i = 0; i < len; i ++) { // Starting from 1 to avoid 0 indexing
//            fullSectionNum = (i+1)/sectionCap; // Need to - 1;
//            index = (i+1) % sectionCap; // Need to -1
//            charMap[i].a = s[i];
//            if(index){
//                if (index > numRows) {
//                    col = fullSectionNum * sectionCols + index - numRows;
//                    row  = numRows - (index - numRows); // Starting from row 1 always
//                }else{
//                    col = fullSectionNum * sectionCols;
//                    row = index;
//                }
//            }else{
//                col = fullSectionNum* sectionCols - 1;
//                row = 2;
//            }
//            charMap[i].weight = row * safeColumnMultiplier + col;
//            // Note: columns start from 0, rows start from 1, for convenience;
//        }
//
//        qsort(charMap,len,sizeof(CharMap),compare);
//
//        for (i = 0; i < len; i++)
//            s[i] = charMap[i].a;
//        // Print check;
//        // cout<<charMap[i].a<<"(col: " << charMap[i].col << ", row:" << charMap[i].row << ")" <<endl;
//        delete[] charMap;
//        return s;
//    }
//};

// ---------------------------------------------------------------------
//     28ms  Using a sparse dictionary to track matrices positions
// ---------------------------------------------------------------------
//// Mapping to a custom data structure;
//struct CharMap
//{
//    char a;
//    int col;
//    int row;
//};
//
//// Create a custom comparator
//int compareTest;
//int compare(const void* a,const void* b)
//{
//    compareTest = ((CharMap *)a)->row - ((CharMap *)b)->row;
//    return compareTest? compareTest : ((CharMap *)a)->col- ((CharMap *)b)->col;
//}
//
//class Solution {
//public:
//    string convert(string s, int numRows) {
//        int len = s.size();
//        if (len <= numRows || numRows == 1) return s;
//        
//        int sectionCap = numRows*2 - 2;
//        int sectionCols = numRows - 1;
//        
//        int nGroup = len/sectionCap;// This value is floored
//        
//        CharMap * charMap = new CharMap[len];
//        
//        int fullSectionNum, index, i;
//        char currentChar;
//        
//        for (i = 0; i < len; i ++) { // Starting from 1 to avoid 0 indexing
//            fullSectionNum = (i+1)/sectionCap; // Need to - 1;
//            index = (i+1)%sectionCap; // Need to -1
//            currentChar = s[i];
//            charMap[i].a = s[i];
//            if(index){
//                if (index > numRows) {
//                    charMap[i].col = fullSectionNum * sectionCols + index - numRows;
//                    charMap[i].row  = numRows - (index - numRows); // Starting from row 1 always
//                }else{
//                    charMap[i].col = fullSectionNum * sectionCols;
//                    charMap[i].row = index;
//                }
//            }else{
//                charMap[i].col = fullSectionNum* sectionCols - 1;
//                charMap[i].row = 2;
//            }
//            // Note: columns start from 0, rows start from 1, for convenience;
//            
//        }
//        
//        qsort(charMap,len,sizeof(CharMap),compare);
//        
//        for (i = 0; i < len; i++)
//            s[i] = charMap[i].a;
//        // Print check;
//        // cout<<charMap[i].a<<"(col: " << charMap[i].col << ", row:" << charMap[i].row << ")" <<endl;
//        
//        return s;
//    }
//};
