package com.lyp.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/*
【有效的字母异位词】
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。

示例 1:
输入: s = "anagram", t = "nagaram"
输出: true

示例 2:
输入: s = "rat", t = "car"
输出: false

说明:你可以假设字符串只包含小写字母。

进阶:如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */

/**
 * 什么是异位词?
 *     两个单词如果包含相同的字母，次序不同，则称为字母易位词(anagram)
 * 异位词特点
 *     字符数相同/顺序不同/出现字符相同
 * 思路
 *     既然是找寻字符串的不同，那我们可以直接建立对应的 哈希表，来对两个 hash 表 进行操作
 *     在比对的时候可以达到O(1)的复杂度
 */

public class Sln242 {
    public boolean isAnagram(String s, String t) { //50 ms
        HashMap<Character, Integer> sMap = new HashMap<>();
        for (char c : s.toCharArray())
        {
            if (sMap.containsKey(c))
                sMap.put(c, sMap.get(c) + 1);
            else
                sMap.put(c, 1);
        }
        for (char c : t.toCharArray())
        {
            if (sMap.containsKey(c))
            {
                if (sMap.get(c) - 1 <= 0)
                    sMap.remove(c);
                else
                    sMap.put(c, sMap.get(c) - 1);
            }
            else
                return false;
        }
        return sMap.isEmpty();
    }

    public boolean isAnagram_2(String s, String t) { //3 ms
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        int[] charCount = new int[26];
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            charCount[c - 'a']--;
        }
        for (int count : charCount) {
            if (count > 0)
                return false;
        }
        return true;
    }

    public boolean isAnagram_3(String s, String t) {
        if(s.length() != t.length())
            return false;
        char[] ss=s.toCharArray();
        char[] ts=t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(ts);
        return Arrays.equals(ss,ts);
    }
}

