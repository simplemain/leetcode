/**
 * code by : 老王
 * https://github.com/simplemain
 */

import java.util.Arrays;

public class Solution1
{
	public static void main(String[] args) 
	{
		final String s = "PAYPALISHIRING";
		final int n = 4;

		final Solution sol = new Solution1().new Solution();
		final String result = sol.convert(s, n);

		System.out.printf("%s\n", result);
	}

	class Solution 
	{
		public String convert(String s, int n)
		{
			if (n == 1) return s;

			final int maxHeight = Math.min(s.length(), n);
			final int maxWidth  = s.length();

			final char[][] matrix = new char[maxHeight][];
			for (int i = 0; i < matrix.length; i++) matrix[i] = new char[maxWidth];

			final int[] pos = new int[maxHeight];
			Arrays.fill(pos, 0);

			for (int rowNum = 0, direct = 1, p = 0; p < s.length(); p++, rowNum += direct)
			{
				if (rowNum >= n || rowNum < 0)
				{
					direct *= -1;
					rowNum += 2 * direct;
				}

				matrix[rowNum][pos[rowNum]++] = s.charAt(p);
			}

			final char[] res = new char[s.length()];
			for (int i = 0, p = 0; i < maxHeight; i++)
			{
				for (int j = 0; j < pos[i]; j++)
				{
					res[p++] = matrix[i][j];
				}
			}

			return new String(res);
		}
	}
}
