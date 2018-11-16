public class Solution1
{
	public static void main(String[] args) 
	{
		final int[] nums = {2, 7, 11, 15};
		final int target = 9;

		final Solution sol = new Solution1().new Solution();
		final int[] result = sol.twoSum(nums, target);

		System.out.printf("[%d %d]\n", result[0], result[1]);
	}

	class Solution 
	{
		public int[] twoSum(int[] nums, int target) 
		{
			for (int i = 0; i < nums.length; i++)
			{
				for (int j = i + 1; j < nums.length; j++)
				{
					if (nums[i] + nums[j] == target)
					{
						return new int[] {i, j};
					}
				}
			}
			return null;
		}
	}

}