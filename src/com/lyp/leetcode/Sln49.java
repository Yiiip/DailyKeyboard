package com.lyp.leetcode;

/*
【字母异位词分组】
给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:
输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
说明: 所有输入均为小写字母。不考虑答案输出的顺序。
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Sln49 {
    //想用ASCII的和来存储键，但这是错误的
    public List<List<String>> groupAnagrams_0(String[] strs) {
        HashMap<Integer, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++)
        {
            int sum = 0;
            for (char c: strs[i].toCharArray())
            {
                sum += c; //写成sum += c*c*c*c才能通过，这只是自己瞎试出来的= =！
            }
            if (map.containsKey(sum))
            {
                map.get(sum).add(strs[i]);
            }
            else
            {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(sum, list);
            }
        }
        return new ArrayList<>(map.values());
    }

    //排序思路
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++)
        {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String k = String.valueOf(chars);
            if (map.containsKey(k))
            {
                map.get(k).add(strs[i]);
            }
            else
            {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(k, list);
            }
        }
        return new ArrayList<>(map.values());
    }

    //计数思路
    public List<List<String>> groupAnagrams_2(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        int[] count = new int[26];
        for (int i = 0; i < strs.length; i++)
        {
            Arrays.fill(count, 0);
            for (char c : strs[i].toCharArray())
            {
                count[c - 'a']++;
            }

            String k = Arrays.toString(count);
            if (!map.containsKey(k))
            {
                map.put(k, new ArrayList<>());
            }
            map.get(k).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        System.out.println(new Sln49().groupAnagrams_2(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
