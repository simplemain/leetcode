import java.util.Arrays;

public class Solution2
{
	public static void main(String[] args) 
	{
		final int[] nums = {2, 7, 11, 15};
		final int target = 9;

		final Solution sol = new Solution2().new Solution();
		final int[] result = sol.twoSum(nums, target);

		System.out.printf("[%d %d]\n", result[0], result[1]);
	}

	class Solution 
	{
		public int[] twoSum(int[] nums, int target) 
		{
			final Node[] nodes = new Node[nums.length];
			for (int i = 0; i < nums.length; i++)
			{
				nodes[i] = new Node(nums[i], i);
			}

			Arrays.sort(nodes);

			for (int i = 0; i < nodes.length - 1; i++)
			{
				final int left = target - nodes[i].value;
				final int res = Arrays.binarySearch(nodes, i + 1, nodes.length, new Node(left, 0));
				if (res >= 0 && res < nodes.length)
				{
					return new int[]{nodes[i].idx, nodes[res].idx};
				}
			}
			return null;
		}

		private class Node implements Comparable<Node>
		{
			int value;
			int idx;
			
			Node(int v, int i)
			{
				value = v;
				idx = i;
			}

			public int compareTo(Node o)
			{
				return value - o.value;
			}
		}
	}

}