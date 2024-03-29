package com.lyp.leetcode;

/*
【快乐数】
编写一个算法来判断一个数是不是“快乐数”。
一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。
如果可以变为 1，那么这个数就是快乐数。

示例:
输入: 19
输出: true
解释:
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1
 */

import java.util.HashSet;

public class Sln202 {
    public boolean isHappy(int n) {
        int num = n;
        int sum = 0;
        HashSet<Integer> record = new HashSet<>();
        while (sum != 1) {
            sum = 0;

            while (num != 0) {
                int t = num % 10;
                sum += t * t;
                num /= 10;
            }

            if (record.contains(sum)) {
                return false;
            } else {
                record.add(sum);
                num = sum;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new Sln202().isHappy(19);
    }
}
