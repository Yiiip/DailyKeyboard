package com.lyp.leetcode;

/*
【验证回文串】
给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
说明：本题中，我们将空字符串定义为有效的回文串。

示例 1:
输入: "A man, a plan, a canal: Panama"
输出: true

示例 2:
输入: "race a car"
输出: false
 */

public class Sln125 {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        s = s.toLowerCase();
        while (l < r)
        {
            char chL = s.charAt(l);
            char chR = s.charAt(r);
            if (!isConsidered(chL))
            {
                l++;
                continue;
            }
            if (!isConsidered(chR))
            {
                r--;
                continue;
            }

            if (chL != chR)
            {
                return false;
            }
            else
            {
                l++;
                r--;
            }
        }
        return true;
    }

    private boolean isConsidered(char c)
    {
//        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
        return Character.isLetterOrDigit(c);
    }

    public static void main(String[] args)
    {
        boolean result = new Sln125().isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(result);
    }
}
