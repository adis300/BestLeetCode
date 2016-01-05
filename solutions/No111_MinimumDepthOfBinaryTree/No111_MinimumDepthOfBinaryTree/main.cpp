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


struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};


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
        int distLeft = traverse(node -> left, distance);
        int distRight = traverse(node -> right, distance);
        return distLeft < distRight? distLeft : distRight;
    }
};

int main(int argc, const char * argv[]) {
    
    TreeNode node = TreeNode(3);
    Solution solution;
    
    std::cout << solution.minDepth(&node);
    return 0;
}
