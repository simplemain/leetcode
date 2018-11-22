## 7. 反转整数 [leetcode 7: Reverse Integer]

### 原题链接

[https://leetcode.com/problems/reverse-integer](https://leetcode.com/problems/reverse-integer)


### 老王的解法链接
[https://github.com/simplemain/leetcode/blob/master/7/analysis.md](https://github.com/simplemain/leetcode/blob/master/7/analysis.md)

### 难度

★★☆☆☆

### 标签

数字计算

### 题目描述

给一个32位有符号整数, 将这个整数的每一位进行反转.

注意: 假定我们的系统只能处理32位有符号整数[−2<sup>31</sup>,  2<sup>31</sup> − 1]. 如果反转后越界, 则返回0.

### 输入样例

```
第一组: 123
第二组: -123
第三组: 120
```

### 输出样例

```
第一组: 321
第二组: -321
第三组: 21
```

### 解法分析

---

* 解法1 : 朴素的解法

这道题晃眼一看, 好像很简单. 直接用整数取余, 然后再拼接就可以了. 只不过要注意有可能要越界, 所以用一个64位的long存储就可以了.

完整代码请点击这里: [完整代码](https://github.com/simplemain/leetcode/blob/master/7/Solution1.java)

---

* 解法2 : 带有一些技巧的解法

我们注意看这题特别加了一个`注意`, 假定系统只能处理32位带符号的整数. 

这句话什么意思呢? 就是你`不能使用64位的long`!!!

(话说出这个题的人确实有点x)

那我们怎么解决呢?

其实考点就是很明确了: 我们需要考虑`越界`的问题.

要处理越界, 实际上就是要在越界之前, 就能提前判断, 他即将越界.

老王的思想就是: 管他越不越界, 我们把一个整数拆分成两段来存储. 

比如, 我们将一个整数分解成三个部分:

* 符号用整数sign存储;
* 万位以上用一个整数upper来存储;
* 万位以下用另外一个整数lower存储. 

n = sign * (upper * 10000 + lower)

具体如下:

```java
* n=9876543210  拆分成=> sign=1,  upper=987654, lower=3210
* n=-9876543210 拆分成=> sign=-1, upper=987654, lower=3210

这样, 我们把最大/最小32位整数也做类似处理: 
* 2147483647(2^31 − 1) => S=1, U_MAX=214748, L_MAX=3647
* -2147483648(-2^31)   => S=-1, U_MIN=214748, L_MIN=3648

这样, 只要我们判断:

if: sign == 1 && upper >= U_MAX && lower > L_MAX ; then 向上越界
if: sign == -1 && upper >= U_MIN && lower > L_MIN; then 向下越界
```

这样, 我们就规避掉了64位的问题. 剩余代码就比较简单了.

完整代码请点击这里: [完整代码](https://github.com/simplemain/leetcode/blob/master/7/Solution2.java)

---

好了, 这一题就分析到这里. 如果觉得老王的讲解有意思或有帮助, 可以给老王点个赞或者打个赏啥的, 老王就很开心啦~

<div align="center"><img src="https://github.com/simplemain/leetcode/blob/master/qrcode_pay.min.jpg" width="200" height="200" /></div>

咱下一题继续~~
