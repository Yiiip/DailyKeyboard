package com.lyp.leetcode;

/*
【单词模式】
给定一种 pattern(模式) 和一个字符串 str ，判断 str 是否遵循相同的模式。
这里的遵循指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应模式。

示例1:
输入: pattern = "abba", str = "dog cat cat dog"
输出: true

示例 2:
输入:pattern = "abba", str = "dog cat cat fish"
输出: false

示例 3:
输入: pattern = "aaaa", str = "dog cat cat dog"
输出: false

示例 4:
输入: pattern = "abba", str = "dog dog dog dog"
输出: false

说明: 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
 */

import java.util.HashMap;

public class Sln290 {
    public boolean wordPattern(String pattern, String str) {
        char[] patternArr = pattern.toCharArray();
        String[] strArr = str.split(" ");

        if (patternArr.length != strArr.length)
            return false;

        HashMap<Character, String> pMap = new HashMap<>();
        HashMap<String, Character> sMap = new HashMap<>();
        for (int i = 0; i < patternArr.length; i++)
        {
            char c = patternArr[i];
            String s = strArr[i];

            if (!pMap.containsKey(c))
            {
                pMap.put(c, s);
            }
            if (!sMap.containsKey(s))
            {
                sMap.put(s, c);
            }

            if (pMap.get(c).equals(s) && sMap.get(s).equals(c))
            {
                continue;
            }
            else
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Sln290 sln = new Sln290();
        System.out.println(sln.wordPattern("abba", "dog cat cat dog"));
        System.out.println(sln.wordPattern("abba", "dog cat cat fish"));
        System.out.println(sln.wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(sln.wordPattern("abba", "dog dog dog dog"));
    }
}
