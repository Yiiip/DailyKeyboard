package com.lyp.leetcode;

/*
【二叉树的中序遍历】
给定一个二叉树，返回它的中序遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */

import com.lyp.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Sln94 {
    //递归
    public List<Integer> inorderTraversal_1(TreeNode root)
    {
        List<Integer> ret = new ArrayList<>();
        func(root, ret);
        return ret;
    }
    private void func(TreeNode node, List<Integer> list)
    {
        if (node == null)
            return;
        func(node.left, list);
        list.add(node.val);
        func(node.right, list);
    }

    //非递归，用栈模拟
    //有点难
    public List<Integer> inorderTraversal_2(TreeNode root)
    {
        List<Integer> results = new ArrayList<>();
        if (root == null) return results;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || stack.size() != 0)
        {
            if (node != null)
            {
                stack.push(node);
                node = node.left;
            }
            else
            {
                node = stack.pop();
                results.add(node.val);
                node = node.right;
            }
        }

        return results;
    }
}
