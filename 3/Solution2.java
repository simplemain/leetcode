/**
 * code by : 老王
 * https://github.com/simplemain
 */

import java.util.Set;
import java.util.HashSet;

public class Solution2
{
	public static void main(String[] args) 
	{
		final String s = "abcabcbb";

		final Solution sol = new Solution2().new Solution();
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
			for (int p = 0; p < len; p++)
			{
				final Set<Character> exists = new HashSet<>();
				exists.add(cs[p]);

				for (int q = p + 1; q < len; q++)
				{
					final boolean isOK = !exists.contains(cs[q]);
					if (!isOK) break;
					exists.add(cs[q]);
				}
				final int curLen = exists.size();
				if (curLen > maxLen)
				{
					maxLen = curLen;
				}
			}

			return maxLen;
		}
	}
}