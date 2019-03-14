package com.lyp.leetcode;

/*
【两数之和 II：输入有序数组】
给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。

说明:
返回的下标值（index1 和 index2）不是从零开始的。
你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。

示例:
输入: numbers = [2, 7, 11, 15], target = 9
输出: [1,2]
解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 */

public class Sln167 {
    public int[] twoSum(int[] numbers, int target) { //双指针(1 ms)
        int l = 0;
        int r = numbers.length - 1;
        while (l < r)
        {
            if (numbers[l] + numbers[r] > target)
            {
                r--;
            }
            else if (numbers[l] + numbers[r] < target)
            {
                l++;
            }
            else
            {
                return new int[] {l + 1, r + 1}; //返回到下标值不是从零开始的
            }
        }
        return null;
    }

    public int[] twoSum_2(int[] numbers, int target) { //二分查找(5 ms)
        for (int i = 0; i <= numbers.length - 2; i++)
        {
            int cur = numbers[i];
            int find = target - cur;
            int findIndex = binarySearch(numbers, i + 1, numbers.length - 1, find);
            if (findIndex != -1)
            {
                return new int[] {i + 1, findIndex + 1};
            }
        }
        return null;
    }

    private int binarySearch(int[] arr, int l, int r, int target)
    {
        while (l <= r)
        {
            int mid = l + (r - l) / 2;
            if (arr[mid] > target)
            {
                r = mid - 1;
            }
            else if (arr[mid] < target)
            {
                l = mid + 1;
            }
            else
            {
                return mid;
            }
        }
        return -1;
    }
}
