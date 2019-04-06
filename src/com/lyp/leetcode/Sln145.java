package com.lyp.leetcode;

/*
【二叉树的后序遍历】
给定一个二叉树，返回它的后序遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [3,2,1]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */

import com.lyp.leetcode.common.TreeNode;
import com.lyp.leetcode.common.TreeNodeCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Sln145 { //非递归有点难

    // 迭代写法，利用pre记录上一个访问过的结点，与当前结点比较，如果是当前结点的子节点，
    // 说明其左右结点均已访问，将当前结点出栈，更新pre记录的对象。
    public List<Integer> postorderTraversal_1(TreeNode root)
    {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null)
            return ret;

        TreeNode pre = null;
        stack.push(root);
        while (!stack.isEmpty())
        {
            TreeNode cur = stack.peek();
            //如果当前结点左右子节点为空或上一个访问的结点为当前结点的子节点时，当前结点出栈
            if ((cur.left == null && cur.right == null) ||
                (pre != null && (pre == cur.left || pre == cur.right)))
            {
                ret.add(cur.val);
                pre = cur;
                stack.pop();
            }
            else
            {
                if (cur.right != null) stack.push(cur.right); //先将右结点压栈
                if (cur.left != null) stack.push(cur.left);   //再将左结点入栈
            }
        }
        return ret;
    }

    // 取巧的方法。该写法的访问顺序并不是后序遍历，而是利用先序遍历“根左右”的遍历顺序，
    // 将先序遍历顺序更改为“根右左”，反转结果List，得到结果顺序为“左右根”。
    public List<Integer> postorderTraversal_2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty())
        {
            TreeNode node = stack.pop();
            if(node.left != null) stack.push(node.left);   //和传统先序遍历不一样，先将左结点入栈
            if(node.right != null) stack.push(node.right); //后将右结点入栈
            res.add(0, node.val); //逆序添加结点值
        }
        return res;
    }

    //前中后遍历通用，易
    public List<Integer> postorderTraversal_3(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
        Stack<TreeNodeCommand> stack = new Stack<TreeNodeCommand>();
        stack.push(new TreeNodeCommand("move", root));
        while(!stack.isEmpty())
        {
            TreeNodeCommand nodeCmd = stack.pop();
            if (nodeCmd.cmd.equals("print"))
            {
                res.add(nodeCmd.node.val);
            }
            else if (nodeCmd.cmd.equals("move"))
            {
                //这句话可根据前中后遍历的需要自行调整位置即可
                stack.push(new TreeNodeCommand("print", nodeCmd.node));

                if (nodeCmd.node.right != null)
                    stack.push(new TreeNodeCommand("move", nodeCmd.node.right));
                if (nodeCmd.node.left != null)
                    stack.push(new TreeNodeCommand("move", nodeCmd.node.left));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Sln145().postorderTraversal_3(
                TreeNode.arrayToTreeNode(new Integer[] { 1, null, 2, 3 })
        ));
    }
}
