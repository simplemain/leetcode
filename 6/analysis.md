## 6. 锯齿形变换 [leetcode 6: ZigZag Conversion]

### 原题链接

[https://leetcode.com/problems/zigzag-conversion](https://leetcode.com/problems/zigzag-conversion)


### 老王的解法链接
[https://github.com/simplemain/leetcode/blob/master/6/analysis.md](https://github.com/simplemain/leetcode/blob/master/6/analysis.md)

### 难度

★★☆☆☆

### 标签

字符串

### 题目描述

给定一个字符串s和整数n, 求s做n行的锯齿形变换后, 顺序拼写而成的新字符串.
比如: s="PAYPALISHIRING", n=3, 锯齿形变换如下:

```
P   A   H   N
A P L S I I G
Y   I   R
```

再顺序从左到右, 从上到下的拼接成的字符串为: "PAHNAPLSIIGYIR"

### 输入样例

```
第一组: s = "PAYPALISHIRING", n = 3
第二组: s = "PAYPALISHIRING", n = 4
```

### 输出样例

```
第一组: PAHNAPLSIIGYIR
第二组: PINALSIGYAHRPI
```

### 解法分析

这道题最难的地方在于对题意的理解. 什么叫做锯齿形变换呢? 说白了, 就是按照下面这种顺序, 将原字符串的字符一个个的放到指定位置.

```
|   /|   /|
|  / |  / |
| /  | /  |
|/   |/   |
```

好了, 只要这个题意理解了, 这道题做起来其实也不难.

---

* 解法1 : 朴素的解法

这道题最直接的想法, 就是开一个n * m的二位数组, 然后将字符按照顺序一个个的填进去. 然后再扫描一下这个二位数组, 把结果拼接出来.

只不过开数组的时候, 要注意控制一下最大范围的取值, 不然数组容易太大.

完整代码请点击这里: [完整代码](https://github.com/simplemain/leetcode/blob/master/6/Solution1.java)

---

* 解法2 : 公式推算

如果我们要省掉额外的空间, 就可以采用计算的方式. 怎么算呢?

大家看下以下这个字符串的排列, s="0123456789abcdef", n=4

```
0    6    c 
1  5 7  b d
2 4  8 a  e
3    9    f
```

大家注意看, 我们从0-5, 6-b分开看的话, 他们是不是构成了一个一模一样的图案? 

如果学过y=sin(x)这个函数, 这个图案就是类似于这个函数的周期性函数. 这个周期的长度是多少呢? `2 * n - 2`.

好了, 对于这个周期函数的的第一行和最后一行, 只会有一个字符, 而中间的行数都会有两个.

再来观察, 我们只看第一个周期: 0-5这个位置. 第二行的两个数, 相加之和正好为6=`2 * n - 2`. 同理, 第三行也是.

那么, 我们就可以通过计算, 把第一个周期的每个数的下标计算出来了:

```
0
1   (2n-2)-1
2   (2n-2)-2
3   (2n-2)-3
4   (2n-2)-4
5   (2n-2)-5
...
n-3 n+1
n-2 n
n-1
```

好, 有了第一个周期以后, 剩下的就非常好办了. 我们就在第一个周期的每个元素下标上, 加上周期值就可以了:

```
0                 2n-2
1   (2n-2)-1      2n-2+1      (2n-2)+((2n-2)-1)
2   (2n-2)-2      2n-2+2      (2n-2)+((2n-2)-2)
3   (2n-2)-3      2n-2+3      (2n-2)+((2n-2)-3)
4   (2n-2)-4      2n-2+4      (2n-2)+((2n-2)-4)
5   (2n-2)-5      2n-2+5      (2n-2)+((2n-2)-5)
...               ...     
n-3 n+1           2n-2+(n-3)  (2n-2)+(n+1)
n-2 n             2n-2+(n-2)  (2n-2)+n
n-1               2n-2+(n-1)
```

然后我们只需要写一个for循环, 就可以把所有的位置顺序计算出来.

完整代码请点击这里: [完整代码](https://github.com/simplemain/leetcode/blob/master/6/Solution2.java)

---

好了, 这一题就分析到这里. 如果觉得老王的讲解有意思或有帮助, 可以给老王点个赞或者打个赏啥的, 老王就很开心啦~

<div align="center"><img src="https://github.com/simplemain/leetcode/blob/master/qrcode_pay.min.jpg" width="200" height="200" /></div>

咱下一题继续~~
