package com.lyp.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
【求众数】
给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于n/2的元素。

你可以假设数组是非空的，并且给定的数组总是存在众数。

示例 1:

输入: [3,2,3]
输出: 3
示例 2:

输入: [2,2,1,1,1,2,2]
输出: 2
 */
public class Sln169 {

    //偷鸡
    public int majorityElement_1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    public int majorityElement_2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i <= nums.length - 1; i++)
        {
            int num = nums[i];
            if (map.containsKey(num))
            {
                int v = map.get(num);
                map.put(num, v+1);
            }
            else
            {
                map.put(num, 1);
            }
        }
        for (int num : map.keySet())
        {
            if (map.get(num) > nums.length / 2)
            {
                return num;
            }
        }
        return -1;
    }

    /* 摩尔投票算法
    假设有这样一个场景：票选村长，每人可投一票，我们将候选村长从1开始编号，村民们在票上写上候选村长的编号即可完成投票。
    那么最后统计的票可形成一个整型数组。那么谁是村长呢？票数过半的那个人。
    摩尔投票算法可以快速的计算出一个数组中出现次数过半的数即大多数（majority），算法核心思想是同加，异减。
    算法会保存一个当前大多数，和得分，当遇到一个数不是当前大多数时，得分会减一，当减到0时，大多数会发生改变，并且重置得分为1。
    这里需要区分的是，摩尔算法不能用来得到众数（mode），例如数组：[1,1,1,2,2,3,3,4,4]，摩尔算法得出最后的结果应该是4，
    但4并不是众数，可是显然4也不是大多数，那是因为，大多数是指出现次数过半的数，而这个数组中没有这样的数，
    所以摩尔算法是是失效的，对于这种情况采取需要重新投票。
    */
    public int majorityElement_3(int[] nums) {
        int score = 0;
        int maj = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (score == 0)
            {
                maj = nums[i];
                score = 1;
            }
            else
            {
                if (nums[i] == maj)
                {
                    score++;
                }
                else
                {
                    score--;
                }
            }
        }
        return maj;
    }
}
