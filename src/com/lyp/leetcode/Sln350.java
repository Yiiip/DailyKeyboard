package com.lyp.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
【两个数组的交集 II】
给定两个数组，编写一个函数来计算它们的交集。

示例 1:

输入: nums1 = [1,2,2,1], nums2 = [2,2]
输出: [2,2]
示例 2:

输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出: [4,9]
说明：

输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
我们可以不考虑输出结果的顺序。
进阶:

如果给定的数组已经排好序呢？你将如何优化你的算法？
如果 nums1 的大小比 nums2 小很多，哪种方法更优？
如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */

public class Sln350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums1.length; i++)
        {
            int ele = nums1[i];
            if (!map1.containsKey(ele))
            {
                map1.put(ele, 1);
            }
            else
            {
                map1.put(ele, map1.get(ele) + 1);
            }
        }

        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < nums2.length; i++)
        {
            if (map1.containsKey(nums2[i]))
            {
                if (map1.get(nums2[i]) > 0)
                {
                    res.add(nums2[i]);
                    map1.put(nums2[i], map1.get(nums2[i]) - 1);
                }
//                else
//                {
//                    map1.remove(nums2[i]);
//                }
            }
        }

        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) { arr[i] = res.get(i); }
        return arr;
    }

    public int[] intersect_2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; )
        {
            if (nums1[i] < nums2[j])
            {
                i++;
            }
            else if (nums1[i] > nums2[j])
            {
                j++;
            }
            else
            {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) { res[i] = list.get(i); }
        return res;
    }
}
