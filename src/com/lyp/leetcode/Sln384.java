package com.lyp.leetcode;

import java.util.Arrays;
import java.util.Random;
/*
【打乱数组】
打乱一个没有重复元素的数组。

示例:

// 以数字集合 1, 2 和 3 初始化数组。
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
solution.shuffle();

// 重设数组到它的初始状态[1,2,3]。
solution.reset();

// 随机返回数组[1,2,3]打乱后的结果。
solution.shuffle();
 */

public class Sln384 {

    private int[] source;
    private Random random;

    public Sln384(int[] nums) {
        random = new Random();
        source = Arrays.copyOf(nums, nums.length);
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return source;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] shiffled = Arrays.copyOf(source, source.length);
        for (int i = 0; i < shiffled.length; i++)
        {
            int randomIndex = random.nextInt(source.length - i) + i;
            int tmp = shiffled[i];
            shiffled[i] = shiffled[randomIndex];
            shiffled[randomIndex] = tmp;
        }
        return shiffled;
    }
}
