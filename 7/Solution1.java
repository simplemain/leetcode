/**
 * code by : 老王
 * https://github.com/simplemain
 */

import java.util.Arrays;

public class Solution1
{
	public static void main(String[] args) 
	{
		final int num = 123;

		final Solution sol = new Solution1().new Solution();
		final int result = sol.reverse(num);

		System.out.printf("%d\n", result);
	}

	class Solution 
	{
		public int reverse(int x)
		{
			final int d = x >= 0 ? 1 : -1;
			x *= d;
			
			long ret = 0;
			for (; x > 0; ret = ret * 10 + x % 10, x /= 10);
			ret *= d;

			return (ret > Integer.MAX_VALUE || ret < Integer.MIN_VALUE) ? 0 : (int)ret;
		}
	}
}