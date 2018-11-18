## 1. 两个数的和 [leetcode 1: Two Sum]

### 原题链接

[https://leetcode.com/problems/two-sum](https://leetcode.com/problems/two-sum)


### 老王的解法链接
[https://github.com/simplemain/leetcode/blob/master/1/analysis.md](https://github.com/simplemain/leetcode/blob/master/1/analysis.md)

### 难度

★☆☆☆☆

### 标签

循环 / 二分搜索 / 排序 / 哈希

### 题目描述

输入一个`整数数组`和一个`整数`, 要求找出数组中的`两个数`, 使得`他们的和`刚好`等于`输入的`整数`. 最后返回这两个数的`下标`.

说明: 每一组输入`刚好`有一组唯一解. 同一个元素不能使用两次.

### 输入样例

```
nums = [2, 7, 11, 15]
target = 9
```

### 输出样例

```
[0, 1]
因为: nums[0] + nums[1] = 2 + 7 = 9
```

### 解法分析

* 解法1 : 二重循环

这个题目最简单的算法就是, 我先从数组中拿出一个数, 然后再去遍历看有没有另外一个数和这个数加起来等于目标值. 所以就可以使用两个for循环, 直接查找. 关键代码如下:

```java
for (int i = 0; i < nums.length; i++)
{
    for (int j = i + 1; j < nums.length; j++)
    {
        if (nums[i] + nums[j] == target)
        {
            return new int[] {i, j};
        }
    }
}
```

完整代码请点击这里: [完整代码](https://github.com/simplemain/leetcode/blob/master/1/Solution1.java)

这种算法的优点就是简单直接. 但是缺点也很明显, 就是时间复杂度比较高: O(n^2).

那有没有更好的办法呢? 其实是有的, 我们接着往下看.

---

* 解法2 : 排序加二分查找

我们从上一种解法出发, 看看怎么能优化呢? 

当我们从数组中拿出第一个数以后, 想要找出是否存在另外一个数. 那找另外一个数, 是否可以不用循环呢? 是可以的. 如果我们提前将数组排好序, 接下来就可以用二分搜索, 进行快速的查找了. 

这样, 整体的时间复杂度就是O(nlgn).

完整代码请点击这里: [完整代码](https://github.com/simplemain/leetcode/blob/master/1/Solution2.java)

---

* 解法3 : hash

hash, 好多算法的通用王牌解法. 这道题我们其实也可以用这种方法.

我们先将所有的数放入到HashMap中, 然后再用循环依次取出数组中的元素, 最后用target减去取出的元素, 看看他们的差是否在HashMap中.

如果hash表冲突不大, 查找hash表的时间复杂度大约为O(1). 整体时间复杂度约为O(n);

如果hash表冲突很大, 就看具体实现了. Java8里面用了红黑树, 最坏情况退化成O(lgn)的查找, 从而最后的时间复杂度约为O(nlgn).

完整代码请点击这里: [完整代码](https://github.com/simplemain/leetcode/blob/master/1/Solution3.java)

---

好了, 这一题就分析到这里. 如果觉得老王的讲解有意思或有帮助, 可以给老王点个赞或者打个赏啥的, 老王就很开心啦~

<div align="center"><img src="https://github.com/simplemain/leetcode/blob/master/qrcode_pay.min.jpg" width="200" height="200" /></div>

咱下一题继续~~
