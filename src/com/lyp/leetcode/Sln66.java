package com.lyp.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/*
【加一】
给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1:

输入: [9,9,9]
输出: [1,0,0,0]
解释: 输入数组表示数字 999。
示例 2:

输入: [4,3,2,1]
输出: [4,3,2,2]
解释: 输入数组表示数字 4321。

示例 3:
输入: [9,8,7,6,5,4,3,2,1,0]
输出: [9,8,7,6,5,4,3,2,1,1]
 */

public class Sln66 {
    //错误：大数溢出
    // public int[] plusOne(int[] digits) {
    //     long number = 0;

    //     int len = digits.length;
    //     for (int i = len - 1; i >= 0; i--) {
    //         // long tmp = Math.pow(10, (len - i - 1)) * digits[i]; //溢出
    //         // number += tmp;
    //         long tmp = 1;
    //         int times = (len - 1 - i);
    //         for (int t = 1; t <= times; t++) { //也会溢出
    //             tmp *= 10;
    //         }
    //         number += tmp * digits[i];
    //     }

    //     number++;

    //     List<Integer> list = new ArrayList<Integer>();
    //     while (number != 0) {
    //         list.add((int) (number % 10));
    //         number /= 10;
    //     }
    //     int[] newNum = new int[list.size()];
    //     for (int i = 0; i <= newNum.length - 1; i++) {
    //         newNum[i] = list.get(newNum.length - i - 1);
    //     }
    //     return newNum;
    // }

    public int[] plusOne(int[] digits) {
        digits[digits.length -1] += 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 10) {
                return digits;
            } else {
                digits[i] = 0;
                if (i != 0) {
                    digits[i-1] += 1;
                }
            }
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        System.arraycopy(digits, 0, res, 1, digits.length);
        return res;
    }

    public int[] plusOne_2(int[] digits) {
        digits[digits.length - 1]++;
        if(digits[digits.length - 1] > 9)
        {
            int j = digits.length - 1;
            while(j > 0 && digits[j] > 9)
            {
                digits[j] -= 10;
                j--;
                digits[j]++;
            }
        }
        if(digits[0] > 9)
        {
            int[] res=new int[digits.length+1];
            res[0] = 1;
            res[1] = digits[0] - 10;
            System.arraycopy(digits,1,res,2,digits.length - 1);
            return res;
        }
        return digits;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int len = sc.nextInt();
        int[] digits = new int[len];
        for (int i = 0; i < len; i++) {
            digits[i] = sc.nextInt();
        }

        int[] plusOne = new Sln66().plusOne(digits);

        System.out.println(Arrays.toString(plusOne));
    }
}
