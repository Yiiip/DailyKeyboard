package com.lyp.leetcode;

/*
【两两交换链表中的节点】
给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

示例: 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */

import com.lyp.leetcode.common.ListNode;

public class Sln24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode p = dummy;
        while (p.next != null && p.next.next != null) {
            ListNode nodeA = p.next;
            ListNode nodeB = p.next.next;
            nodeA.next = nodeB.next;
            nodeB.next = nodeA;
            p.next = nodeB;
            p = nodeA;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode data = new ListNode(new int[] {1, 2, 3, 4});
        System.out.println(data);
        ListNode res = new Sln24().swapPairs(data);
        System.out.println(res);
    }
}
