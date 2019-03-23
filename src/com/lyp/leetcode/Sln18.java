package com.lyp.leetcode;

/*
【四数之和】
给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。

注意：答案中不可以包含重复的四元组。

示例：给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
满足要求的四元组集合为：
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sln18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i <= len - 4; i++)
        {
            if (i > 0) //等价于 if (i > 0 && nums[i] == nums[i - 1]) continue;
            {
                i = moveForward(nums, i - 1, len - 1);
            }
            for (int j = i + 1; j <= len - 3; j++)
            {
                if (j > i + 1) //等价于 if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                {
                    j = moveForward(nums, j - 1, len - 1);
                }
                int l = j + 1;
                int r = len - 1;
                int targetTwoSum = target - nums[i] - nums[j];
                while (l < r)
                {
                    int twoSum = nums[l] + nums[r];
                    if (twoSum < targetTwoSum)
                    {
                        l = moveForward(nums, l, r);
                    }
                    else if (twoSum > targetTwoSum)
                    {
                        r = moveBackward(nums, l, r);
                    }
                    else if (twoSum == targetTwoSum)
                    {
                        ret.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l = moveForward(nums, l, r);
                        r = moveBackward(nums, l, r);
                    }
                }
            }
        }
        return ret;
    }

    private int moveForward(int[] nums, int l, int r) {
        int num = nums[l];
        while (l < r) {
            l++;
            if (nums[l] != num)
                break;
        }
        return l;
    }

    private int moveBackward(int[] nums, int l, int r) {
        int num = nums[r];
        while (l < r) {
            r--;
            if (nums[r] != num)
                break;
        }
        return r;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new Sln18().fourSum(new int[] {1, 0, -1, 0, -2, 2}, 0);
        System.out.println(result.toString());

        List<List<Integer>> result2 = new Sln18().fourSum(new int[] {-3, -2, -1, 0, 0, 1, 2, 3}, 0);
        System.out.println(result2.toString());

        List<List<Integer>> result3 = new Sln18().fourSum(new int[] {-2, 0, 0, 3, 3, -1}, 5);
        System.out.println(result3.toString());
    }
}
