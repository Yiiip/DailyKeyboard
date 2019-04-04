package com.lyp.leetcode.common;

import com.lyp.leetcode.Sln102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }

    public static TreeNode arrayToTreeNode(Integer[] data) {
        if (data == null || data[0] == null)
            return null;

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(data[0]);
        queue.add(root);

        int index = 1;
        while (!queue.isEmpty()) {
            TreeNode rm = queue.remove();

            if (index == data.length)
                break;

            Integer val = data[index++];
            if (val != null) {
                rm.left = new TreeNode(val);
                queue.add(rm.left);
            }

            if (index == data.length)
                break;

            val = data[index++];
            if (val != null) {
                rm.right = new TreeNode(val);
                queue.add(rm.right);
            }
        }
        return root;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Tree:\n");
        List<List<Integer>> list = this.levelOrder(this);
        for (int i = 0; i < list.size() - 1; i++) {
            str.append("[" + i + "]\t");
            for(Integer num : list.get(i)) {
                str.append(num + " ");
            }
            str.append('\n');
        }
        return str.toString();
    }

    private List<List<Integer>> levelOrder(TreeNode root) {
        List ret = new ArrayList<List<Integer>>();
        this.levelOrder(root, 0, ret);
        return ret;
    }

    private void levelOrder(TreeNode node, int level, List ret) {
        if (level == ret.size())
            ret.add(new ArrayList<Integer>());

        ((ArrayList<Integer>) ret.get(level)).add(node == null ? null : node.val);

        if (node == null)
            return;

        levelOrder(node.left, level + 1, ret);
        levelOrder(node.right, level + 1, ret);
    }

    public static void main(String[] args) {
        Integer[] data = {3, 9, 20, 8, null, 15, 7, null, 6};
        TreeNode root = TreeNode.arrayToTreeNode(data);
        System.out.print(root);
    }
}
