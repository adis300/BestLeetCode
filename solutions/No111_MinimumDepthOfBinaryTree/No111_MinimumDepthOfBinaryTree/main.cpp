//
//  main.cpp
//  No111_MinimumDepthOfBinaryTree
//
//  Created by Disi A on 1/5/16.
//  Copyright (c) 2016 VoteBin.com. All rights reserved.

// Given a binary tree, find its minimum depth.

// The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
//

#include <iostream>

/**
 * Definition for a binary tree node.
 */
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    int minDepth(TreeNode* root) {
        if (root == NULL) return 0;
        if (root -> left != NULL && root -> right != NULL)
            return min(minDepth(root -> left), minDepth(root -> right))+1;
        // if any of left or right is NULL, return the brance depth that has a value
        return max(minDepth(root -> left), minDepth(root-> right))+1;
    }
};

/*
class Solution {
public:
    
    int minDepth(TreeNode* root) {
        if(root == NULL) return 0;
        return traverse(root, 0);
    }
//private:
    int traverse(TreeNode* node, int distance) {
        distance ++;
        if(node -> left == NULL && node -> right == NULL) return distance;
        else if(node -> left == NULL) return traverse(node -> right, distance);
        else if(node -> right == NULL) return traverse(node -> left, distance);
        return min(traverse(node -> left, distance),traverse(node -> right, distance));
    }
};
 */

int main(int argc, const char * argv[]) {
    
    TreeNode node = TreeNode(1);
    
    Solution solution;
    
    std::cout << solution.minDepth(&node);
    return 0;
}
