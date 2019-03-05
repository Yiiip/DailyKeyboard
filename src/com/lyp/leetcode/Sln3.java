package com.lyp.leetcode;

/*
【无重复字符的最长子串】[双指针：滑动窗口]
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:
输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

示例 2:
输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */

public class Sln3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty())
            return 0;

        int l = 0, r = -1; //滑动窗口为nums[i...j]
        int[] freq = new int[256]; //记录每个字符出现的频率，若为0则表示没有出现过
        int result = 0;

        while (l < s.length())
        {
            if (r + 1 < s.length() && freq[s.charAt(r + 1)] == 0)
            {
                r++;
                freq[s.charAt(r)] ++;
            }
            else
            {
                freq[s.charAt(l)] --;
                l++;
            }
            result = Math.max(result, r-l+1);
        }
        return result;
    }
}
