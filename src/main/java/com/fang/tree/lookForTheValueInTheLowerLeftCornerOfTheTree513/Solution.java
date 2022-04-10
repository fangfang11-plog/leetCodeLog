package com.fang.tree.lookForTheValueInTheLowerLeftCornerOfTheTree513;

import com.fang.tree.TreeNode;
//public class Solution {
//    public int findBottomLeftValue(TreeNode root) {
//        /**
//         * 这个题一个很简单思路就是用层序遍历,一层一层遍历下去,到
//         * 达最底层时,取队头元素就是题目所求，但是这样因为要进行队
//         * 列创建等操作,也会带来很大开销,于是便有了另外一种想法,
//         * 想要取到最左边,我们一般都会使用先序对左边元素进行遍历,
//         * 在遍历最左元素，我们可利用最大层数与当前层数的比较,如果
//         * 当前层数小于最大层数,这说明已经被遍历过,则不再对该层元素
//         * 进行操作,减小了开销。
//         */
//        /**
//         * 层序遍历法:逐层遍历到最后一层，记录下每一层的队头元素
//         * 当发现是为最后一层直接将记录返回
//         */
//        Queue<TreeNode> treeNodes = new LinkedList<>();
//        if (root != null) treeNodes.add(root);
//        TreeNode result = null;
//        while (!treeNodes.isEmpty()) {
//            int levelSize = treeNodes.size();
//            TreeNode cur = null;
//            boolean flag = false;
//            for (int i = 0; i < levelSize; i++) {
//                cur = treeNodes.poll();
//                if (i == 0) result = cur;
//                if (cur.left != null)  treeNodes.add(cur.left);
//                if (cur.right != null) treeNodes.add(cur.right);
//            }
//        }
//        return result.val;
//    }
//}



public class Solution {
    private int maxValue;
    private int maxDepth;
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return 0;
        return find(root,maxDepth + 1);
    }
    public int find(TreeNode root,int currentDepth) {
        //比较当前层数与最大层数
        if (currentDepth > maxDepth) {
            maxValue = root.val;
            maxDepth = currentDepth;
        }
        if (root.left != null) find(root.left,currentDepth + 1);//回溯过程
        if (root.right != null) find(root.right,currentDepth + 1);
        return maxValue;
    }
}