package com.lyp.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/*
【只出现一次的数字】
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

说明：

你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

示例 1:

输入: [2,2,1]
输出: 1
示例 2:

输入: [4,1,2,1,2]
输出: 4
 */
public class Sln136 {

    public int singleNumber(int[] nums) {
        int find = nums[0];

        if (nums.length == 1) return find;

        Arrays.sort(nums);

        for (int i = 0; i <= nums.length - 1; i += 2)
        {
            if (i == (nums.length - 1) || nums[i] != nums[i + 1])
            {
                find = nums[i];
                break;
            }
        }//1 1 2 2 3

        return find;
    }


    /**
     * 异或：按位相同为0，不同为1. 异或同一个数两次，原数不变。
     *
     * 0^n=n (任何数和0异或保持不变)
     *
     * 另外异或还有一个用途就是交换两个数的值：
     * a=a^b;
     * b=a^b;
     * a=a^b;
     */
    public int singleNumber_2(int[] nums) {
        int single = 0;
        for(int i = 0; i < nums.length; i++){
            single = single ^ nums[i];
        }//4 1 2 1 2
        return single;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] nums = new int[count];
        for (int i = 0; i < count; i++) {
            nums[i] = sc.nextInt();
        }

        int result = new Sln136().singleNumber_2(nums);
        System.out.println("Result: " + result);
    }
}
