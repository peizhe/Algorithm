package Leetcode;

public class RemoveDuplicatesfromSortedListII {

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newHead = new ListNode(-1);
		newHead.next = head;
		ListNode p1 = newHead;
		ListNode p2 = head;
		while (p2 != null) {
			boolean dup = false;
			while (p2.next != null && p2.val == p2.next.val) {
				dup = true;
				p2 = p2.next;
			}
			if (dup) {
				p2 = p2.next;
				continue;
			}
			p1.next = p2;
			p1 = p1.next;
			p2 = p2.next;
		}
		p1.next = p2;
		
		return newHead.next;
	}
	/**
	 * @author mh
	 * @自己运行没错，就是过不去leetcode
	 * */
	// public ListNode deleteDuplicates(ListNode head) {
	// if(head == null || head.next == null)
	// {
	// return head;
	// }
	// ListNode res = new ListNode(0);
	// ListNode cur = res;
	// for(int i = 1;i < getLength(head);i ++)
	// {
	// if(getIndex(head, i) == getIndex(head, i - 1))
	// {
	// continue;
	// }
	// else
	// {
	// if(i == 1)
	// {
	// cur.next = getIndex(head, i - 1);
	// cur = cur.next;
	// }
	// cur.next = getIndex(head, i);
	// cur = cur.next;
	// }
	// }
	// return res.next;
	// }
	//
	// public ListNode getIndex(ListNode head,int index)
	// {
	// for(int i = 0;i < index;i ++)
	// {
	// head = head.next;
	// }
	// return head;
	// }
	//
	// public int getLength(ListNode head)
	// {
	// int res = 0;
	// while(head != null)
	// {
	// res ++;
	// head = head.next;
	// }
	// return res;
	// }
}
