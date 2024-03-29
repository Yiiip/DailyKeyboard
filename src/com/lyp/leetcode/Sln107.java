package com.lyp.leetcode;

/*
【二叉树的层次遍历 II】
给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

返回其自底向上的层次遍历为：
[
  [15,7],
  [9,20],
  [3]
]
 */

import com.lyp.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sln107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List ret = new ArrayList<List<Integer>>();
        func(root, 0, ret);
        Collections.reverse(ret);
        return ret;
    }

    private void func(TreeNode node, int level, List ret) {
        if (node == null)
            return;
        if (level == ret.size())
            ret.add(new ArrayList<Integer>());
        if (node.left != null) func(node.left, level + 1, ret);
        if (node.right != null) func(node.right, level + 1, ret);
        ((ArrayList<Integer>) ret.get(level)).add(node.val);
    }

    public static void main(String[] args) {
        System.out.println(new Sln107().levelOrderBottom(
            TreeNode.arrayToTreeNode(new Integer[] {3, 9, 20, null, null, 15, 7})
        ));
    }
}
