package LeetCodeSecondMedium;

import java.util.Random;

import Structure.ListNode;

public class LinkedListRandomNode382 {
	
	private Random random;
	private ListNode head;
	
	/** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
	public LinkedListRandomNode382(ListNode head) {
	    random = new Random();
	    this.head = head;
	}
	
	/** Returns a random node's value. */
	public int getRandom() {
		ListNode temp = head.next;
		int res = head.val;
		int count = 1;
		
	    while(temp != null) {
	    	if(random.nextInt(++count) == 0) res = temp.val;
	    	
	    	temp = temp.next;
	    }
	    
	    return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
