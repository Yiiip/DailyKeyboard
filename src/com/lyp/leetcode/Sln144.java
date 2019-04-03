package com.lyp.leetcode;

import com.lyp.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
【二叉树的前序遍历】
给定一个二叉树，返回它的前序遍历。

示例:
输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,2,3]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class Sln144 {
    //递归
    public List<Integer> preorderTraversal_1(TreeNode root)
    {
        List<Integer> ret = new ArrayList<>();
        func(root, ret);
        return ret;
    }
    private void func(TreeNode node, List<Integer> list)
    {
        if (node == null)
            return;
        list.add(node.val);
        func(node.left, list);
        func(node.right, list);
    }

    //非递归，用栈模拟
    public List<Integer> preorderTraversal_2(TreeNode root)
    {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty())
        {
            TreeNode top = stack.pop();
            if (top != null)
            {
                ret.add(top.val);
                if (top.right != null)
                {
                    stack.push(top.right);
                }
                if (top.left != null)
                {
                    stack.push(top.left);
                }
            }
        }
        return ret;
    }

}
