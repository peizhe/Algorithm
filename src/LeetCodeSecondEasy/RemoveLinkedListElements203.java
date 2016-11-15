package LeetCodeSecondEasy;

import Structure.ListNode;

public class RemoveLinkedListElements203 {
	public ListNode removeElements(ListNode head, int val) {
        if(head == null){
        	return null;
        }
        
        ListNode first = new ListNode(0);
        first.next = head;
        ListNode temp = first;
        
        while(temp.next != null){
        	if(temp.next.val == val){
        		temp.next = temp.next.next;
        	}else{
        		temp = temp.next;
        	}
        }
        
        return first.next;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
