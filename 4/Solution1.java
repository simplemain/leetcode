/**
 * code by : 老王
 * https://github.com/simplemain
 */

import java.util.Arrays;

public class Solution1
{
	public static void main(String[] args) 
	{
		final int[] nums1 = {1, 3};
		final int[] nums2 = {2};

		final Solution sol = new Solution1().new Solution();
		final double result = sol.findMedianSortedArrays(nums1, nums2);

		System.out.printf("%g\n", result);
	}

	class Solution 
	{
		public double findMedianSortedArrays(int[] nums1, int[] nums2)
		{
			final int totalLength = nums1.length + nums2.length;
			final int[] all = new int[totalLength];
			
			for (int i = 0; i < nums1.length; i++) all[i] = nums1[i];
			for (int i = 0; i < nums2.length; i++) all[i + nums1.length] = nums2[i];

			Arrays.sort(all);

			final int mid = totalLength / 2;

			return totalLength % 2 == 0 ? (all[mid - 1] + all[mid]) * 0.5 : all[mid];
		}
	}
}