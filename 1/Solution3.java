import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution3
{
	public static void main(String[] args) 
	{
		final int[] nums = {2, 7, 11, 15};
		final int target = 9;

		final Solution sol = new Solution3().new Solution();
		final int[] result = sol.twoSum(nums, target);

		System.out.printf("[%d %d]\n", result[0], result[1]);
	}

	class Solution 
	{
		public int[] twoSum(int[] nums, int target) 
		{
			// map用来存放 value -> idx 的对应, 但是有可能多个元素的值是一样的, 所以要用list来存放
			final HashMap<Integer, List<Integer>> map = new HashMap<>(); 

			for (int i = 0; i < nums.length; i++)
			{
				final int num = nums[i];
				if (!map.containsKey(num)) map.put(num, new ArrayList<>());
				final List<Integer> list = map.get(num);
				list.add(i);
			}

			for (int i = 0; i < nums.length; i++)
			{
				final int left = target - nums[i];
				final List<Integer> list = map.get(left);
				if (list == null) continue;
				
				for (Integer idx : list)
				{
					if (idx != i)
					{
						return new int[]{i, idx};
					}
				}
				
			}
			return null;
		}
	}

}