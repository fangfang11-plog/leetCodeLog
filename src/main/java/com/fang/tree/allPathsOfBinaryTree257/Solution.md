###### [257. 二叉树的所有路径](https://leetcode-cn.com/problems/binary-tree-paths/)

给你一个二叉树的根节点 `root` ，按 **任意顺序** ，返回所有从根节点到叶子节点的路径。

**叶子节点** 是指没有子节点的节点。

**示例 1：**

![img](https://assets.leetcode.com/uploads/2021/03/12/paths-tree.jpg)

```
输入：root = [1,2,3,null,5]
输出：["1->2->5","1->3"]
```

**示例 2：**

```
输入：root = [1]
输出：["1"]
```



**提示：**

- 树中节点的数目在范围 `[1, 100]` 内
- `-100 <= Node.val <= 100`

**思路 **

```java
/**
 * 思路:模拟回溯过程
 * 重点:在每个递归过程生成一个字符串，从第一个递归开始生成到该结点的字符路径,
 * 在传入下一个迭代过程时,只传入上一个递归过程中的结点路径作为参考,下一个递归
 * 过程根据当前结点情况加入当前结点到字符串中,而不改变上一个递归过程中路径字符
 * 串值，实现一个过程的解耦。
 */
```

**题解 **

```java
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
```





