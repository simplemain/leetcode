/**
 * code by : 老王
 * https://github.com/simplemain
 */

import java.util.Arrays;

public class Solution5
{
	public static void main(String[] args) 
	{
		final String s = "tmmzuxt";

		final Solution sol = new Solution5().new Solution();
		final int result = sol.lengthOfLongestSubstring(s);

		System.out.printf("%d\n", result);
	}

	class Solution 
	{
		public int lengthOfLongestSubstring(String s) 
		{
			final int len   = s.length();
			final char[] cs = s.toCharArray();
			
			int maxLen = 0;

			final int[] position = new int[256];
			Arrays.fill(position, -1);
			
			for (int left = 0, right = 0; right < len; right++)
			{
				final char c = cs[right];
				if (position[c] >= left)
				{
					left = position[c] + 1;
				}

				position[c] = right;
				final int curLen = right - left + 1;
				if (curLen > maxLen)
				{
					maxLen = curLen;
				}
			}

			return maxLen;
		}
	}
}