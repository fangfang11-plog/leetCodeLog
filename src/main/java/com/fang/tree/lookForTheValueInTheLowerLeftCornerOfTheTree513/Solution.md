###### [513. 找树左下角的值](https://leetcode-cn.com/problems/find-bottom-left-tree-value/)

给定一个二叉树的 **根节点** `root`，请找出该二叉树的 **最底层 最左边** 节点的值。

假设二叉树中至少有一个节点。

**示例 1:**

![img](https://assets.leetcode.com/uploads/2020/12/14/tree1.jpg)

```
输入: root = [2,1,3]
输出: 1
```

**示例 2:**

![img](https://assets.leetcode.com/uploads/2020/12/14/tree2.jpg)

```
输入: [1,2,3,4,null,5,6,null,null,7]
输出: 7
```



**提示:**

- 二叉树的节点个数的范围是 `[1,104]`
- `-231 <= Node.val <= 231 - 1`

**思路 **

```java
        /**
         * 这个题一个很简单思路就是用层序遍历,一层一层遍历下去,到
         * 达最底层时,取队头元素就是题目所求，但是这样因为要进行队
         * 列创建等操作,也会带来很大开销,于是便有了另外一种想法,
         * 想要取到最左边,我们一般都会使用先序对左边元素进行遍历,
         * 在遍历最左元素，我们可利用最大层数与当前层数的比较,如果
         * 当前层数小于最大层数,这说明已经被遍历过,则不再对该层元素
         * 进行操作,减小了开销。
         */
        /**
         * 层序遍历法:逐层遍历到最后一层，记录下每一层的队头元素
         * 当发现是为最后一层直接将记录返回
         */
```

**题解 **

```java
/**
 * 层序遍历法:逐层遍历到最后一层，记录下每一层的队头元素
 * 当发现是为最后一层直接将记录返回
 */
```

```java
public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> treeNodes = new LinkedList<>();
        if (root != null) treeNodes.add(root);
        TreeNode result = null;
        while (!treeNodes.isEmpty()) {
            int levelSize = treeNodes.size();
            TreeNode cur = null;
            boolean flag = false;
            for (int i = 0; i < levelSize; i++) {
                cur = treeNodes.poll();
                if (i == 0) result = cur;//取出每一层的最左元素
                if (cur.left != null)  treeNodes.add(cur.left);
                if (cur.right != null) treeNodes.add(cur.right);
            }
        }
        return result.val;
    }
}
```

```java
/**
 * 递归法
 */
```

```java
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
```





