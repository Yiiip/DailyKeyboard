package com.lyp.leetcode;

/*
【二叉树的层次遍历】
给定一个二叉树，返回其按层次遍历的节点值。（即逐层地，从左到右访问所有节点）。

例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

返回其层次遍历结果：
[
  [3],
  [9,20],
  [15,7]
]
 */

import com.lyp.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Sln102 {
    //队列法一
    public List<List<Integer>> levelOrder(TreeNode root) {
        List ret = new ArrayList<List<Integer>>();
        if (root == null)
            return ret;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        List<Integer> layer = null;
        while (!queue.isEmpty())
        {
            if (count == 0)
            {
                layer = new ArrayList<>();
                ret.add(layer);
                count = queue.size();
            }

            TreeNode rm = queue.remove();
            layer.add(rm.val);
            count--;

            if (rm.left != null) queue.add(rm.left);
            if (rm.right != null) queue.add(rm.right);
        }
        return ret;
    }

    //队列法二
    public List<List<Integer>> levelOrder_2(TreeNode root) {
        List ret = new ArrayList<List<Integer>>();
        if (root == null)
            return ret;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            int count = queue.size();
            List<Integer> layer = new ArrayList<>();
            for (int i = 0; i < count; i++)
            {
                TreeNode rm = queue.remove();
                layer.add(rm.val);
                if (rm.left != null) queue.add(rm.left);
                if (rm.right != null) queue.add(rm.right);
            }
            ret.add(layer);
        }
        return ret;
    }

    //递归版
    public List<List<Integer>> levelOrder_3(TreeNode root) {
        List ret = new ArrayList<List<Integer>>();
        func(root, 0, ret);
        return ret;
    }

    private void func(TreeNode node, int level, List ret) {
        System.out.println(level);
        if (node == null)
            return;
        if (level == ret.size())
            ret.add(new ArrayList<Integer>());

        ((ArrayList<Integer>) ret.get(level)).add(node.val);
        if (node.left  != null) func(node.left,  level + 1, ret);
        if (node.right != null) func(node.right, level + 1, ret);
    }

    public static void main(String[] args) {
        Integer[] data = {3, 9, 20, null, null, 15, 7};
        TreeNode root = TreeNode.arrayToTreeNode(data);
        System.out.println(new Sln102().levelOrder(root).toString());
        System.out.println(new Sln102().levelOrder_3(root).toString());
    }
}