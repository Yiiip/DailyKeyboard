package com.lyp.leetcode;

/*
【删除链表的倒数第N个节点】
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：
给定一个链表: 1->2->3->4->5, 和 n = 2.
当删除了倒数第二个节点后，链表变为 1->2->3->5.

更多示例：
1->2, 1 => 1
1->2, 2 => 2
1    ,1 => null

说明：
给定的 n 保证是有效的。

进阶：
你能尝试使用一趟扫描实现吗？
 */

import com.lyp.leetcode.common.ListNode;

public class Sln19 {
    //思路一：先遍历得到链表总长度l，再通过倒数n删除正数l-n+1的节点
    public ListNode removeNthFromEnd_1(ListNode head, int n) {
        int l = 0;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode p = dummy;
        while (p.next != null) {
            l++;
            p = p.next;
        }

        p = dummy;
        for (int i = 0; i < l - n; i++) {
            p = p.next;
        }
        ListNode del = p.next;
        p.next = del.next;
        del.next = null;

        return dummy.next;
    }

    //思路二：一趟扫描，双指针
    public ListNode removeNthFromEnd_2(ListNode head, int n) {
        assert (n > 0);

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode p = dummy;
        ListNode q = dummy;

        for (int i = 0; i < n + 1; i++) {
            assert (q != null);
            q = q.next;
        }

        while (q != null) {
            p = p.next;
            q = q.next;
        }
        ListNode del = p.next;
        p.next = del.next;
        del.next = null;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode data1 = new ListNode(new int[] {1, 2, 3, 4, 5});
        ListNode data2 = new ListNode(new int[] {1, 2});
        ListNode data3 = new ListNode(new int[] {1, 2});
        ListNode data4 = new ListNode(new int[] {1});
        Sln19 sln = new Sln19();
        // System.out.println(sln.removeNthFromEnd_1(data1, 2));
        // System.out.println(sln.removeNthFromEnd_1(data2, 2));
        // System.out.println(sln.removeNthFromEnd_1(data3, 1));
        // System.out.println(sln.removeNthFromEnd_1(data4, 1));
        System.out.println(sln.removeNthFromEnd_2(data1, 2));
        System.out.println(sln.removeNthFromEnd_2(data2, 2));
        System.out.println(sln.removeNthFromEnd_2(data3, 1));
        System.out.println(sln.removeNthFromEnd_2(data4, 1));
    }
}
