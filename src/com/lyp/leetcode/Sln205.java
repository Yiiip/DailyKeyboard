package com.lyp.leetcode;

/*
【同构字符串】
给定两个字符串 s 和 t，判断它们是否是同构的。
如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。

示例 1:
输入: s = "egg", t = "add"
输出: true

示例 2:
输入: s = "foo", t = "bar"
输出: false

示例 3:
输入: s = "paper", t = "title"
输出: true

说明: 你可以假设 s 和 t 具有相同的长度。
 */

import java.util.HashMap;

public class Sln205 {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;

        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
        {
            char ss = s.charAt(i);
            char tt = t.charAt(i);

            if (map.containsKey(ss))
            {
                if (map.get(ss) == tt)
                    continue;
                else
                    return false;
            }
            else
            {
                if (map.containsValue(tt))
                    return false;
                else
                    map.put(ss, tt);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Sln205 sln = new Sln205();
        System.out.println(sln.isIsomorphic("egg", "add"));
        System.out.println(sln.isIsomorphic("foo", "bar"));
        System.out.println(sln.isIsomorphic("paper", "title"));
    }
}
