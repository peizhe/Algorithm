package LeetCodeSecondEasy;

import Structure.ListNode;

/**
 * 反转链表：
 * 	 1.使用递归的方法(从头结点一个一个和后面的分离)
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
