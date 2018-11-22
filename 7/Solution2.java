/**
 * code by : 老王
 * https://github.com/simplemain
 */

import java.util.Arrays;

public class Solution2
{
	public static void main(String[] args) 
	{
		final int num = 1234567899;

		final Solution sol = new Solution2().new Solution();
		final int result = sol.reverse(num);

		System.out.printf("%d\n", result);
	}

	class Solution 
	{
		private static final int SEP = 10000;

		public int reverse(int x)
		{
			int upper = 0, lower = 0;
			final int d = x >= 0 ? 1 : -1;
			
			for (x *= d; x > 0; x /= 10)
			{
				final int r = x % 10;

				lower = lower * 10 + r;
				upper = upper * 10 + lower / SEP;
				lower %= SEP;

				if (d > 0 && upper >= Integer.MAX_VALUE / SEP && lower > Integer.MAX_VALUE % SEP) return 0;
				if (d < 0 && upper >= -(Integer.MIN_VALUE / SEP) && lower > -(Integer.MIN_VALUE % SEP)) return 0;
			}

			return d * (upper * SEP + lower);
		}
	}
}