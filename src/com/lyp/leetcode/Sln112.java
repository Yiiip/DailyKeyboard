package com.lyp.leetcode;
/*
【路径总和】
给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。

说明: 叶子节点是指没有子节点的节点。

示例:
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 */

import com.lyp.leetcode.common.TreeNode;

public class Sln112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;

        if (root.left == null && root.right == null)
            return root.val == sum;

        if (hasPathSum(root.left, sum - root.val))
            return true;
        if (hasPathSum(root.right, sum - root.val))
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Sln112().hasPathSum(
            TreeNode.arrayToTreeNode(new Integer[] {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1}),
            22
        ));

        System.out.println(new Sln112().hasPathSum(
            TreeNode.arrayToTreeNode(new Integer[] {5, null, 8, 13, 4}),
            5
        ));
    }
}
