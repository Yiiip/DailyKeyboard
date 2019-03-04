package com.lyp.leetcode;

/*
【移动零】
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例:

输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
说明:

必须在原数组上操作，不能拷贝额外的数组。
尽量减少操作次数。
 */

public class Sln283 {

//    错误：[0, 0, 1] -> [0, 1, 0]
//    public void moveZeroes(int[] nums) {
//        for (int i = 0; i < nums.length; i++)
//        {
//            if (nums[i] == 0)
//            {
//                for (int t = i, j = i + 1; j < nums.length; j++, t++)
//                {
//                    int tmp = nums[t];
//                    nums[t] = nums[j];
//                    nums[j] = tmp;
//                }
//            }
//            else
//            {
//                continue;
//            }
//        }
//    }

    //将非0的数往前挪，最后把剩下的数换成0
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int slow = 0;
        for (int fast = 0; fast < len; fast++)
        {
            if (nums[fast] != 0)
            {
                if (fast != slow) nums[slow] = nums[fast];
                slow++;
            }
        }
        for (int i = slow; i < len; i++)
        {
            nums[i] = 0;
        }
    }

    public void moveZeroes_2(int[] nums) {
        int len = nums.length;
        int k = 0;
        for (int i = 0; i < len; i++)
        {
            if (nums[i] != 0)
            {
                if (i != k)
                {
                    swap(nums, k, i);
                }
                k++;
            }
        }
    }

    private void swap(int nums[], int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }

}
