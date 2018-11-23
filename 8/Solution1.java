/**
 * code by : 老王
 * https://github.com/simplemain
 */

import java.util.Arrays;

public class Solution1
{
	public static void main(String[] args) 
	{
		final String s = "123";

		final Solution sol = new Solution1().new Solution();
		final int result = sol.myAtoi(s);

		System.out.printf("%d\n", result);
	}

	class Solution 
	{
		char[] cs   = null;
		int len     = 0;
		int pnt     = 0;
		long result = 0;
		int neg     = 1;
		
		public int myAtoi(String str) 
		{
			if (str == null || str.length() == 0) return 0;
			
			cs     = str.toCharArray();
			len    = cs.length;
			pnt    = 0;
			result = 0;
			
			boolean res = true;
			
			res = processSpace();
			if (!res) return 0;
			
			res = processMinus();
			if (!res) return 0;
			
			res = processNumber();
			if (!res) return 0;
			
			int ret = getResult();
			
			return ret;
		}
		
		private boolean processSpace()
		{
			while (pnt < len && cs[pnt] == ' ') pnt++;
			return true;
		}
		
		private boolean processMinus()
		{
			if (pnt >= len) return true;
			
			if (cs[pnt] == '-')
			{
				neg = -1;
				pnt++;
			}
			else if (cs[pnt] == '+')
			{
				neg = 1;
				pnt++;
			}
			
			return true;
		}
		
		private boolean processNumber()
		{
			if (pnt >= len) return false;
			if (cs[pnt] < '0' || cs[pnt] > '9') return false;
			
			while (pnt < len && (cs[pnt] >= '0' && cs[pnt] <= '9'))
			{
				int k = cs[pnt] - '0';
				result = result * 10 + k;
				long r = result * neg;
				if (r > Integer.MAX_VALUE || r < Integer.MIN_VALUE)
				{
					return true;
				}
				pnt++;
			}
			
			return true;
		}
		
		private int getResult()
		{
			long r = result * neg;
			if (r > Integer.MAX_VALUE) return Integer.MAX_VALUE;
			if (r < Integer.MIN_VALUE) return Integer.MIN_VALUE;
			return (int)r;
		}
	}
}