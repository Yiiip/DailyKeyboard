package com.lyp.leetcode;

/*
【反转链表】
反转一个单链表。

示例:
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
进阶: 你可以迭代或递归地反转链表。
 */

import com.lyp.leetcode.common.ListNode;

public class Sln206 {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode pre = null;
        ListNode cur = head;
        ListNode nxt = null;
        while (cur != null) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode data = new ListNode(new int[] {1, 2, 3, 4, 5});
        System.out.println(data);
        ListNode result = new Sln206().reverseList(data);
        System.out.println(result);
    }
}
