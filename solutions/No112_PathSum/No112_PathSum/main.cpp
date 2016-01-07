//
//  main.cpp
//  No112_PathSum
//
//  Created by Disi A on 1/5/16.
//  Copyright (c) 2016 VoteBin.com. All rights reserved.
//

//Given a binary tree and a sum, determine if the tree has a root-to-leaf path
// such that adding up all the values along the path equals the given sum.

// For example:
// Given the below binary tree and sum = 22,
//        5
//       / \
//      4   8
//     / \
//    11  13  4
//   /  \      \
//  7    2      1
// return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

#include <iostream>


/**
 * Definition for a binary tree node.
 */


struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

// Subtract sum to zero while traversing
class Solution {
public:
    bool traverse(TreeNode * node, int sum){
        sum -= node -> val;
        if(node -> left == NULL && node -> right == NULL) return sum == 0;
        else if(node -> left == NULL) return traverse(node -> right, sum);
        else if(node -> right == NULL) return traverse(node -> left, sum);
        return traverse(node -> left, sum) || traverse(node -> right, sum);
    }
    
    bool hasPathSum(TreeNode* root, int sum) {
        if(root == NULL) return false;
        return traverse(root, sum);
    }
};

/* Add to sum up
class Solution {
public:
    bool traverse(TreeNode * node, int sum, int record){
        record += node -> val;
        if(node -> left == NULL && node -> right == NULL) return record == sum;
        else if(node -> left == NULL) return traverse(node -> right, sum, record);
        else if(node -> right == NULL) return traverse(node -> left, sum, record);
        return traverse(node -> left, sum, record) || traverse(node -> right, sum, record);
    }
    
    bool hasPathSum(TreeNode* root, int sum) {
        if(root == NULL) return false;
        return traverse(root, sum, 0);
    }
};
 */

int main(int argc, const char * argv[]) {
    TreeNode node = TreeNode(3);
    Solution solution;
    
    std::cout << solution.hasPathSum(&node, 3);
    return 0;
}
