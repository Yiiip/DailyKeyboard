package com.lyp.leetcode.common;

/**
 * Definition for singly-linked list.
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }
    public ListNode(int[] arr)
    {
        if (arr == null || arr.length == 0)
            throw new IllegalArgumentException("arr can not be empty");

        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        ListNode cur = this;
        while (cur != null)
        {
            str.append(cur.val + " -> ");
            cur = cur.next;
        }
        str.append("NULL");
        return str.toString();
    }
}