package com.lyp.leetcode;

/*
【翻转二叉树】
翻转一棵二叉树。

输入：
     4
   /   \
  2     7
 / \   / \
1   3 6   9

输出：
     4
   /   \
  7     2
 / \   / \
9   6 3   1

备注：这个问题是受到 Max Howell 的 原问题 启发的 ：
谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
 */

import com.lyp.leetcode.common.TreeNode;

public class Sln226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        invertTree(root.left);
        invertTree(root.right);
        swapChildren(root);

        return root;
    }

    private void swapChildren(TreeNode node) {
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.arrayToTreeNode(new Integer[] {4, 2, 7, 1, 3, 6, 9});
        System.out.println(root);
        System.out.println(new Sln226().invertTree(root));
    }

}
