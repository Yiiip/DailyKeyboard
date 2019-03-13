package com.lyp.leetcode;

/*
【反转字符串中的元音字母】
编写一个函数，以字符串作为输入，反转该字符串中的元音字母。

示例 1:
输入: "hello"
输出: "holle"

示例 2:
输入: "leetcode"
输出: "leotcede"

说明:
元音字母不包含字母"y"。
 */

public class Sln345 {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int l = 0, r = arr.length - 1;
        while (l < r)
        {
            while (!isAEIOU(arr[l]) && l < r)
                l++;
            while (!isAEIOU(arr[r]) && l < r)
                r--;
            if (l >= r)
                break;
            if (arr[l] != arr[r])
                swapChar(arr, l, r);
            r--;
            l++;
        }
        return String.valueOf(arr);
    }

    private boolean isAEIOU(char c)
    {
        return c == 'A' || c == 'a' || c == 'E' || c == 'e' || c == 'I' || c == 'i' || c == 'o' || c == 'O' || c == 'U' || c== 'u';
    }

    private void swapChar(char[] arr, int i, int j)
    {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args)
    {
        System.out.println(new Sln345().reverseVowels("hello"));
    }
}
