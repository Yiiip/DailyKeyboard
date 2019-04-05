package com.lyp.leetcode;

/*
【反转链表 II】
反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
说明:1 ≤ m ≤ n ≤ 链表长度。

示例:
输入: 1->2->3->4->5->NULL, m = 2, n = 4
输出: 1->4->3->2->5->NULL
 */

import com.lyp.leetcode.common.ListNode;

public class Sln92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m >= n)
            return head;

        ListNode pre = null;
        ListNode cur = head;
        ListNode nxt = null;

        ListNode l = null;
        ListNode r = head;
        ListNode tail = head; //记录原链表m处的节点，反转m~n这部分后该节点就成了尾部

        for (int i = 0; i < m - 1; i++) {
            l = cur;
            cur = cur.next;
            tail = tail.next;
        }
        for (int i = 0; i < n; i++) {
            r = r.next;
        }

        int j = 0;
        while (cur != null && j < n - m + 1) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
            j++;
        }
        //将反转的片段拼回去
        if (l != null) l.next = pre;
        else head = pre;
        tail.next = r;

        return head;
    }

    public static void main(String[] args) {
        System.out.println(new Sln92().reverseBetween(
            new ListNode(new int[] { 1, 2, 3, 4, 5 }), 2, 4
        ));

        System.out.println(new Sln92().reverseBetween(
                new ListNode(new int[] { 3, 5 }), 1, 2
        ));

        System.out.println(new Sln92().reverseBetween(
                new ListNode(new int[] { 1, 2, 3 }), 1, 2
        ));
    }
}
