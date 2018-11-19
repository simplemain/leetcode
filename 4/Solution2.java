/**
 * code by : 老王
 * https://github.com/simplemain
 */

import java.util.Arrays;

public class Solution2
{
	public static void main(String[] args) 
	{
		final int[] nums1 = {1, 3};
		final int[] nums2 = {2,4};

		final Solution sol = new Solution2().new Solution();
		final double result = sol.findMedianSortedArrays(nums1, nums2);

		System.out.printf("%g\n", result);
	}

	class Solution 
	{
		public double findMedianSortedArrays(int[] nums1, int[] nums2)
		{
			final int totalLength = nums1.length + nums2.length;
			final int[] all = new int[totalLength];

			int position = 0, p1 = 0, p2 = 0;

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

			// 把奇数和偶数情况合并. 奇数情况下, (totalLength - 1) / 2 == (totalLength) / 2
			return 0.5 * (all[(totalLength - 1) / 2] + all[(totalLength) / 2]);
		}
	}
}