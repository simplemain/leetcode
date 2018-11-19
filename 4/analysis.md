## 4. 两个有序数组的中值 [leetcode 4: Median of Two Sorted Arrays]

### 原题链接

[https://leetcode.com/problems/median-of-two-sorted-arrays](https://leetcode.com/problems/median-of-two-sorted-arrays)


### 老王的解法链接
[https://github.com/simplemain/leetcode/blob/master/4/analysis.md](https://github.com/simplemain/leetcode/blob/master/4/analysis.md)

### 难度

★★★★☆

### 标签

排序 / 归并 / 二分查找

### 题目描述

输入两个`有序`数组nums1和nums2, 大小分别为m和n. 找出这两个数组的`中位数`. 

要求整个计算的时间复杂度为 `O(log (m+n))`.

假定nums1和nums2不都为空.

### 输入样例

```
第一组: nums1 = [1, 3], nums2 = [2]
第二组: nums1 = [1, 2], nums2 = [3, 4]
```

### 输出样例

```
第一组: 2.0
第二组: 2.5, 因为 (2 + 3) / 2 = 2.5
```

### 解法分析

* 解法1 : 排序

这道题看到以后的第一个反应: 不是可以直接将两个数组合并, 然后`快速排序`一下, 直接就可以找到中间的数了吗?

代码大体长这个样:

```java
Arrays.sort(all);
final int mid = totalLength / 2;
return totalLength % 2 == 0 ? (all[mid - 1] + all[mid]) * 0.5 : all[mid];
```

完整代码请点击这里: [完整代码](https://github.com/simplemain/leetcode/blob/master/4/Solution1.java)

这种算法的优点就是简单直接. 但是缺点也很明显, 就是时间复杂度比较高: O((m + n)lg(m + n)).

因为我们用到了快速排序.

那有没有更好的办法呢? 其实是有的, 我们接着往下看.

---

* 解法2 : 归并思想的遍历

大家发现没有, 我们上一种方法实际上忽略了一个条件: nums1和nums2数组是`有序`的. 既然已经排好序了, 我们为什么还要用快速排序呢?

所以, 在算法1的基础上, 我们可以把这个条件使用上. 

我们可以利用归并的思想:

1. 用`两个指针`指向这两个数组的第一个元素, 并新建一个大小为m+n的大数组all;

2. 每次选出两个数组中`小的`那个数, 把他依次放入大数组all中;

3. 如果其中一个数组的指针已经到数组末尾了, 我们就把另外一个数组剩余的元素全部拷贝到all中;

4. 通过计算中位数的位置, 返回计算结果.

大体的代码如下:

```java
while (p1 < nums1.length && p2 < nums2.length)
{
	all[position++] = nums1[p1] <= nums2[p2] ? nums1[p1++] : nums2[p2++];
}

if (p1 < nums1.length)
{
	for (int i = p1; i < nums1.length; i++) all[position++] = nums1[i];
}
else
{
	for (int i = p2; i < nums2.length; i++) all[position++] = nums2[i];
}
```

大家看看, 我们是不是这样就可以找到想要的结果了呢. 

因为是顺序遍历, 所以我们整个复杂度在: O(m + n).

完整代码请点击这里: [完整代码](https://github.com/simplemain/leetcode/blob/master/4/Solution2.java)

---

* 解法3 : 二分搜索

最后的这种解法, 真的好难好难想. 我们用上面两种方法, 最快的复杂度也是 O(m + n), 并不满足题目要求的O(log (m+n)).

怎么办呢? 怎么办呢?

看看要求的时间复杂度`O(lgN)`, 再看看条件的`有序`的数组, 以及`中间值`. 想到了啥? 

是不是跟`二分查找`的条件好相似?

那我们来想想是不是可以通过`二分搜索`的思想来解决这个问题.

为了简化问题, 我们先将总个数 `t=m+n` 设定为`偶数`, 奇数的情况其实处理方法类似, 所以暂时不讨论.

从最终结果来看, 那我们要找的中位数`k1`和`k2`, 会将我们合并后的大数组all分成两部分:

```
比如:   nums1 = [1, 3, 4, 6, 7, 8, 10], nums2 = [2, 5, 9]
那么:   all = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
中位数: k1 = 5, k2 = 6

最终的效果就是: [1, 2, 3, 4, 5] | [6, 7, 8, 9, 10]

nums1 被切成 [1, 3, 4] | [6, 7, 8, 10]
nums2 被切成 [2, 5] | [9]
```

很明显, 所谓的找中位数, 无非就是要`找一种切分方法`, 让all数组被`平均`切成数目相等的左右两部分.

要让all左右两边相等, 那就是要去挪动nums1和nums2的切分竖线`|`, 让他们达到一种切分效果, 必须满足以下`两个条件`:

```
1. nums1的左边 + nums2的左边 等于 nums1的右边 + nums2的右边, 即:
nums1.left.count + nums2.left.count == nums1.right.count + nums2.right.count

2. nums1, nums2 的左边所有的数 小于等于 nums1, nums2的右边所有的数, 即:
max(nums1.left, nums2.left) <= min(nums1.right, nums2.right)
```

好了, 接下来我们就去考虑怎么挪动两个数组的分割线了.

最简单的方法, 我们顺序挪动nums1的竖线, 就像下面一样:

```
                    [] | [1, 3, 4, 6, 7, 8, 10]
                   [1] | [3, 4, 6, 7, 8, 10]
                [1, 3] | [4, 6, 7, 8, 10]
                      ...
[1, 3, 4, 6, 7, 8, 10] | []
```

同理, 我们也可以这样挪动nums2的竖线:

```
       [] | [2, 5, 9]
      [2] | [5, 9]
         ...
[2, 5, 9] | []
```

最终, 当他们两的竖线达到我们上面说的`两个要求`的时候, 就算找到结果了, 伪代码如下:

```
for (let line1 = 0; line1 <= nums1.length; line1++)
{
	(n1_left, n1_right) = nums1.split(line1);
	for (let line2 = 0; line <= nums2.length; line2++)
	{
		(n2_left, n2_right) = nums2.split(line2);

		if (n1_left.count + n2_left.count == n1_right.count + n2_right.count &&
			max(n1_left, n2_left) <= min(n1_right, n2_right))
		{
			return calc_result();
		}
	}
}
```

我们看到, 这个算法仍然是O(N ^ 2)的算法. 不过我们可以稍微优化一下:

一旦nums1的切法定下来的时候, nums2的切法也确定了. 为什么呢?

因为`第一个条件`: nums1的左边 + nums2的左边 等于 nums1的右边 + nums2的右边

所以, 我们可以将伪代码稍微改一下:

```
let half_len = totalLen / 2;
for (line1 = 0; line1 <= nums1.length; line1++)
{
	(n1_left, n1_right) = nums1.split(line1);
	if (n1_left.length > half_len || n1_right.length > half_len) continue;

	(n2_left, n2_right) = nums2.split(half_len - n1_left.length);
	
	if (max(n1_left, n2_left) <= min(n1_right, n2_right))
	{
		return calc_result();
	}
}
```

看看, 通过这样的优化, 我们就可以将算法复杂度立马降低为O(N).

接下来, 就是`最关键的一步`了. 我们如何利用`二分查找`的方法优化上面这个逻辑.

我们来看看二分查找的条件:

```
任何情况下, 序列都是`有序`的. (从小到大 或者 从大到小). 这就使得:
以从小到大为例, 任何情况下, a[mid] 只能有以下情况:
a. a[mid] < a[left]
b. a[mid] > a[right]
c. a[left] <= a[mid] <= a[right]
```

好了, 我们再来看看我们这个题目. 数组都是有序的. 

那么, 如果让mid成为划分的线`|`, 他跟左右两边比大小的条件是什么呢?

```
1. 当 左边元素的个数 比 half_len 小 的时候, 说明划分偏左了, 需要把mid往右调整;
   比如: nums1 => [] | [1, 3, 4, 6, 7, 8, 10], 这样即使 nums2 => [2, 5, 9] | []
   左边总数就是小余一半的, 需要把nums1的`|`往右调整;

2. 当 右边元素的个数 比 half_len 小 的时候, 说明划分偏右了, 需要把mid往左调整;
   比如: nums1 => [1, 3, 4, 6, 7, 8, 10] | [], 这样即使 nums2 => [] | [2, 5, 9]
   右边总数就是小余一半的, 需要把nums1的`|`往左调整;

3. 如果两边数目一样的情况下:
   a. 如果达到`条件二`: max(n1_left, n2_left) <= min(n1_right, n2_right), 就可以返回结果了;

   b. 如果 n1_left.last > n2_right.first, 说明左边有元素需要划分到右边, 需要把nums1的`|`往左调整
      比如: 
	  nums1 => [1, 3, 4, 6, 7] | [8, 10]
	  nums2 =>              [] | [2, 5, 9]
	  这里, n1_left.last(=7) > n2_right.first(=2);

   c. 如果 n2_left.last > n1_right.first, 说明右边有元素需要划分到左边, 需要把nums1的`|`往右调整
      比如: 
	  nums1 =>    [1, 3] | [4, 6, 7, 8, 10]
	  nums2 => [2, 5, 9] | []
	  这里, n2_left.last(=9) > n1_right.first(=4);
```

好了, 有了以上条件, 我们就可以写一个`类二分查找`的算法, 找到`mid的位置`. 

不过, 在实现当中, 因为要处理空集合`[]`的情况, 老王在实现的时候, 在左边加了一个哨兵位(-∞), 右边加了一个哨兵位(∞).

因为左右两边各自加了一个, 不会影响中位数的位置. 这样程序上就会更好处理.

当 m+n 为奇数的时候, 我们只需要把中位数放到左边(或者右边), 计算的时候稍微处理一下, 就可以了.

完整代码请点击这里: [完整代码](https://github.com/simplemain/leetcode/blob/master/4/Solution3.java)

---

好了, 这一题就分析到这里. 如果觉得老王的讲解有意思或有帮助, 可以给老王点个赞或者打个赏啥的, 老王就很开心啦~

<div align="center"><img src="https://github.com/simplemain/leetcode/blob/master/qrcode_pay.min.jpg" width="200" height="200" /></div>

咱下一题继续~~
