package Leetcode;

public class PartitionList86 {
	public ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode first = new ListNode(0);
		ListNode temp = first;

		ListNode pre;
		ListNode current = head;
		
		//找到第一个比x大的数
		while(current != null && current.val < x){
			temp.next = current;
			temp = temp.next;
			
			pre = current;
			current = current.next;
		}
		
		if(current == null) return first.next;
		
		temp.next = null;
		
		//比x大的第一个节点
		head = current;
		
		pre = current;
		current = current.next;
		while (current != null) {
			if (current.val < x) {
				temp.next = current;
				temp = temp.next;

				current = current.next;
				pre.next = current;
			} else {
				pre = current;
				current = current.next;
			}
		}

		temp.next = head;

		return first.next;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
