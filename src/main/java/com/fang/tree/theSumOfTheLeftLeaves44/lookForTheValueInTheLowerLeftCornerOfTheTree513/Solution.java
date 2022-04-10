package com.fang.tree.theSumOfTheLeftLeaves44.lookForTheValueInTheLowerLeftCornerOfTheTree513;

import com.fang.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        /**
         * 层序遍历法:逐层遍历到最后一层，记录下每一层的队头元素
         * 当发现是为最后一层直接将记录返回
         */
        Queue<TreeNode> treeNodes = new LinkedList<>();
        if (root != null) treeNodes.add(root);
        TreeNode result = null;
        while (!treeNodes.isEmpty()) {
            int levelSize = treeNodes.size();
            TreeNode cur = null;
            boolean flag = false;
            for (int i = 0; i < levelSize; i++) {
                cur = treeNodes.poll();
                if (i == 0) result = cur;
                if (cur.left != null)  treeNodes.add(cur.left);
                if (cur.right != null) treeNodes.add(cur.right);
            }
        }
        return result.val;
    }
}
