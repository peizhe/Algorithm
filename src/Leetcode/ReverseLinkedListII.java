package Leetcode;

public class ReverseLinkedListII {

	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (m == n) {
			return head;
		}
		while (m < n) {
			int temp = getIndex(head, n - 1).val;
			getIndex(head, n - 1).val = getIndex(head, m - 1).val;
			getIndex(head, m - 1).val = temp;

			m++;
			n--;
		}
		
		return head;
	}

	public int getLength(ListNode head) {
		int res = 0;
		while (head != null) {
			res++;
			head = head.next;
		}
		return res;
	}

	public ListNode getIndex(ListNode head, int index) {
		for (int i = 0; i < index; i++) {
			head = head.next;
		}
		return head;
	}
}
