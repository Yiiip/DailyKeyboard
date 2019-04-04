# LeetCode

## 整理

|  ID  | Problem | Tag | Note |
| :--: | :------ | :-- | :--- |
| 0001 | 两数之和 | 数组，哈希表 | ![gif](https://github.com/Yiiip/DailyKeyboard/blob/master/res/leetcode/images/0001.gif) |
| 0003 | 无重复字符的最长子串 | 字符串，双指针，查找表，滑动窗口（不固定长度） | ![gif](https://github.com/Yiiip/DailyKeyboard/blob/master/res/leetcode/images/0003.gif) 由于查找表数据量很少，直接使用array而不是Set了 |
| 0011 | 盛最多水的容器 | 数组，双指针 |  |
| 0015 | 三数之和 | 数组，双指针 | ①在有序的情况下，遍历时注意和前一相比较以跳过重复项<br/>②本题有序的情况下，while(l < r)就成了根据大小而变的滑动窗口 |
| 0016 | 最接近的三数之和 | 数组，双指针 |  |
| 0018 | 四数之和 | 数组，双指针，哈希表 |  |
| 0019 | 删除链表的倒数第N个节点 | 链表，双指针 | 有关链表的操作可借助虚拟头节点使得操作更加方便，特别是删除操作，我们学要知道前一个节点，使用虚拟头节点就可以轻松处理包括头节点在内的节点删除。 ![gif](https://github.com/Yiiip/DailyKeyboard/blob/master/res/leetcode/images/0019.gif) |
| 0020 | 有效的括号 | 字符串，栈 | ![gif](https://github.com/Yiiip/DailyKeyboard/blob/master/res/leetcode/images/0020.gif) |
| 0024 | 两两交换链表中的节点 | 链表 | ![gif](https://github.com/Yiiip/DailyKeyboard/blob/master/res/leetcode/images/0024.gif) |
| 0026 | 删除排序数组中的重复项 | 数组，双指针 | ![gif](https://github.com/Yiiip/DailyKeyboard/blob/master/res/leetcode/images/0026.gif) |
| 0027 | 移除元素 | 数组，双指针 |  |
| 0049 | 字母异位词分组 | 字符串，哈希表 |  |
| 0066 | 加一 | 数组 | 也要考虑大数溢出 |
| 0075 | 颜色分类 | 数组，双指针（对撞指针），排序 | 计数排序 或 三路快排 ![gif](https://github.com/Yiiip/DailyKeyboard/blob/master/res/leetcode/images/0075.gif) |
| 0076 | 最小覆盖子串 | 数组，双指针，滑动窗口，字符串，哈希表 |  |
| 0080 | 删除排序数组中的重复项 II | 数组，双指针 |  |
| 0088 | 合并两个有序数组 | 数组，双指针 | 归并排序中merge阶段的思想 |
| 0094 | 二叉树的中序遍历 | 树，栈，哈希表 | ![gif](https://github.com/Yiiip/DailyKeyboard/blob/master/res/leetcode/images/0094.gif) |
| 0098 | 验证二叉搜索树 | 树，深度优先搜索 |  |
| 0102 | 二叉树的层次遍历 | 树，广度优先搜索 | ![gif](https://github.com/Yiiip/DailyKeyboard/blob/master/res/leetcode/images/0102.gif) |
| 0107 | 二叉树的层次遍历 II | 树，广度优先搜索 |  |
| 0121 | 买卖股票的最佳时机 | 数组，动态规划 |  |
| 0122 | 买卖股票的最佳时机 II | 数组，贪心算法 | 峰谷法 |
| 0125 | 验证回文串 | 字符串，双指针（对撞指针） |  |
| 0136 | 只出现一次的数字 | 数学，哈希表 | 异或运算(^) ![gif](https://github.com/Yiiip/DailyKeyboard/blob/master/res/leetcode/images/0136.gif) |
| 0144 | 二叉树的前序遍历 | 树，栈 | ![gif](https://github.com/Yiiip/DailyKeyboard/blob/master/res/leetcode/images/0144.gif) |
| 0144 | 二叉树的后序遍历 | 树，栈 | ![gif](https://github.com/Yiiip/DailyKeyboard/blob/master/res/leetcode/images/0145.gif) |
| 0167 | 两数之和 II：输入有序数组 | 数组，双指针（对撞指针，滑动窗口），二分查找 |  |
| 0169 | 求众数 | 数组，分治算法 | 摩尔投票算法 |
| 0189 | 旋转数组 | 数组 |  |
| 0202 | 快乐数 | 哈希表，数学 |  |
| 0203 | 移除链表元素 | 链表 | ![gif](https://github.com/Yiiip/DailyKeyboard/blob/master/res/leetcode/images/0203.gif) 有关链表的操作基本都可以用递归来实现 |
| 0206 | 反转链表 | 链表 | ![gif](https://github.com/Yiiip/DailyKeyboard/blob/master/res/leetcode/images/0206.gif) |
| 0205 | 同构字符串 | 哈希表，字符串 | 关联题0290 |
| 0209 | 长度最小的子数组 | 数组，双指针，滑动窗口，二分查找 | ![gif](https://bucket-1257126549.cos.ap-guangzhou.myqcloud.com/20181210093031.gif) |
| 0215 | 数组中的第K个最大元素 | 数组，双指针，堆，分治算法，快排 |  |
| 0217 | 存在重复元素 | 数组，哈希表 |  |
| 0219 | 存在重复元素 II | 数组，哈希表，滑动窗口（固定长度） | ![gif](https://github.com/Yiiip/DailyKeyboard/blob/master/res/leetcode/images/0219.gif) |
| 0237 | 删除链表中的节点 | 链表 | 通过改变节点的值来实现删除操作 |
| 0238 | 除自身以外数组的乘积 | 数组 |  |
| 0242 | 有效的字母异位词 | 字符串，哈希表，排序 | 哈希表计数统计 |
| 0283 | 移动0 | 数组，双指针 | ![gif](https://github.com/Yiiip/DailyKeyboard/blob/master/res/leetcode/images/0283.gif) |
| 0290 | 单词模式 | 哈希表，字符串 | 关联题0205 |
| 0344 | 反转字符串 | 字符串，双指针（对撞指针） | ![png](https://github.com/Yiiip/DailyKeyboard/blob/master/res/leetcode/images/0344.png) |
| 0345 | 反转字符串中的元音字母 | 字符串，双指针（对撞指针） |  |
| 0349 | 两个数组的交集 | 数组，双指针，哈希表，排序，二分查找 | ![gif](https://github.com/Yiiip/DailyKeyboard/blob/master/res/leetcode/images/0349.gif) |
| 0350 | 两个数组的交集 II | 数组，双指针，哈希表，排序，二分查找 | 哈希表计数统计 ![gif](https://github.com/Yiiip/DailyKeyboard/blob/master/res/leetcode/images/0350.gif) |
| 0384 | 打乱数组 |  | 洗牌算法 |
| 0438 | 找到字符串中所有字母异位词 | 字符串，双指针，滑动窗口，哈希表 |  |
| 0447 | 回旋镖的数量 | 哈希表 | ![gif](https://github.com/Yiiip/DailyKeyboard/blob/master/res/leetcode/images/0447.gif) |
| 0451 | 根据字符出现频率排序 | 哈希表，字符串，堆 |  |
| 0454 | 四数相加 II | 哈希表，二分查找 | ![gif](https://github.com/Yiiip/DailyKeyboard/blob/master/res/leetcode/images/0454.gif) |
| 0724 | 寻找数组的中心索引 | 数组，求和 |  |