package BinaryTree._No257_BinaryTreePaths;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.

 For example, given the following binary tree:

     1
   /  \
 2     3
  \
   5
 All root-to-leaf paths are:

 ["1->2->5", "1->3"]
 */
public class Solution {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private List<String> results = new LinkedList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root != null) searchBT(root, "");
        return results;
    }
    private void searchBT(TreeNode root, String path) {
        if (root.left == null && root.right == null) results.add(path + root.val);
        if (root.left != null) searchBT(root.left, path + root.val + "->");
        if (root.right != null) searchBT(root.right, path + root.val + "->");
    }

}
