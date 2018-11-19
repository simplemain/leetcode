/**
 * code by : 老王
 * https://github.com/simplemain
 */

import java.util.Arrays;

public class Solution3
{
	public static void main(String[] args) 
	{
		final int[] nums1 = {1, 2, 3};
		final int[] nums2 = {-1};

		final Solution sol = new Solution3().new Solution();
		final double result = sol.findMedianSortedArrays(nums1, nums2);

		System.out.printf("%g\n", result);
	}

	class Solution 
	{
		public double findMedianSortedArrays(int[] nums1, int[] nums2) 
		{
			final ArrayWrapper a = new ArrayWrapper(nums1.length <= nums2.length ? nums1 : nums2);
			final ArrayWrapper b = new ArrayWrapper(nums1.length > nums2.length ? nums1 : nums2);

			final int aLength = a.len();
			final int bLength = b.len();

			final int totalCount = aLength + bLength;
			final int leftCount  = (totalCount + 1) / 2;

			for (int aHead = 0, aTail = aLength - 1; aHead <= aTail; )
			{
				final int aMid = (aHead + aTail) / 2;

				final int aLeftCount = aMid + 1;
				final int bLeftCount = leftCount >= aLeftCount ? leftCount - aLeftCount : 0;
				final int leftRealCount = aLeftCount + bLeftCount;

				if (leftRealCount < leftCount)
				{
					aHead = aMid + 1;
				}
				else if (leftRealCount > leftCount)
				{
					aTail = aMid;
				}
				else
				{
					int aLeftValue  = a.get(aMid);
					int aRightValue = a.get(aMid + 1);

					int bLeftValue  = b.get(bLeftCount - 1);
					int bRightValue = b.get(bLeftCount);

					if (aLeftValue > bRightValue)
					{
						aTail = aMid;
					}
					else if (aRightValue < bLeftValue)
					{
						aHead = aMid + 1;
					}
					else // (aLeftValue <= bRightValue && bLeftValue <= aRightValue)
					{
						return totalCount % 2 == 0 ? (Math.max(aLeftValue, bLeftValue) + Math.min(aRightValue, bRightValue)) * 0.5 : Math.max(aLeftValue, bLeftValue);
					}
				}
			}

			return 0;
		}

		private class ArrayWrapper
		{
			final int[] array;
			final int len;
			ArrayWrapper(int[] array) { this.array = array; len = array.length + 2; }
			int len() { return len; }
			int get(int idx) { return idx >= 1 && idx < len - 1 ? array[idx - 1] : (idx <= 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE); }
		}
	}
}