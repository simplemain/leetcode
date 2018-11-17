/**
 * code by : 老王
 * https://github.com/simplemain
 */

public class Solution1
{
	public static void main(String[] args) 
	{
		final ListNode l1 = gen(2, 4, 3);
		final ListNode l2 = gen(5, 6, 4);

		final Solution sol = new Solution1().new Solution();
		final ListNode result = sol.addTwoNumbers(l1, l2);

		for (ListNode ln = result; ln != null; ln = ln.next)
		{
			System.out.printf("%d", ln.val);
			System.out.printf("%s", ln.next == null ? "\n" : " -> ");
		}
	}

	class Solution 
	{
		public ListNode addTwoNumbers(ListNode l1, ListNode l2)
		{
			final ListNode ret = new ListNode(0);
			ListNode pnt = ret;

			int carry = 0;
			for (; l1 != null && l2 != null; l1 = l1.next, l2 = l2.next)
			{
				int n = l1.val + l2.val + carry;
				carry = n / 10;

				pnt.next = new ListNode(n % 10);
				pnt = pnt.next;
			}

			for (ListNode left = l1 == null ? l2 : l1; left != null; left = left.next)
			{
				if (carry == 0)
				{
					pnt.next = left;
					return ret.next;
				}

				int n = left.val + carry;
				carry = n / 10;

				pnt.next = new ListNode(n % 10);
				pnt = pnt.next;
			}

			if (carry > 0) pnt.next = new ListNode(carry);

			return ret.next;
		}
	}

	/**
	 * Definition for singly-linked list.
	 */ 
	public static class ListNode 
	{
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
 	private static ListNode gen(int ... numbers)
	{
		final ListNode head = new ListNode(0);
		ListNode pnt = head;
		for (int n : numbers)
		{
			pnt.next = new ListNode(n);
			pnt = pnt.next;
		}
		return head.next;
	}
}