/**
 * code by : 老王
 * https://github.com/simplemain
 */

import java.util.Arrays;

public class Solution2
{
	public static void main(String[] args) 
	{
		final String s = "PAYPALISHIRING";
		final int n = 4;

		final Solution sol = new Solution2().new Solution();
		final String result = sol.convert(s, n);

		System.out.printf("%s\n", result);
	}

	class Solution 
	{
		public String convert(String s, int n)
		{
			final int length = s.length();
			final char[] res = new char[length];
			final int period = n == 1 ? 1 : 2 * n - 2;

			for (int i = 0, idx = 0; i < n && idx < length; i++)
			{
				for (int p1 = i, p2 = period - i; p1 < length || p2 < length ; p1 += period, p2 += period)
				{
					if (p1 < length) res[idx++] = s.charAt(p1);
					if (i != 0 && i != n - 1 && p2 < length) res[idx++] = s.charAt(p2);
				}
			}
			return new String(res);
		}
	}
}
