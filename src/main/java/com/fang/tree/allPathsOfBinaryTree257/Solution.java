package com.fang.tree.allPathsOfBinaryTree257;

import com.fang.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {

        List<String> result = new LinkedList<>();
        String catString = new String();
        travel(result,catString,root);
        return result;
    }

    public void travel (List<String> result, String catString,TreeNode root) {
        //利用stringBuilder的可拼接，以传入的路径字符串为参考点,加入当前结点
        StringBuilder stringBuilder = new StringBuilder(catString);
        stringBuilder.append(root.val);
        stringBuilder.append("->");
        //为叶子结点时,将路径存入结果中
        if (root.left == null && root.right == null) {
            stringBuilder.delete(stringBuilder.length() - 2,stringBuilder.length());
            result.add(stringBuilder.toString());
            return;
        }
        if (root.left != null) travel(result,stringBuilder.toString(),root.left);
        if (root.right != null) travel(result,stringBuilder.toString(),root.right);
    }

}
