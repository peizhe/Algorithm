package Leetcode;

public class RemoveDuplicatesfromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pre = head;
		ListNode cur = head.next;
		while (cur != null) {
			if (cur.val == pre.val) {
				cur = cur.next;
				pre.next = cur;
			} else {
				pre = cur;
				cur = cur.next;
			}
		}
		return head;
	}
}
