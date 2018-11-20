/**
 * code by : 老王
 * https://github.com/simplemain
 */

public class Solution1
{
	public static void main(String[] args) 
	{
		final String s = "babad";

		final Solution sol = new Solution1().new Solution();
		final String result = sol.longestPalindrome(s);

		System.out.printf("%s\n", result);
	}

	class Solution 
	{
		public String longestPalindrome(String s)
		{
			String res = "";

			for (int i = 0; i < s.length(); i++)
			{
				final String s1 = getSub(s, i, i);
				final String s2 = getSub(s, i, i + 1);

				final String max = s1.length() >= s2.length() ? s1 : s2;
				res = max.length() > res.length() ? max : res;
			}

			return res;
		}

		private String getSub(String s, int left, int right)
		{
			for (; left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right); left--, right++);

			return s.substring(left + 1, right);
		}
	}
}