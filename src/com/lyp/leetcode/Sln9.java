package com.lyp.leetcode;

/*
【回文数】
判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

示例 1:
输入: 121
输出: true

示例 2:
输入: -121
输出: false
解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。

示例 3:
输入: 10
输出: false
解释: 从右向左读, 为 01 。因此它不是一个回文数。

进阶: 你能不将整数转为字符串来解决这个问题吗？
思路:
第一个想法是将数字转换为字符串，并检查字符串是否为回文。但是，这需要额外的非常量空间来创建问题描述中所不允许的字符串。

第二个想法是将数字本身反转，然后将反转后的数字与原始数字进行比较，如果它们是相同的，那么这个数字就是回文。
但是，如果反转后的数字大于int.MAX，会遇到整数溢出问题。

按照第二个想法，为了避免数字反转可能导致的溢出问题，为什么不考虑只反转int数字的一半？
毕竟，如果该数字是回文，其后半部分反转后应该与原始数字的前半部分相同。
例如，输入1221，我们可以将数字“1221”的后半部分从“21”反转为“12”，并将其与前半部分“12”进行比较，
因为二者相同，我们得知数字 1221 是回文。
 */
public class Sln9 {

    public boolean isPalindrome(int x) {
        if (x == 0)
            return true;
        if (x < 0 || (x % 10 == 0 && x != 0))
            return false;

        int revertedNum = 0;
        while (x > revertedNum) {
            int ge = x % 10;
            revertedNum = revertedNum * 10 + ge;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return (x == revertedNum) || (x == revertedNum / 10);
    }

    public static void main(String[] args) {
        Sln9 sln = new Sln9();
        System.out.println(sln.isPalindrome(12321));
        System.out.println(sln.isPalindrome(4664));
        System.out.println(sln.isPalindrome(1234));
        System.out.println(sln.isPalindrome(-999));
        System.out.println(sln.isPalindrome(30));
    }
}