package com.fang.tree.maximumDepthOfBinaryTree104;

import com.fang.tree.TreeNode;

public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftDepth = 0,rightDepth = 0;
        if (root.left != null) {
            leftDepth = maxDepth(root.left);
        }
        if (root.right != null) {
            rightDepth = maxDepth(root.right);
        }
        return Math.max(leftDepth,rightDepth) + 1;
    }
}
