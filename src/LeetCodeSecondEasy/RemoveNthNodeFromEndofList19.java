package LeetCodeSecondEasy;

import Structure.ListNode;

public class RemoveNthNodeFromEndofList19 {
	public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n <= 0){
        	return null;
        }
        if(head.next == null && n == 1){
        	return null;
        }
        
        int len = getSize(head);
        
        ListNode first = new ListNode(0);
        first.next = head;
        ListNode temp = first;
        
        int diff = len - n;
        while(diff > 0){
        	temp = temp.next;
        	diff --;
        }
        temp.next = temp.next.next;
        
        return first.next;
    }
	
	private static int getSize(ListNode head){
		int len = 0;
		while(head != null){
			len ++;
			head = head.next;
		}
		
		return len;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		
		l1.next = l2;
		removeNthFromEnd(l1, 1);
	}

}
