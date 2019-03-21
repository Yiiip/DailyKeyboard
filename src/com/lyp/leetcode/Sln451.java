package com.lyp.leetcode;

import java.util.*;

/*
【根据字符出现频率排序】
给定一个字符串，请将字符串里的字符按照出现的频率降序排列。

示例 1:
输入:"tree"
输出:"eert"
解释:'e'出现两次，'r'和't'都只出现一次。因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。

示例 2:
输入:"cccaaa"
输出:"cccaaa"
解释:'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。注意"cacaca"是不正确的，因为相同的字母必须放在一起。

示例 3:
输入:"Aabb"
输出:"bbAa"
解释:此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。注意'A'和'a'被认为是两种不同的字符。
 */

public class Sln451 {
    public String frequencySort(String s) {
        HashMap<Character, CharFreq> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (map.containsKey(c))
            {
                map.get(c).freq++;
            }
            else
            {
                map.put(c, new CharFreq(c, 1));
            }
        }

        StringBuilder ret = new StringBuilder();
        ArrayList<CharFreq> list = new ArrayList<>(map.values());
        list.sort(new CharFreq());
        for (CharFreq e : list) {
            for (int i = 0; i < e.freq; i++) {
                ret.append(e.c);
            }
        }
        return ret.toString();
    }

    private class CharFreq implements Comparator<CharFreq> {
        public char c;
        public int freq = 1;
        public CharFreq() { }
        public CharFreq(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }
        @Override
        public int compare(CharFreq o1, CharFreq o2) {
            if (o1.freq - o2.freq > 0)
                return -1;
            else if (o1.freq - o2.freq < 0)
                return 1;
            else
                return 0;
        }
    }


    public String frequencySort_2(String s) {
        int[] counts = new int[256];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i)]++;
        }
        List<Character>[] lists = new List[s.length() + 1];
        for (char i = 0; i < 256; i++) {
            if (counts[i] == 0)
                continue;
            if (lists[counts[i]] == null)
                lists[counts[i]] = new ArrayList<>();
            lists[counts[i]].add(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = s.length(); i > 0; i--) {
            if (lists[i] == null)
                continue;
            for (char ch : lists[i]) {
                for (int t = 0; t < i; t++) {
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Sln451().frequencySort("tree"));
    }
}
