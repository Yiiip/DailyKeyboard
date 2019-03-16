package com.lyp.leetcode;

/*
【存在重复元素 II】
给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。

示例 1:
输入: nums = [1,2,3,1], k = 3
输出: true

示例 2:
输入: nums = [1,0,1,1], k = 1
输出: true

示例 3:
输入: nums = [1,2,3,1,2,3], k = 2
输出: false
 */

import java.util.HashSet;

public class Sln219 {
    //时间复杂度：O(n)
    //空间复杂度：O(k)
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> record = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (record.contains(nums[i]))
                return true;

            record.add(nums[i]);

            if (record.size() == k + 1)
            {
                record.remove(nums[i - k]); //保持record中最多有k个元素
            }
        }
        return false;
    }
}
