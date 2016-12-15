package Leetcode;
/**
 * 只是年轻太幼稚，代码写的一塌糊涂
 * 
 * @author Administrator
 *
 */
public class SortList {

	public ListNode sortList(ListNode head) {
		if (head == null) {
			return null;
		}
		if (len(head) == 1) {
			return head;
		}
		ListNode head1 = head;
		ListNode head2 = getmid(head1);

		ListNode left = sortList(head1);
		ListNode right = sortList(head2);
		return merge(left, right);
	}

	public ListNode merge(ListNode head1, ListNode head2) {
		ListNode result = new ListNode(0);
		ListNode temp = result;
		while (head1 != null || head2 != null) {
			if (head1 == null) {
				temp.next = head2;
				break;
			}
			if (head2 == null) {
				temp.next = head1;
				break;
			}

			if (head1.val < head2.val) {
				temp.next = head1;
				head1 = head1.next;
			} else {
				temp.next = head2;
				head2 = head2.next;
			}
			temp = temp.next;
		}
		return result.next;
	}

	public ListNode getmid(ListNode head) {
		int length = len(head);
		if (length == 1) {
			return head;
		}
		ListNode head2 = head;
		ListNode pre = head;
		int cycle = len(head) / 2;
		while (cycle > 0) {
			pre = head2;
			head2 = head2.next;
			cycle--;
		}
		pre.next = null;// 截断原链表

		return head2;
	}

	public int len(ListNode head) {
		int len = 0;
		while (head != null) {
			len++;
			head = head.next;
		}
		return len;
	}
}
