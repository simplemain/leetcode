## 3. 没有重复字母的最长子串 [leetcode 3: Longest Substring Without Repeating Characters]

### 原题链接

[https://leetcode.com/problems/longest-substring-without-repeating-characters](https://leetcode.com/problems/longest-substring-without-repeating-characters)


### 老王的解法链接
[https://github.com/simplemain/leetcode/blob/master/3/analysis.md](https://github.com/simplemain/leetcode/blob/master/3/analysis.md)

### 难度

★★☆☆☆

### 标签

字符串 / 判重

### 题目描述

输入一个字符串, 求他的一个子串的长度: 在这个子串里, `没有重复`的字母.

说明: 这里是要求`子串`(要求连续), 而不是`子序列`(不要求连续)

### 输入样例

```
第一组: abcabcbb
第二组: bbbbb
第三组: pwwkew
```

### 输出样例

```
第一组: 3 (因为最长无重复的子串是: abc)
第二组: 1 (最长就只有一个: b)
第三组: 3 (最长的是: wke)
```

### 解法分析

* 解法1 : 三重循环

这道题刚一看到的时候, 就觉得有点懵圈. 感觉完全无头绪. 但是镇静30秒以后, 其实还是有思路, 最简单的无非就是我用两个指针分别指向字符串的两个位置, 看看这两个位置之间的子串有没有重复的字符.

1. 如果没有, 就记录一下他的长度; 

2. 如果有, 就不符合我们要求, 跳出循环.

比如: 

```
abcdefgcd
  ^    ^
  p    q
```

我们用指针p和q分别指向字符串的两个位置, 然后再判断p和q之间是否有重复字符. 他们之间明显没有重复的, 所以他们的长度就可以记录下来, 看看是否是最大长度.

如果q指针再往后走一个, 他们之间就有重复的字母`c`了, 所以就不符合条件了.

最后, 将长度最大的那一个输出就是了. 

```java
for (int p = 0; p < len; p++)
{
	for (int q = p; q < len; q++)
	{
		final boolean isOK = judge(cs, p, q);
		if (!isOK) break;
		final int curLen = q - p + 1;
		if (curLen > maxLen)
		{
			maxLen = curLen;
		}
	}
}
```

代码看起来非常简洁, 不过呢, 就是执行效率不高. 大家看到基本上就是三重循环, 所以时间复杂度O(n^3).

完整代码请点击这里: [完整代码](https://github.com/simplemain/leetcode/blob/master/3/Solution1.java)

---

* 解法2 : 二重循环 + hash判重

我们既然有了第一种解法大的思路, 那么我们有没有优化的可能呢?

其实是可以的. 就是在`解法1`的第三重循环那里, 我们的目的是要判断是否有重复. 那既然是要判重复, 就可以不用循环, 可以直接用hash的方法. 这不就可以直接把性能提升了吗?

时间复杂度就降到: O(n^2) ~ O(n^2 * lgn) [为什么Hash是这个复杂度, 请参见老王在第一题中的分析哈]

完整代码请点击这里: [完整代码](https://github.com/simplemain/leetcode/blob/master/3/Solution2.java)

---

* 解法3: 二重循环 + 数组判重

因为是英文的网站, 所以要处理的字符串是ascii字符. 这里字符取值的范围就会落在[0, 255]之间. 那么, 我们就可以用一个char[256]数组, 取代HashSet来判断重复. 这样, 一定就可以保证时间复杂度控制在O(n^2).

这里其实是一个偷巧的做法. 不过这种做法应用场景也比较多, 只要`范围是固定的`且`范围的最大和最小值差值不大`, 我们就可以用这种方法.

即使这题含有中文字符, 用unicode编码, 我们也可以用一个char[65536]的数组来处理, 因为他满足我们上面说的两个条件.

完整代码请点击这里: [完整代码](https://github.com/simplemain/leetcode/blob/master/3/Solution3.java)

---

* 解法4: 滑动窗口

上述三种方法, 其实都是一种思路的衍生品. 那我们有没有更好的方法呢? 

其实是有的(这句是废话 ^o^).

我们最先用一个1 * 1的框, 将第一个字符框住.

```
[a]bcdefgcd
```

大家可以看到, 字符`a`已经被中括号代表的框给框起来了. 

好, 接下来我们把框试着往右边扩大一个, 看看有没有重复. 

如果没有, 我们就把右边的字符框进来.

```
[ab]cdefgcd
```

以此类推, 我们可以一直把框扩大到字符`g`.

```
[abcdefg]cd
```

不过, 当我们继续扩张的时候, 发现字符`c`重复了, 他之前就已经出现在框里了. 这个时候我们怎么办呢?

既然他已经出现在框里了, 就说明从框起始的地方开始, 已经不能继续往下延伸了, 对吧.

那我们就需要重新调整框起始的位置, 一直往右边挪. 挪到什么时候才停止呢? 直到新加入的那个元素`c`之前没在这个框里出现过. 也就是第一个`c`后面的位置.

```
abc[defgc]d
```

这样, 我们就能很快的找到没有重复字母出现的子串, 对不对?

不过新的子串有可能不是符合条件最长的, 没关系, 我们重复上面的动作, 让他的右边继续扩张, 直到抵达字符串的最后一个字符. 

这样, 我们就通过一遍扫描, 完成了算法的要求.

完整代码请点击这里: [完整代码](https://github.com/simplemain/leetcode/blob/master/3/Solution4.java)

---

* 解法5: 滑动窗口 + 位置记录

这个算法就是解法4的优化算法. 我们在找窗口里出现过的字符的时候, 需要将左括号`[`一个个的挪动, 看他和新的元素是不是相等, 这样效率不是很高. 

我们可以将窗口里每个元素的位置记录一下, 到时挪动的时候, 只需要从记录表里面查一下, 就知道应该将左括号`[`挪动到这个元素的`下一个位置`. 对吧~

完整代码请点击这里: [完整代码](https://github.com/simplemain/leetcode/blob/master/3/Solution5.java)

---

好了, 这一题就分析到这里. 如果觉得老王的讲解有意思或有帮助, 可以给老王点个赞或者打个赏啥的, 老王就很开心啦~

<div align="center"><img src="https://github.com/simplemain/leetcode/blob/master/qrcode_pay.min.jpg" width="200" height="200" /></div>

咱下一题继续~~
