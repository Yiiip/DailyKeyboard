package com.lyp.leetcode;

/*
【移除链表元素】
删除链表中等于给定值 val 的所有节点。

示例:
输入: 1->2->6->3->4->5->6, val = 6
输出: 1->2->3->4->5
 */

import com.lyp.leetcode.common.ListNode;

public class Sln203 {

    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val)
        {
            //ListNode del = head;
            head = head.next;
            //del = null; //由于是做题，可以忽略掉这种操作
        }

        if (head == null)
            return head;

        ListNode prev = head;
        while (prev.next != null)
        {
            if (prev.next.val == val)
            {
                //ListNode del = prev.next;
                //prev.next = del.next;
                //del.next = null;

                prev.next = prev.next.next;
            }
            else
            {
                prev = prev.next;
            }
        }

        return head;
    }

    //使用虚拟头节点
    public ListNode removeElements_2(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while (prev.next != null)
        {
            if (prev.next.val == val)
                prev.next = prev.next.next;
            else
                prev = prev.next;
        }
        return dummyHead.next;
    }

    public void test1(int nums[], int delVal)
    {
        ListNode head = new ListNode(nums);
        System.out.println(head);
        ListNode answer = removeElements(head, delVal);
        System.out.println(answer);
    }

    public void test2(int nums[], int delVal)
    {
        ListNode head = new ListNode(nums);
        System.out.println(head);
        ListNode answer = removeElements_2(head, delVal);
        System.out.println(answer);
    }

    public static void main(String[] args)
    {
        int nums[] = {6, 1, 2, 6, 3, 4, 5, 6};
        Sln203 sln = new Sln203();
        sln.test1(nums, 6);
        sln.test2(nums, 6);
    }
}
