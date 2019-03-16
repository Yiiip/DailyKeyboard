package com.lyp.leetcode;

/*
【回旋镖的数量】
给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，
其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。
                                      ↑（500暗示可以用O(n^2)的算法）

示例:
输入: [[0,0],[1,0],[2,0]]
输出: 2
解释: 两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 */

import java.util.HashMap;

public class Sln447 {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        int pointCount = points.length;
        HashMap<Integer, Integer> distanceRecord = new HashMap<>();
        for (int i = 0; i < pointCount; i++)
        {
            distanceRecord.clear();
            for (int j = 0; j < pointCount; j++)
            {
                if (i != j)
                {
                    int dis = disSq(points[i], points[j]);
                    if (!distanceRecord.containsKey(dis))
                    {
                        distanceRecord.put(dis, 1);
                    }
                    else
                    {
                        distanceRecord.put(dis, distanceRecord.get(dis) + 1);
                    }
                }
            }
            for (Integer count : distanceRecord.values())
            {
                if (count >= 2)
                {
                    res += (count * (count - 1));
                }
            }
        }
        return res;
    }

    private int disSq(int[] p1, int[] p2) //[-10000, -10000]到[10000, 10000]未超过int
    {
        return (p2[0] - p1[0]) * (p2[0] - p1[0]) + (p2[1] - p1[1]) * (p2[1] - p1[1]);
    }

    public static void main(String[] args)
    {
        int[][] points = new int[3][2];
        points[0] = new int[] {0, 0};
        points[1] = new int[] {1, 0};
        points[2] = new int[] {2, 0};
        Sln447 sln = new Sln447();
        int result = sln.numberOfBoomerangs(points);
        System.out.println("Result = " + result);
    }
}
