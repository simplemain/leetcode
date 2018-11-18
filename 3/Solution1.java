/**
 * code by : 老王
 * https://github.com/simplemain
 */

public class Solution1
{
	public static void main(String[] args) 
	{
		final String s = "abcabcbb";

		final Solution sol = new Solution1().new Solution();
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
				for (int q = p; q < len; q++)
				{
					final boolean isOK = judge(cs, p, q);
					if (!isOK) break;
					final int curLen = q - p + 1;
					if (curLen > maxLen)
					{
						maxLen = curLen;
					}
				}
			}

			return maxLen;
		}

		private boolean judge(final char[] cs, int p, int q)
		{
			for (int i = p; i < q; i++)
			{
				if (cs[i] == cs[q]) return false;
			}
			return true;
		}
	}

}