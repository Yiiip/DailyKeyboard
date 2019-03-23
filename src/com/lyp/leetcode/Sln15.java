package com.lyp.leetcode;

/*
【三数之和】
给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */

import java.util.*;

public class Sln15 {

    /* 通过311/313，剩下两个超时啊
    public List<List<Integer>> threeSum(int[] nums) {
        List<ThreeNum> threeNums = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i <= nums.length - 3; i++)
        {
            int cur = nums[i];
            int target = 0 - cur;
            set.clear();
            for (int j = i + 1; j < nums.length; j++)
            {
                int complement = target - nums[j];
                if (!set.contains(complement))
                {
                    set.add(nums[j]);
                }
                else
                {
                    ThreeNum threeNum = new ThreeNum(cur, nums[j], complement);
                    if (!threeNums.contains(threeNum))
                        threeNums.add(threeNum);
                }
            }
        }
        List<List<Integer>> format = new ArrayList<>();
        for (int i = 0; i < threeNums.size(); i++) {
            format.add(threeNums.get(i).toList());
        }
        return format;
    }

    private class ThreeNum {
        public Integer a, b, c;
        public ThreeNum(int a, int b, int c) {
            int[] arr = new int[] {a, b, c};
            Arrays.sort(arr);
            this.a = arr[0];
            this.b = arr[1];
            this.c = arr[2];
        }
        public List<Integer> toList() {
            ArrayList<Integer> ret = new ArrayList<>();
            ret.add(a);
            ret.add(b);
            ret.add(c);
            return ret;
        }
        @Override
        public boolean equals(Object obj) {
            if (obj.getClass() == this.getClass()) {
                if (((ThreeNum) obj).a == this.a && ((ThreeNum) obj).b == this.b && ((ThreeNum) obj).c == this.c)
                    return true;
            }
            return false;
        }
    }
    */

    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < len; i++)
        {
            int opposite = -nums[i];
            if (i == 0 || nums[i] != nums[i - 1])
            {
                int left = i + 1, right = len - 1;
                while (left < right)
                {
                    int twoSum = nums[left] + nums[right];
                    if (twoSum == opposite)
                    {
                        List<Integer> ans = new ArrayList<>();
                        ans.add(nums[i]);
                        ans.add(nums[left]);
                        ans.add(nums[right]);
                        res.add(ans);
                        left = moveLeft(nums, left, right);
                        right = moveRight(nums, left, right);
                    }
                    else if (twoSum < opposite)
                    {
                        left = moveLeft(nums, left, right);
                    }
                    else
                    {
                        right = moveRight(nums, left, right);
                    }
                }
            }
        }
        return res;
    }

    private int moveLeft(int[] nums, int left, int right) {
        int num = nums[left++];
        while (left <= right) {
            if (nums[left] != num)
                break;
            left++;
        }
        return left;
    }

    private int moveRight(int[] nums, int left, int right) {
        int num = nums[right--];
        while (left <= right) {
            if (nums[right] != num)
                break;
            right--;
        }
        return right;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new Sln15().threeSum(new int[] {
            -1, 0, 1, 2, -1, -4
        });
        System.out.println(result.toString());
    }
}
