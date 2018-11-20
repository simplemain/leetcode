## 5. 最长镜像子串 [leetcode 5: Longest Palindromic Substring]

### 原题链接

[https://leetcode.com/problems/longest-palindromic-substring](https://leetcode.com/problems/longest-palindromic-substring)


### 老王的解法链接
[https://github.com/simplemain/leetcode/blob/master/5/analysis.md](https://github.com/simplemain/leetcode/blob/master/5/analysis.md)

### 难度

★★☆☆☆

### 标签

子串

### 题目描述

给定一个字符串s, 求他的最长镜像子串. 假定s的最大长度为1000.

说明: 镜像串, 就是从中间往两边看, 都是一摸一样的. 比如: abcba, abccba.

### 输入样例

```
第一组: babad
第二组: cbbd
```

### 输出样例

```
第一组: bab (aba也是符合要求的)
第二组: bb
```

### 解法分析

* 解法1 : 朴素的解法

拿到这个题以后, 最直接的一个算法, 就是遍历字符串里面每一个字符. 看看以他为中心向两边展开, 是不是可以构成镜像串.

当然展开的时候, 注意`奇数`和`偶数`的方式都要检查一下. 

比如: baab, 检查第一个a的时候, 既要检查b[a]ab, 也要检查b[aa]b, 否则就会遗漏.

代码实现也比较简单, 时间复杂度为O(n ^ 2)

完整代码请点击这里: [完整代码](https://github.com/simplemain/leetcode/blob/master/5/Solution1.java)

---

好了, 这一题就分析到这里. 如果觉得老王的讲解有意思或有帮助, 可以给老王点个赞或者打个赏啥的, 老王就很开心啦~

<div align="center"><img src="https://github.com/simplemain/leetcode/blob/master/qrcode_pay.min.jpg" width="200" height="200" /></div>

咱下一题继续~~
