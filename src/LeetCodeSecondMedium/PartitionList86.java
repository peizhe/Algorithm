package LeetCodeSecondMedium;

import Structure.ListNode;

public class PartitionList86 {
	public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        
        ListNode left = new ListNode(0), right = new ListNode(0);
        ListNode tempLeft = left, tempRight = right;
        
        while(head != null) {
        	if(head.val < x) {
        		tempLeft.next = head;
        		tempLeft = tempLeft.next;
        	} else {
        		tempRight.next = head;
        		tempRight = tempRight.next;
        	}
        	
        	head = head.next;
        }
        
        tempRight.next = null;
        
        tempLeft.next = right.next;
        
        return left;
    }
}
