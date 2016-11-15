package LeetCodeSecondEasy;

import Structure.ListNode;

/**
 * ��ת����
 * 	 1.ʹ�õݹ�ķ���(��ͷ���һ��һ���ͺ���ķ���)
 * @author MG
 *
 */
public class ReverseLinkedList206 {
	
	public ListNode reverseList(ListNode head){
		if(head == null){
			return null;
		}
		
		if(head.next == null){
			return head;
		}
			
		ListNode current = head.next;
		
		ListNode res = reverseList(current);
		
		head.next = null;
		current.next = head;
		
		return res;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
