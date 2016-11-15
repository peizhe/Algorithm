package LeetCodeSecondEasy;

import Structure.ListNode;


public class MergeTwoSortedLists21 {
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
        	return l2;
        }
        if(l2 == null){
        	return l1;
        }
        
        ListNode res = new ListNode(0);
        ListNode temp = res;
        
        while(l1 != null && l2 != null){
        	if(l1.val <= l2.val){
        		temp.next = l1;
        		l1 = l1.next;
        	}
        	else{
        		temp.next = l2;
        		l2 = l2.next;
        	}
        	
        	temp = temp.next;
        }
        
        if(l1 == null){
        	temp.next = l2;
        }
        if(l2 == null){
        	temp.next = l1;
        }
        
        return res.next;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
