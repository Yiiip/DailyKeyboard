package com.lyp.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
【两个数组的交集】
给定两个数组，编写一个函数来计算它们的交集。

示例 1:

输入: nums1 = [1,2,2,1], nums2 = [2,2]
输出: [2]
示例 2:

输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出: [9,4]
说明:

输出结果中的每个元素一定是唯一的。
我们可以不考虑输出结果的顺序。
 */
public class Sln349 {
    public int[] intersection(int[] nums1, int[] nums2) { //18 ms
        ArrayList<Integer> common = new ArrayList<Integer>();
        for (int i = 0; i < nums1.length; i++)
        {
            for (int j = 0; j < nums2.length; j++)
            {
                if (nums1[i] == nums2[j] && !common.contains(nums1[i]))
                {
                    common.add(nums1[i]);
                }
            }
        }
        int[] arr = new int[common.size()];
        for (int i = 0; i < common.size(); i++)
        {
            arr[i] = common.get(i);
        }
        return arr;
    }

    public int[] intersection_2(int[] nums1, int[] nums2) { //3 ms
        int i, j, atMost;
        Set hashset = new HashSet<>();
        if (nums1.length > nums2.length)
            atMost = nums2.length;
        else
            atMost = nums1.length;
        int[] nums3 = new int[atMost];

        for (i = 0; i < nums1.length; i++) {
            hashset.add(nums1[i]);
        }

        for (i = 0, j = 0; i < nums2.length; i++) {
            if (hashset.contains(nums2[i])) {
                nums3[j++] = nums2[i];
                hashset.remove(nums2[i]);
            }
        }
        int[] nums4 = new int[j];
        for (i = 0; i < j; i++) {
            nums4[i] = nums3[i];
        }
        return nums4;
    }

    //只看有无的话适合用Set集合
    public int[] intersection_3(int[] nums1, int[] nums2) { //6 ms
        Set<Integer> record = new HashSet<>();
        for (int i = 0; i < nums1.length; i++)
        {
            record.add(nums1[i]);
        }
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < nums2.length; i++)
        {
            if (record.contains(nums2[i]))
            {
                result.add(nums2[i]);
            }
        }
        int[] ret = new int[result.size()];
        int i = 0;
        for (int e : result)
        {
            ret[i++] = e;
        }
        return ret;
    }
}
