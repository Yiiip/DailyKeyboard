package com.lyp.leetcode;

import java.util.Arrays;

/*
【存在重复元素】
给定一个整数数组，判断是否存在重复元素。

如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。

示例 1:

输入: [1,2,3,1]
输出: true
示例 2:

输入: [1,2,3,4]
输出: false
示例 3:

输入: [1,1,1,3,3,4,3,2,4,2]
输出: true
 */
public class Sln217 {
    public boolean containsDuplicate(int[] nums) {
        // for (int i = 0; i < nums.length; i++)
        // {
        //     for (int j = i + 1; j < nums.length; j++)
        //     {
        //         if (nums[j] == nums[i])
        //         {
        //             return true;
        //         }
        //         else
        //         {
        //             continue;
        //         }
        //     }
        // }
        // return false;


        Arrays.sort(nums);
        for (int i = 1; i <= nums.length - 1; i++)
        {
            if (nums[i] == nums[i - 1])
            {
                return true;
            }
        }
        return false;
    }
}
