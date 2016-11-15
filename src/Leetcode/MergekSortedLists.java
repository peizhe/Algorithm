package Leetcode;

public class MergekSortedLists {

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}
		if (lists.length == 1) {
			return lists[0];
		}

		ListNode res = mergeKListHelp(lists, 0, lists.length - 1);
		return res;
	}

	public ListNode mergeKListHelp(ListNode[] lists, int begin, int end) {
		if (begin + 1 == end) {
			return merge2List(lists[begin], lists[end]);
		}

		if (begin == end) {
			return lists[begin];
		}

		int mid = begin + (end - begin) / 2;
		ListNode left = mergeKListHelp(lists, begin, mid - 1);
		ListNode right = mergeKListHelp(lists, mid, end);

		return merge2List(left, right);
	}

	// ÈÚºÏ2¸öÁ´±í
	public ListNode merge2List(ListNode first, ListNode second) {
		ListNode head = new ListNode(-1);
		ListNode res = head;
		while (first != null || second != null) {
			if (first == null) {
				res.next = second;
				return head.next;
			}

			if (second == null) {
				res.next = first;
				return head.next;
			}

			boolean flag = first.val <= second.val;
			if (flag) {
				res.next = first;
				first = first.next;
				res = res.next;
			} else {
				res.next = second;
				second = second.next;
				res = res.next;
			}
		}

		return head.next;
	}
}
