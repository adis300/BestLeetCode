//
//  main.cpp
//  No107_BinaryTreeLevelOrderTraversal2
//
//  Created by Disi A on 1/6/16.
//  Copyright (c) 2016 VoteBin.com. All rights reserved.
//

// Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
//
// For example:
// Given binary tree {3,9,20,#,#,15,7},

// Given binary tree {3,9,20,#,#,15,7},
//      3
//     / \
//    9  20
//      /  \
//     15   7
// return its bottom-up level order traversal as:
//   [
//     [15,7],
//     [9,20],
//     [3]
//   ]


#include <iostream>
#include <vector>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

// Breadth first search

class Solution{
public:
    vector<vector<int>> levelOrderBottom(TreeNode* root) {
        vector<vector<int>> list(0);
        if (root == NULL) return list;
        traverse(list, root, 1);
        reverse(list.begin(),list.end());
        return list;
    }
    
    void traverse(vector<vector<int>> &list, TreeNode* node, int depth) {
        if (node == NULL) return;
        if (list.size() == depth-1) list.push_back({node -> val});
        else if (list.size() >= depth) list[depth-1].push_back(node -> val);
        
        traverse(list, node -> left, depth + 1 );
        traverse(list, node -> right, depth + 1 );
    }
    
};

/* depth first search
class Solution{
public:
    vector<vector<int>> levelOrderBottom(TreeNode* root) {
        vector<vector<int>> allValues(0) ;
        
        if(root == NULL) return allValues;
        
        vector<vector<TreeNode*>> allNodes(0);
        allNodes.push_back({root});
        allValues.push_back({root -> val});
        
        bool levelHasNext = true;
        int level = 0;
        
        while (levelHasNext) {
            vector<TreeNode*> thisLevel = allNodes[level];
            level ++;

            vector<TreeNode*> nextLevel(0);
            vector<int> nextLevelVal(0);
            
            for (int i = 0; i < thisLevel.size(); i ++) {
                TreeNode* n = thisLevel[i];
                if (n -> left) {
                    nextLevel.push_back(n -> left);
                    nextLevelVal.push_back(n -> left -> val);
                }
                if (n -> right){
                    nextLevel.push_back(n -> right);
                    nextLevelVal.push_back(n -> right -> val);
                }
            }
            if (nextLevel.size() > 0){
                levelHasNext = true;
                allValues.push_back(nextLevelVal);
                allNodes.push_back(nextLevel);
            }else levelHasNext = false;

        }
        reverse(allValues.begin(), allValues.end());
        
        return allValues;
    }
};*/

int main(int argc, const char * argv[]) {
    Solution solution;
    TreeNode* tree = new TreeNode(1);
    tree -> left = new TreeNode(2);
    //tree.left -> left = new TreeNode(4);
    tree->right = new TreeNode(3);
    vector<vector<int>> treeArray = solution.levelOrderBottom(tree);
    cout << treeArray.size();
    return 0;
}

// Misread problem thought each node should be grouped
//class Solution{
//public:
//    vector<vector<int>> levelOrderBottom(TreeNode* root) {
//        vector<vector<int>> treeVec(0) ;
//        
//        if(root == NULL) return treeVec;
//        vector<vector<TreeNode*>> parents(0);
//        parents.push_back({root});
//        bool levelHasNext = true;
//        int level = 0;
//        
//        while (levelHasNext) {
//            vector<TreeNode*> thisLevel = parents[level];
//            level ++;
//            
//            vector<TreeNode*> nextLevel(0);
//            
//            for (int i = 0; i < thisLevel.size(); i ++) {
//                TreeNode* n = thisLevel[i];
//                if (n -> left) nextLevel.push_back(n -> left);
//                if (n -> right) nextLevel.push_back(n -> right);
//            }
//            if (nextLevel.size() > 0){
//                levelHasNext = true;
//                parents.push_back(nextLevel);
//            }else levelHasNext = false;
//            
//        }
//        // Reverse the levels by doing a inverse loop
//        for (int j = parents.size() - 2; j > -1; j--) {
//            vector<TreeNode*> thisLevel = parents[j];
//            // Loop each level left to right
//            for (int k = 0; k < thisLevel.size(); k++){
//                TreeNode* thisNode = thisLevel[k];
//                vector<int> nodeArray(0);
//                if (thisNode -> left) nodeArray.push_back(thisNode -> left -> val);
//                if (thisNode -> right) nodeArray.push_back(thisNode -> right -> val);
//                if (nodeArray.size()) treeVec.push_back(nodeArray);
//            }
//        }
//        treeVec.push_back(vector<int>{root-> val});
//        return treeVec;
//    }
//};
