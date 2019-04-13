package com.lyp.leetcode;

import com.lyp.leetcode.common.TreeNode;

/*
【二叉树的最小深度】
给定一个二叉树，找出其最小深度。
最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
说明: 叶子节点是指没有子节点的节点。

示例:
给定二叉树 [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
返回它的最小深度  2.
 */
public class Sln111 {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;

        if (root.left != null && root.right == null)
            return minDepth(root.left) + 1;
        if (root.left == null && root.right != null)
            return minDepth(root.right) + 1;

        int ld = minDepth(root.left);
        int rd = minDepth(root.right);

        return Math.min(ld, rd) + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Sln111().minDepth(
            TreeNode.arrayToTreeNode(new Integer[] {3, 9, 20, null, null, 15, 7})
        ));

        System.out.println(new Sln111().minDepth(
            TreeNode.arrayToTreeNode(new Integer[] {3, 9})
        ));

        System.out.println(new Sln111().minDepth(
            TreeNode.arrayToTreeNode(new Integer[] {3})
        ));
    }
}