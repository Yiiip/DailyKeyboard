package com.lyp.leetcode;

import java.util.Arrays;

/*
【除自身以外数组的乘积】
给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。

示例:

输入: [1,2,3,4]
输出: [24,12,8,6]
说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。

进阶：
你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 */

public class Sln238 {
    public int[] productExceptSelf(int[] nums) { //O(n^2)
         int[] ret = new int[nums.length];

         for (int i = 0; i < nums.length; i++)
         {
             int multiple = 1;
             for (int j = 0; j < nums.length; j++)
             {
                 if (i != j)
                     multiple *= nums[j];
                 if (multiple == 0)
                     break;
             }
             ret[i] = multiple;
         }

         return ret;
     }

    public int[] productExceptSelf_2(int[] nums) { //O(n)
        int l = 1, r = 1;
        int len = nums.length;
        int res[] = new int[len];
        for(int i = 0; i < len; i++)
        {
            res[i] = l;
            l *= nums[i];
        }
        for(int i = len - 1; i >= 0; i--)
        {
            res[i] *= r;
            r *= nums[i];
        }
        return res;
    }

    public static void main(String[] args)
    {
        System.out.println(Arrays.toString(new Sln238().productExceptSelf_2(new int[] { 1, 2, 3, 4 })));
    }
}
