package com.lyp.leetcode;

/*
【四数相加 II】
给定四个包含整数的数组列表 A,B,C,D ，计算 有多少个 元组(i, j, k, l)，使得 A[i] + B[j] + C[k] + D[l] = 0。
为了使问题简单化，所有的 A,B,C,D 具有相同的长度 N，且 0 ≤ N ≤ 500 。
所有整数的范围在 -2^28 到 2^28 - 1 之间，最终结果不会超过 2^31 - 1 。

例如:
输入:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]
输出:
2

解释:
两个元组如下:
1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 */

import java.util.HashMap;
import java.util.Map;

public class Sln454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) { //O(n^2)，控制在O(n^3)和O(n^4)之下
        assert (A.length == B.length && B.length == C.length && C.length == D.length);

        Map<Integer, Integer> record = new HashMap<>();
        for (int i = 0; i < A.length; i++)
        {
            for (int j = 0; j < B.length; j++)
            {
                int sum = A[i] + B[j];
                if (record.containsKey(sum))
                {
                    record.put(sum, record.get(sum) + 1);
                }
                else
                {
                    record.put(sum, 1);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < C.length; i++)
        {
            for (int j = 0; j < D.length; j++)
            {
                int find = 0 - C[i] - D[j];
                if (record.containsKey(find))
                {
                    count += record.get(find);
                }
            }
        }
        return count;
    }
}
