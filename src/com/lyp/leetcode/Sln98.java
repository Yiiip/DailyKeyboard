package com.lyp.leetcode;

/*
【验证二叉搜索树】
给定一个二叉树，判断其是否是一个有效的二叉搜索树。

假设一个二叉搜索树具有如下特征：
节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。

示例 1:
输入:
    2
   / \
  1   3
输出: true

示例 2:
输入:
    5
   / \
  1   4
     / \
    3   6
输出: false
解释: 输入[5,1,4,null,null,3,6]，根节点的值为5，但其右子节点为4。
 */

import com.lyp.leetcode.common.TreeNode;

public class Sln98 {
    Long last = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        if (isValidBST(root.left)) {
            int val = root.val;
            System.out.println(last + " vs " + val);
            if (last < val) {
                System.out.println(last + " -> " + val);
                last = (long) val;
                System.out.println("----");
                return isValidBST(root.right);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Sln98().isValidBST(TreeNode.arrayToTreeNode(
            new Integer[] {1, 1})) + "\n"
        );
        System.out.println(new Sln98().isValidBST(TreeNode.arrayToTreeNode(
            new Integer[] {2, 1, 3})) + "\n"
        );
        System.out.println(new Sln98().isValidBST(TreeNode.arrayToTreeNode(
            new Integer[] {5, 1, 4, null, null, 3, 6})) + "\n"
        );
    }
}
