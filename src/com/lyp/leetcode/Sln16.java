package com.lyp.leetcode;

/*
【最接近的三数之和】
给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。
返回这三个数的和。假定每组输入只存在唯一答案。

例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.

与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */

import java.util.Arrays;

public class Sln16 {
    public int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int nearestSum = target;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++)
        {
            int cur = nums[i];
            int targetTwoSum = target - cur;
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r)
            {
                int twoSum = nums[l] + nums[r];
                if (twoSum == targetTwoSum)
                {
                    return target;
                }

                int distance = Math.abs(twoSum - targetTwoSum);
                if (distance < min)
                {
                    min = distance;
                    nearestSum = cur + twoSum;
                }
                if (twoSum < targetTwoSum)
                {
                    l++;
                }
                else if (twoSum > targetTwoSum)
                {
                    r--;
                }
            }
        }
        return nearestSum;
    }

    public static void main(String[] args) {
        System.out.println(new Sln16().threeSumClosest(new int[] {-1, 2, 1, -4}, 1));
    }
}
