/**
 * code by : 老王
 * https://github.com/simplemain
 */

public class Solution4
{
	public static void main(String[] args) 
	{
		final String s = "abcabcbb";

		final Solution sol = new Solution4().new Solution();
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

			final boolean[] exists = new boolean[256];
			int curLen = 0;
			int left = 0;
			for (int right = 0; right < len; right++)
			{
				final char c = cs[right];
				if (exists[c])
				{
					for (int j = left; j < right; j++)
					{
						exists[cs[j]] = false;
						curLen--;
						
						if (cs[j] == c)
						{
							left = j + 1;
							break;
						}
					}
				}
				exists[c] = true;
				curLen++;
				if (curLen > maxLen)
				{
					maxLen = curLen;
				}
			}

			return maxLen;
		}
	}
}