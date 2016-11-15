package Leetcode;

public class RemoveLinkedListElements {

	public ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return null;
		}
		ListNode res = new ListNode(0);
		res.next = head;

		ListNode pre = res;
		ListNode cur = head;
		while (cur != null) {
			if (cur.val != val) {
				pre = cur;
				cur = cur.next;
			} else {
				cur = cur.next;
				pre.next = cur;
			}
		}
		return res.next;
	}
}
