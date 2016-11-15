package Leetcode;
//快慢指针的应用
public class LinkedListCycle {
	public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) 
       {
          val = x;
          next = null;
       }
	}
 
	public boolean hasCycle(ListNode head) {
		if(head == null || head.next == null) {
			return false;
		}
		ListNode slow,fast;
		slow = head;
		fast = head;
        while(fast.next != null && fast.next.next != null)
        {
        	slow = slow.next;
        	fast = fast.next.next;
        	if(slow == fast)
        	{
        		return true;
        	}	
        }
        return false;
    }	
}
