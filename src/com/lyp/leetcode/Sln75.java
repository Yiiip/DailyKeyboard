package com.lyp.leetcode;

/*
【颜色分类】
给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

注意:
不能使用代码库中的排序函数来解决这道题。

示例:
输入: [2,0,2,1,1,0]
输出: [0,0,1,1,2,2]

进阶：
一个直观的解决方案是使用计数排序的两趟扫描算法。
首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
你能想出一个仅使用常数空间的一趟扫描算法吗？
 */

public class Sln75 {

    public void sortColors_1(int[] nums) { //计数排序
        int[] count = new int[3];
        for (int i = 0; i < nums.length; i++) {
            assert (nums[i] == 0 || nums[i] == 1 || nums[i] == 2);
            count[nums[i]]++;
        }
        int index = 0;
        for (int i = 0; i < count[0]; i++)
            nums[index++] = 0;
        for (int i = 0; i < count[1]; i++)
            nums[index++] = 1;
        for (int i = 0; i < count[2]; i++)
            nums[index++] = 2;
    }

    public void sortColors_2(int[] nums) { //三路快排思路
        int zero = -1; // [0 ... zero] == 0
        int i = 0; // [zero+1 ... i-1] == 1
        int two = nums.length; // [two ... len-1] == 2
        while (i < two)
        {
            if (nums[i] == 1)
            {
                i++;
            }
            else if (nums[i] == 2)
            {
                two--;
                swap(nums, i, two);
            }
            else
            {
                assert(nums[i] == 0);
                zero++;
                swap(nums, zero, i);
                i++;
            }
        }
    }

    private void swap(int nums[], int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }
}
