//
//  main.cpp
//  No108_ConvertSortedArrayToBinarySearchTree
//
//  Created by IT Innovation on 1/7/16.
//  Copyright (c) 2016 VoteBin.com. All rights reserved.
//

// Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

#include <iostream>
#include <vector>
using namespace std;

struct TreeNode{
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

// Very elegant solution
class Solution {
    TreeNode* appendChildren(vector<int>& nums, int low, int high)
    {
        if (low == high) return NULL;
        int mid = low + (high-low)/2;
        TreeNode *head = new TreeNode(nums[mid]);
        head->left = appendChildren(nums, low, mid);
        head->right = appendChildren(nums, mid+1, high);
        return head;
    }
public:
    TreeNode* sortedArrayToBST(vector<int>& nums) {
        if (nums.size() == 0) return NULL;
        return appendChildren(nums, 0, nums.size());
    }
};


int main(int argc, const char * argv[]) {
    Solution solution;
    TreeNode tree(1);
    tree.left = new TreeNode(2);
    //tree.left -> left = new TreeNode(4);
    tree.right = new TreeNode(3);
    vector<int> array ={1,2,3,4,5,6,7,8};
    TreeNode* sorted = solution.sortedArrayToBST(array);
    cout << sorted -> val;
    return 0;
}

// ------------------
// 20ms solution
// ------------------
//class Solution {
//public:
//    // Bounds left inclusive right exclusive
//    void appendChildren(TreeNode *node, vector<int>& nums, int leftBound, int rightBound){
//        
//        if(rightBound - leftBound == 1){
//            node -> val = nums[leftBound];
//            return;
//        }
//        else if(rightBound - leftBound == 2){
//            node -> val = nums[leftBound + 1];
//            node -> left = new TreeNode(nums[leftBound]);
//            return;
//        }
//        
//        int midInd = leftBound + (rightBound-leftBound)/2;
//        node -> val = nums[midInd];
//        // More than 2 nodes remaining
//        
//        node -> left = new TreeNode(0);
//        node -> right = new TreeNode(0);
//        
//        appendChildren(node -> left, nums, leftBound, midInd);
//        appendChildren(node -> right, nums, midInd + 1, rightBound);
//        
//    }
//    
//    TreeNode* sortedArrayToBST(vector<int>& nums) {
//        int len = nums.size();
//        if (len == 0) return NULL;
//        int midInd = len/2;
//        TreeNode* root = new TreeNode(0);
//        
//        appendChildren(root, nums, 0, len);
//        return root;
//    }
//    
//};




//class Solution {
//public:
//    void appendChildren(vector<int>& nums){
//        
//    }
//    TreeNode* sortedArrayToBST(vector<int>& nums) {
//        int len = nums.size();
//        if (len == 0) return NULL;
//        int levelTotal = 1, fullTreeSize = 1;
//        int powBase = 2, lastFullRow;
//        while (fullTreeSize < len) {
//            fullTreeSize += powBase;
//            levelTotal ++;
//            lastFullRow = powBase;
//            powBase *= 2;
//        }
//        
//        
//        
//    }
//    
//};