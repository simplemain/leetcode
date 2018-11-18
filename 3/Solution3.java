/**
 * code by : 老王
 * https://github.com/simplemain
 */

import java.util.Arrays;

public class Solution3
{
	public static void main(String[] args) 
	{
		final String s = "abcabcbb";

		final Solution sol = new Solution3().new Solution();
		final int result = sol.lengthOfLongestSubstring(s);

		System.out.printf("%d\n", result);
	}

	class Solution 
	{
		public int lengthOfLongestSubstring(String s) 
		{
			final int len   = s.length();
			final char[] cs = s.toCharArray();
			
			final boolean[] exists = new boolean[256];

			int maxLen = 0;
			for (int p = 0; p < len; p++)
			{
				Arrays.fill(exists, false);
				exists[cs[p]] = true;
				int curLen = 1;

				for (int q = p + 1; q < len; q++)
				{
					final boolean isOK = !exists[cs[q]];
					if (!isOK) break;
					exists[cs[q]] = true;
					curLen++;
				}
				if (curLen > maxLen)
				{
					maxLen = curLen;
				}
			}

			return maxLen;
		}
	}
}