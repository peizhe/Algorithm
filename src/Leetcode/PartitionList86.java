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
		
		//�ҵ���һ����x�����
		while(current != null && current.val < x){
			temp.next = current;
			temp = temp.next;
			
			pre = current;
			current = current.next;
		}
		
		if(current == null) return first.next;
		
		temp.next = null;
		
		//��x��ĵ�һ���ڵ�
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
